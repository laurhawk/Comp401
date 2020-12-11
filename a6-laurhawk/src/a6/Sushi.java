package a6;

public interface Sushi {
	
	//methods implemented by the Sashimi, Nigiri, and Roll classes
	String getName();
	IngredientPortion[] getIngredients();
	int getCalories();
	double getCost();
	boolean getHasRice();
	boolean getHasShellfish();
	boolean getIsVegetarian();
}
