package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numOfGroceryItems = scan.nextInt();

		String items[] = new String[numOfGroceryItems];
		double prices[] = new double[numOfGroceryItems];
		int quantityOfItems[] = new int[numOfGroceryItems];
		int numOfCustWhoBought[] = new int[numOfGroceryItems];
		
		//names and price of grocery 
		for(int i = 0; i < numOfGroceryItems; i++) {
			items[i] = scan.next();
			prices[i] = scan.nextDouble();
		}

		int numOfCustomers = scan.nextInt();

		for(int i=0; i < numOfCustomers; i++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numOfItems = scan.nextInt();
			boolean[] didTheyBuy = new boolean[numOfGroceryItems];


			for(int j = 0; j < numOfItems; j++) {

				int quantity = scan.nextInt();
				String groceryName = scan.next();

				for(int index = 0; index < numOfGroceryItems; index++) {
					if(items[index].equals(groceryName)){
						didTheyBuy[index] = true;
						quantityOfItems[index] += quantity;
			
					}
				}
			}
			
			for(int j = 0; j < numOfGroceryItems; j++) {
				if(didTheyBuy[j] == true) {
					numOfCustWhoBought[j] += 1;
					
				}
			}
		}

			for(int k = 0; k < numOfGroceryItems; k++) {
				if(numOfCustWhoBought[k] >= 1) {
					System.out.println(numOfCustWhoBought[k] + " customers bought " + quantityOfItems[k] + " " + items[k]);
			} else {
				System.out.println("No customers bought " + items[k]);
			}

		}
	}
}
