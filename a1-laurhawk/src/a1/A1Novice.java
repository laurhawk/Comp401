package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numOfCustomers = scan.nextInt();
		
		for(int i = 0; i <= numOfCustomers; i++) {
		
		//names of people
		String name = scan.next();
		char firstName = name.charAt(0);
		String lastName = scan.next();
		int numOfItems = scan.nextInt();
		double sumOfGroceries = 0;
		
			for(int j = 0; j < numOfItems; j++) {
			//price of groceries
				
				int numOfGrocery = scan.nextInt();
				String groceryName = scan.next();
				double price = scan.nextDouble();
				double finalPrice = numOfGrocery * price;
				sumOfGroceries = finalPrice + sumOfGroceries;
					
			
			}
				
			System.out.println("\n" + firstName+ ". " + lastName + ": " + String.format("%.2f", sumOfGroceries));
			
			}
			scan.close();
		
		}
		
	}
	

	
	// You can define / use static helper methods here.

