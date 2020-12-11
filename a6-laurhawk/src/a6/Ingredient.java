package a6;

public interface Ingredient {

	//the methods of the class IngredientImpl
	String getName();
	double getCaloriesPerDollar();
	int getCaloriesPerOunce();
	double getPricePerOunce();
	boolean equals(Ingredient other);
	boolean getIsVegetarian();
	boolean getIsRice();
	boolean getIsShellfish();
}
