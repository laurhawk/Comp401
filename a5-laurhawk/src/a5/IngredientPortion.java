package a5;

//methods of the class IngredientPortionImpl
public interface IngredientPortion {
	Ingredient getIngredient();
	String getName();
	double getAmount();
	double getCalories();
	double getCost();
	boolean getIsVegetarian();
	boolean getIsRice();
	boolean getIsShellfish();
	IngredientPortion combine(IngredientPortion other);
}
