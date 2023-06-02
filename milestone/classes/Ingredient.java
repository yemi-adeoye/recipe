package milestone.classes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *@author Adeyemi Adeoye
 * ------------------------------------------------------------------------
 * Assignment: MileStone 1
 * Instructor: Ricki Sethi
 * IT 511: Object Oriented App Development
 * May 18, 2023
 * Course Code IT 511
 * 
 */

/**
 * ----------------------------------------------------------------
 * @param nameOfIngredient:      string representaing name of the ingredient
 * @param unitOfMeasurement:     string representing unit of measurement of the
 *                               ingredient
 * @param numberUnits:           float representing the number of units e.g cups
 * @param numberCaloriesPerUnit: integer representing the number of calories per
 *                               unit
 * @param totalCalories:         double representing the total number of
 *                               calories for all of an ingredients measurement
 * -----------------------------------------------------------------
 */

public class Ingredient {
    String nameOfIngredient; // holds the name of the ingredient
    String unitOfMeasurement; // holds the unit of measurement of the ingredient
    float numUnits; // holds how many of the above unit is needed
    int numberCaloriesPerUnit; // holds the number of calories per unit
    double totalCalories; // holds the total number of calories for the ingredient
    float unitCost;
    double totalCost;

    // point of entry for code execution
    public static void main(String args[]) {
        // display welcome message
        System.out.println("Welcome to the ingredient class. Kindly follow the prompt");

        // determines if the user should be prompted for more ingredients
        boolean createMore = true;

        // for handling user input
        Scanner scnr = new Scanner(System.in);

        // stores one of more ingredient objects
        ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();

        do {
            // create new ingredient object
            Ingredient newIngredient = new Ingredient();

            // set the name of the ingredient after validation
            newIngredient.setNameOfIngredient(validateNameOfIngredient(scnr));

            // set the unit of measurement
            newIngredient.setUnitOfMeasurement(validateUnitOfMeasurement(scnr));

            // set the number of units after validation
            newIngredient.setNumUnits(validateNumberOfUnits(scnr));

            // set the number of calories per unit after validation
            newIngredient.setNumberCaloriesPerUnit(validateNumberOfCaloriesPerUnit(scnr));

            // calculate total calories
            newIngredient.setTotalCalories();

            // append new ingredient to list
            listOfIngredients.add(newIngredient);

            // get user choice - create more or no?
            System.out.println("Would you like to create more? Enter y for Yes and n for No");
            String more = scnr.next().toUpperCase();
            scnr.nextLine(); // jump to next line

            if (more.equals("Y")) { // create more

            } else if (more.equals("N")) { // done
                createMore = false;
            } else {
                System.out.println("invalid option"); // user response is not y and is not n
                continue;
            }
        } while (createMore);

        for (Ingredient ingredient : listOfIngredients){
            System.out.println(ingredient);
        }
    }

    /**
     * 
     * @param scnr
     * @return valid name of ingredient
     */
    public static String validateNameOfIngredient(Scanner scnr) {
        String nameOfIngredient;
        boolean isValid = false;

        do {
            System.out.println("Enter the name of the ingredient");

            nameOfIngredient = scnr.nextLine();

            if (nameOfIngredient.length() >= 3) {
                isValid = true;
            } else {
                System.out.println("An ingredient's name must have 3 characters at least");
            }
        } while (isValid == false);

        return nameOfIngredient;

    }

    /**
     * 
     * @param scnr
     * @return valid unit of measurement
     */
    public static String validateUnitOfMeasurement(Scanner scnr) {
        String unitOfMeasurement;
        boolean isValid = false;

        do {
            System.out.println("Enter the unit of measurement of the ingredient eg cups");

            unitOfMeasurement = scnr.nextLine().trim();

            if (unitOfMeasurement.length() >= 1) {
                for (char x : unitOfMeasurement.toCharArray()){
                    if(!Character.isLetter(x)){
                        System.out.println("Try again - Unit of measurement must have only characters");
                        break;
                    }else{
                        isValid = true;
                    }
                }  
            } else {
                System.out.println("Try again - An ingredient's unit of measuerement must have 1 character at least");
            }
        } while (isValid == false);

        return unitOfMeasurement;

    }

    /**
     * 
     * @param scnr
     * @return valid number of units
     */
    public static float validateNumberOfUnits(Scanner scnr) {
        float numCups = 0;
        boolean isValid = false;

        do {
            System.out.println("How many of this units is needed?");

            try {
                numCups = Float.parseFloat(scnr.nextLine());

                isValid = true;

            } catch (Exception e) {
                System.out.println("Enter a valid number of units e.g. 1.5");
            }

        } while (isValid == false);

        return numCups;
    }

    /**
     * 
     * @param scnr
     * @return valid number of calories per unit
     */
    public static int validateNumberOfCaloriesPerUnit(Scanner scnr) {
        int numCups = 0;
        boolean isValid = false;

        do {
            System.out.println("Enter the number of calories for each unit of this ingredient");

            try {
                numCups = Integer.parseInt(scnr.nextLine());

                isValid = true;

            } catch (Exception e) {
                System.out.println("Integers only allowed. Enter a valid integet eg 12");
            }

        } while (isValid == false);

        return numCups;
    }

    public static float validateUnitCost(Scanner scnr) {
        float unitCost = 0.0f;
        boolean isValid = false;

        do {
            System.out.println("Enter the cost for each unit of this ingredient");

            try {
                unitCost = Float.parseFloat(scnr.nextLine());

                isValid = true;

            } catch (Exception e) {
                System.out.println("Only numeric values allowed. e.g 12.50, 2.0, 1.99");
            }

        } while (isValid == false);

        return unitCost;
    }

    public Ingredient() {
    }

    public Ingredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void setTotalCalories() {
        this.totalCalories = this.numUnits * this.numberCaloriesPerUnit;
    }

    public float getNumUnits() {
        return numUnits;
    }

    public void setNumUnits(float numUnits) {
        this.numUnits = numUnits;
    }

    public int getNumberCaloriesPerUnit() {
        return numberCaloriesPerUnit;
    }

    public void setNumberCaloriesPerUnit(int numberCaloriesPerUnit) {
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }

    @Override
    public String toString() {
        return "Ingredient [nameOfIngredient=" + nameOfIngredient + ", unitOfMeasurement=" + unitOfMeasurement
                + ", numUnits=" + numUnits + ", numberCaloriesPerUnit=" + numberCaloriesPerUnit + ", totalCalories="
                + totalCalories + "]";
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalCost(){
        totalCost = 1.0 * numUnits * unitCost;
    }

    
}
