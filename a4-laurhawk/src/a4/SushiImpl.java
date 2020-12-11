package a4;

public class SushiImpl implements Sushi {

	private String _name;
	private IngredientPortion[] _ingredients;

	public SushiImpl(String name, IngredientPortion[] ingredients) {
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		if (ingredients == null) {
			throw new RuntimeException("Ingredients cannot be null");
		}
		if (ingredients.length < 1) {
			throw new RuntimeException("Ingredients cannot be null");
		}
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				throw new RuntimeException("Ingredients cannot be null");
			}
		}
		_name = name;
		_ingredients = ingredients;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		IngredientPortion[] ingredientPortionCopy = new IngredientPortion[_ingredients.length];
		ingredientPortionCopy = _ingredients.clone();
		return ingredientPortionCopy;
	}

	@Override
	public int getCalories() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < _ingredients.length; i++) {
			sum += _ingredients[i].getCalories();
		}
		return Math.round(sum);
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < _ingredients.length; i++) {
			sum += _ingredients[i].getCost();
		}
		return sum;
	}

	@Override
	public boolean getHasRice() {
		// TODO Auto-generated method stub
		for (int i = 0; i < _ingredients.length; i++) {
			if (!_ingredients[i].getIsRice()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean getHasShellfish() {
		// TODO Auto-generated method stub
		for (int i = 0; i < _ingredients.length; i++) {
			if (!_ingredients[i].getIsShellfish()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		for (int i = 0; i < _ingredients.length; i++) {
			if (!_ingredients[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}

}
