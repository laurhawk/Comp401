package a3;

import java.util.Scanner;

public class A3Jedi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numOfIngredients = scan.nextInt();
		Ingredient[] ingredient = new IngredientImpl[numOfIngredients];

		for (int i = 0; i < numOfIngredients; i++) {
			String name = scan.next();
			double pricePerOunce = scan.nextDouble();
			boolean isVegetarian = scan.nextBoolean();
			int caloriesPerOunce = scan.nextInt();
			IngredientImpl ing = new IngredientImpl(name, pricePerOunce, caloriesPerOunce, isVegetarian);
			ingredient[i] = ing;
			// System.out.println(ingredientName[i]);

		}

		int numOfRecipes = scan.nextInt();
		MenuItem[] recipe = new MenuItem[numOfRecipes];
		
		for (int i = 0; i < numOfRecipes; i++) {
			String nameOfRecipe = scan.next();
			int howManyIngredientsIn = scan.nextInt();
			IngredientPortion[] ingredientsWithin = new IngredientPortion[howManyIngredientsIn];

			for (int j = 0; j < howManyIngredientsIn; j++) {
				String foodName = scan.next();
				double ouncesOfFood = scan.nextDouble();

				for (int k = 0; k < numOfIngredients; k++) {
					if (ingredient[k].getName().equals(foodName)) {
						Ingredient ing = ingredient[k];
						ingredientsWithin[j] = new IngredientPortionImpl(ing, ouncesOfFood);
					}
				}
			}
			
			MenuItem menuItem = new MenuItemImpl(nameOfRecipe, ingredientsWithin);
			recipe[i] = menuItem;
		}
		
		String rollName = scan.next();
		double[] finalAmounts = new double[numOfIngredients];
		
		while(!rollName.equals("EndOrder")) {
			for(int i = 0; i < numOfRecipes; i++) {
				if(recipe[i].getName().equals(rollName)) {
					
					for(int j = 0; j < numOfIngredients; j++) {
						for(int k = 0; k < recipe[i].getIngredients().length; k++) {
							if(ingredient[j].getName().equals(recipe[i].getIngredients()[k].getName())){
								finalAmounts[j] += recipe[i].getIngredients()[k].getAmount();
							}
							
						}
						
					}
				}
			}
			rollName = scan.next();
	
		}
		System.out.println("The order will require: ");
		for (int i = 0; i < numOfIngredients; i++) {
			System.out.println(String.format("%.2f", finalAmounts[i]) + " ounces of " + ingredient[i].getName());
		}
	}
}
