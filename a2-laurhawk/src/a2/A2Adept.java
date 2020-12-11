package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numOfItems = scan.nextInt();

		String[] ingredientName = new String[numOfItems];
		double[] pricePerOunce = new double[numOfItems];
		boolean[] isVegetarian = new boolean[numOfItems];
		int[] caloriesPerOunce = new int[numOfItems];

		for (int i = 0; i < numOfItems; i++) {
			ingredientName[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = scan.nextInt();
		}

		int numOfMenuItems = scan.nextInt();
		
		String[] recipeName = new String[numOfMenuItems];
		double[] numOfCal = new double[numOfMenuItems];
		int index = 0;
		double[] totalCost = new double[numOfMenuItems];

		for (int j = 0; j < numOfMenuItems; j++) {
			recipeName[j] = scan.next();
			int numberOfIngredients = scan.nextInt();
			boolean vegetarian = true;

			for (int h = 0; h < numberOfIngredients; h++) {
				String ingredientInRecipe = scan.next();
				double ouncesOfIngredient = scan.nextDouble();

				for (int g = 0; g < numOfItems; g++) {
					if (ingredientInRecipe.equals(ingredientName[g])) {
						index = g;
					}

				}
				// numOfCal
				int calorieOfIngredient = caloriesPerOunce[index];
				numOfCal[j] += (calorieOfIngredient * ouncesOfIngredient);

				// totalCost
				double priceOfIngredient = pricePerOunce[index];
				totalCost[j] += (priceOfIngredient * ouncesOfIngredient);

				// isVegetarian
				if (!isVegetarian[index] == true) {
					vegetarian = false;
				}

			}
			// print statement
			System.out.println(recipeName[j] + ":");
			System.out.println(((int) (Math.round(numOfCal[j]))) + " calories");
			System.out.println("$" + String.format("%.2f", totalCost[j]));
			if (vegetarian == true) {
				System.out.println("Vegetarian");
			} else {
				System.out.println("Non-Vegetarian");

			}

		}
		scan.close();
	}
}
