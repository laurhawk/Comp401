package a3;

public class IngredientPortionImpl implements IngredientPortion{

	private Ingredient _ingredient;
	private double _amount;


	public IngredientPortionImpl(Ingredient ing, double amount) {
		if(ing == null) {
			throw new RuntimeException("Ingredient cannot be null");
		}
		if(amount < 0) {
			throw new RuntimeException("Amount cannot be negative");
		}
		
		_ingredient = ing;
		_amount = amount;
	}
	
	@Override
	public Ingredient getIngredient() {
		// TODO Auto-generated method stub
		return _ingredient;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return _amount;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _ingredient.getName();
		
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return _ingredient.getIsVegetarian();
	}

	@Override
	public double getCalories() {
		// TODO Auto-generated method stub
		return _ingredient.getCaloriesPerOunce() * _amount;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return _ingredient.getPricePerOunce() * _amount;
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		if(!this.getName().equals(other.getName())) {
			throw new RuntimeException("Different ingredient");
		}
		return new IngredientPortionImpl(this.getIngredient(), this.getAmount() + other.getAmount());
	}

}
