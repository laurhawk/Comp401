package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//scanner items
		
		int numOfGroceryItems = scan.nextInt();
		
		String items[] = new String[numOfGroceryItems];
		double prices[] = new double[numOfGroceryItems];
		
		//names and price of grocery 
		for(int i = 0; i < numOfGroceryItems; i++) {
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}
		
		int numOfCustomers = scan.nextInt();
		
		String firstName[] = new String[numOfCustomers];
		String lastName[] = new String[numOfCustomers];
		double priceSpent[] = new double[numOfCustomers];
		for(int j=0; j < numOfCustomers; j++) {
			firstName[j] = scan.next();
			lastName[j] = scan.next();
			int numOfItems = scan.nextInt();
			for(int k = 0; k < numOfItems; k++) {
				
				int quantity = scan.nextInt();
				String groceryName = scan.next();
				double groceryPrice = 0;
				
				for(int index = 0; index < numOfGroceryItems; index++) {
					if(items[index].equals(groceryName)){
						groceryPrice = prices[index];
					}
				}
				priceSpent[j] += quantity * groceryPrice;
			}

		}
		
		//biggest spender
		double biggest = priceSpent[0];
		int indexBiggestSpender = 0;
		for(int i = 0; i < numOfCustomers; i++) {
			if(priceSpent[i] > biggest) {
				biggest = priceSpent[i];
				indexBiggestSpender = i;
			}
		}
		
			
		//smallest spender
		double smallest = priceSpent[0];
		int indexSmallestSpender = 0;
		for(int i = 0; i < numOfCustomers; i++) {
			if(priceSpent[i] < smallest) {
				smallest = priceSpent[i];
				indexSmallestSpender = i;
			}
		}
				
			
		//average spender
		double totalPrice = 0.0;
		for(int j = 0; j < numOfCustomers; j++) {
			totalPrice = totalPrice + priceSpent[j];
		}
		
		double average = totalPrice/numOfCustomers;
		
		
		
		//Arrays of length of number of grocery items

		
		System.out.println("Biggest: " + firstName[indexBiggestSpender] + " " + lastName[indexBiggestSpender] + " (" + String.format("%.2f", priceSpent[indexBiggestSpender]) + ")");
		System.out.println("Smallest: " + firstName[indexSmallestSpender] + " " + lastName[indexSmallestSpender] + " (" + String.format("%.2f", priceSpent[indexSmallestSpender]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		
		scan.close();
	}
}
	
	
	// You can define / use static helper methods here.
