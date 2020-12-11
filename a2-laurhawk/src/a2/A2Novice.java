package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numOfItems = scan.nextInt();
		
		String[] ingredientName = new String[numOfItems];
		double[] pricePerOunce = new double[numOfItems];
		boolean[] isVegetarian = new boolean[numOfItems];
		double[] caloriesPerOunce = new double[numOfItems];

		int numberOfVeg = 0;
		
		for(int i = 0; i < numOfItems; i++) {
			ingredientName[i] = scan.next();
			pricePerOunce[i] = scan.nextDouble();
			isVegetarian[i] = scan.nextBoolean();
			caloriesPerOunce[i] = (scan.nextDouble()/pricePerOunce[i]);
			}
		
		for(int j = 0; j < numOfItems; j++) {
			if(isVegetarian[j] == true) {
				numberOfVeg += 1;
			}
		}
			

		double highestCals = caloriesPerOunce[0];
		double lowestCals = caloriesPerOunce[0];
		int indexHighest = 0;
		int indexLowest = 0;
		
		for(int h = 0; h < numOfItems; h++) {
			if(caloriesPerOunce[h] >= highestCals) {
				highestCals = caloriesPerOunce[h];
				indexHighest = h;
				//System.out.println(indexHighest);
				}
			}
				
		for(int l = 0; l < numOfItems; l++) {
			if(caloriesPerOunce[l] <= lowestCals) {
				lowestCals = caloriesPerOunce[l];
				indexLowest = l;
				//System.out.println(indexLowest);
							
				}
			}
				
			System.out.println("Number of vegetarian ingredients: " + numberOfVeg);
			System.out.println("Highest cals/$: " + ingredientName[indexHighest]);
			System.out.println("Lowest cals/$: " + ingredientName[indexLowest]);
				
			scan.close();
				
			}
		
	
	}
	
	// You can define helper methods here if needed.
	


