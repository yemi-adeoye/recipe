package milestone.classes;

import java.util.Scanner;

import java.util.ArrayList;

public class Recipe {

    private String recipeName; // holds the name of the recipe
    private int servings; // holds the number of persons the recipe will serve
    private ArrayList<Ingredient> recipeIngredients; // holds a list of ingredients for the recipe
    private double totalRecipeCalories; // holds the total number of calories for the recipe
    private double totalRecipeCost; // holds the total cost of the recipe

    public Recipe() {
    }
    
    /**
     * 
     * @param recipeName: name of the recipe
     * @param servings: number of persons the recipe serve
     * @param recipeIngredients: list of ingredients for the recipe
     */
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;

        this.setTotalRecipeCalories();
        this.setTotalRecipeCost();
    }
    
    /**
     * 
     * @param recipeName: name of the recipe
     * @param servings: number of persons the recipe serve
     * @param recipeIngredients: list of ingredients for the recipe
     * @param totalRecipeCalories: total calories for the recipe
     * @param totalRecipeCost: total cost of the recipe
     */
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories,
            double totalRecipeCost) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
        this.totalRecipeCost = totalRecipeCost;
    }

    /**
     * 
     * @return the recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * 
     * @param recipeName: name of the recipe
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * 
     * @return the number of servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * 
     * @param servings: number of persons the recipe serves
     */
    public void setServings(int servings) {
        this.servings = servings;
    }


    /**
     * 
     * @return a list of recipe ingredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * 
     * @param recipeIngredients: list of ingredients for the recipe
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * 
     * @return the total recipe calories
     */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    /**
     * Sets total calories of recipe without params
     */
    public void setTotalRecipeCalories(){
        for (Ingredient ingredient :recipeIngredients){
            totalRecipeCalories += ingredient.getTotalCalories();
        }
    }


    public void setTotalRecipeCost(){
        for (Ingredient ingredient :recipeIngredients){
            totalRecipeCost += ingredient.getTotalCost();
        }
    }
    /**
     * 
     * @return the total cost of the recipe
     */
    public double getTotalRecipeCost(){
        
        return totalRecipeCost;
    }

    
    /**
     * 
     * @param totalRecipeCalories
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    
    public void printRecipe() {

        float singleServingCalories = (float) (totalRecipeCalories / servings); // holds the number of calories per servings

        // prints the recipe information
        System.out.println("------------------------------");
        System.out.println("RECIPE DETAILS");
        System.out.println("------------------------------");
        System.out.println("RECIPE NAME: " + recipeName);
        System.out.println("This recipe Serves: " + servings + " persons");
        System.out.println("Each serving has " + singleServingCalories + " calories");
        System.out.println("TOTAL RECIPE COST: $" + getTotalRecipeCost());
        System.out.println("TOTAL RECIPE CALORIES: $" + getTotalRecipeCalories());
        System.out.println();
        System.out.println("INGREDIENT LIST");
        System.out.println("------------------------------");
        int count = 0;
        for (Ingredient recipeIngredient : recipeIngredients) {
            ++count;
            System.out.println("Ingredient " + count + ":");
            

            System.out.println("Ingredient Name: " + recipeIngredient.getNameOfIngredient());
            String pluralize = recipeIngredient.getNumUnits() == 1 ? "" : "s";
            System.out.println("Quantity: " + recipeIngredient.getNumUnits() 
                    + " " + recipeIngredient.getUnitOfMeasurement() + pluralize);

            // display calories information
            System.out.println("Calories per unit: " + recipeIngredient.getNumberCaloriesPerUnit());
            System.out.println("Total ingredient calories: " + recipeIngredient.getTotalCalories());

            // display cost information
            System.out.println("Each ingredient unit costs: $" + recipeIngredient.getUnitCost());
            System.out.println("Total ingredient cost: $" + recipeIngredient.getTotalCost());
            System.out.println();
        }
        System.out.println();
        

    }

    public static Recipe createRecipe() {
        ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>(); // holds list of ingredients
        
        boolean addMoreIngredients = true; // flag to determines if more ingredients should be added or not

        Scanner scnr = new Scanner(System.in); // to handle user input

        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();

        System.out.println("Please enter the number of servings: ");
        int servings = scnr.nextInt();

        scnr.nextLine();

        do {
            System.out.println("Type end and press ENTER to quit" +
                    " or press ENTER to continue entering ingredients...");

            String userResponse = scnr.nextLine();

            if (userResponse.toLowerCase().equals("end")) {
                addMoreIngredients = false;
            } else {

                // create new instance of ingredient
                Ingredient newIngredient = new Ingredient();

                // retrieve valid ingredient name from user
                newIngredient.setNameOfIngredient(Ingredient.validateNameOfIngredient(scnr));

                // get the ingredient units
                newIngredient.setUnitOfMeasurement(Ingredient.validateUnitOfMeasurement(scnr));

                // get ingredient quantity
                newIngredient.setNumUnits(Ingredient.validateNumberOfUnits(scnr));

                // get unit cost
                newIngredient.setUnitCost(Ingredient.validateUnitCost(scnr));

                // compute total cost for ingredient
                newIngredient.setTotalCost();

                // get calories per units
                newIngredient.setNumberCaloriesPerUnit(Ingredient.validateNumberOfCaloriesPerUnit(scnr));

                // set the total number of calories for the given ingredient
                newIngredient.setTotalCalories();
                
                // add the ingredient to list of ingredients
                recipeIngredients.add(newIngredient);

                // compute total recipe calories
                //totalRecipeCalories += newIngredient.getTotalCalories();

            }

        } while (addMoreIngredients);

        scnr.close(); // clean up

        // create new recipe
        Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients);
        
        return recipe1;

        
    }

    public static void main(String[] args) {
        Recipe myRecipe = Recipe.createRecipe();

        myRecipe.printRecipe();
    }

    public void setTotalRecipeCost(double totalRecipeCost) {
        this.totalRecipeCost = totalRecipeCost;
    }
}

