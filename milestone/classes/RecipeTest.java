package milestone.classes;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class RecipeTest {

	/**
 	* @param args the command line arguments
 	*/
	public static void main(String[] args) {
		// Create two recipe objects first
		Recipe myFirstRecipe = new Recipe();
		ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient> (); 
		ArrayList<Ingredient> recipeIngredientsTwo = new ArrayList<Ingredient>(); 
		String ingredientName = "Anchovies";
		
		Ingredient tempIngredient = new Ingredient().addNewIngredient(ingredientName);
		recipeIngredients.add(tempIngredient);
      
    	Recipe mySecondRecipe = new Recipe("Pizza", 2, recipeIngredients, 300);
   	 
    	// Initialize first recipe
		String ingredientNameTwo = "Noodles";
		Ingredient tempIngredientTwo = new Ingredient().addNewIngredient(ingredientNameTwo);
		recipeIngredientsTwo.add(tempIngredientTwo);

    	myFirstRecipe.setRecipeName("Ramen");
    	myFirstRecipe.setServings(2);
    	myFirstRecipe.setRecipeIngredients(recipeIngredientsTwo);
    	myFirstRecipe.setTotalRecipeCalories(150);
   	 
    	// Print details of both recipes
    	myFirstRecipe.printRecipe();
    	mySecondRecipe.printRecipe();
	}
    
}
