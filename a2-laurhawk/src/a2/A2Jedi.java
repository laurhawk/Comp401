package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numOfItems = scan.nextInt();
		String[] ingredientName = new String[numOfItems];

		for (int i = 0; i < numOfItems; i++) {
			ingredientName[i] = scan.next();
			double pricePerOunce = scan.nextDouble();
			boolean isVegetarian = scan.nextBoolean();
			int caloriesPerOunce = scan.nextInt();

		}

		int numOfMenuItems = scan.nextInt();
		String[] recipeName = new String[numOfItems];
		double[] finalAmounts = new double[numOfItems];
		//String[][] ingredientNameArray = new String[numOfItems][];
		double[][] ingredientAmountArray = new double[numOfMenuItems][numOfItems];
		int ingredients = 0;

		for (int i = 0; i < numOfMenuItems; i++) {
			recipeName[i] = scan.next();
			ingredients = scan.nextInt();
			 //ingredientNameArray[i] = new String[numberOfIngredients];
			 //ingredientAmountArray[i] = new double[numOfItems];

			for (int j = 0; j < ingredients; j++) {
				String foodName = scan.next();

				for (int k = 0; k < numOfItems; k++) {
					if (ingredientName[k].equals(foodName)) {
						//ingredientNameArray[i][j] = scan.next();
						ingredientAmountArray[i][k] = scan.nextDouble();
					}
				}

			}
		}

		
		/*for (int i = 0; i < numOfItems; i++) {
			finalAmounts[i] = 0.00;
			System.out.println(finalAmounts[i]);
		}*/

		String rollName = scan.next();

		while (!rollName.equals("EndOrder")) {
			for (int i = 0; i < numOfMenuItems; i++) {
				if (recipeName[i].equals(rollName)) {
					for (int j = 0; j < numOfItems; j++) {
						finalAmounts[j] += ingredientAmountArray[i][j];
					}
					
				}
			}
				rollName = scan.next();
				
			}

			

			System.out.println("The order will require:");
			for (int h = 0; h < numOfItems; h++) {
				System.out.println(String.format("%.2f", finalAmounts[h]) + " ounces of " + ingredientName[h]);
			}
		}
		
	}

