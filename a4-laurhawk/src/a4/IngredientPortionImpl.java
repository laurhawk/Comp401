package a4;

abstract public class IngredientPortionImpl implements IngredientPortion {

	private Ingredient _ingredient;
	private double _amount;
	
	public IngredientPortionImpl(Ingredient ingredient, double amount) {
		if(amount < 0) {
			throw new RuntimeException("Amount cannot be negative");
		}
		
		this._ingredient = ingredient;
		this._amount = amount;
	}
	
	@Override
	public Ingredient getIngredient() {
		// TODO Auto-generated method stub
		return _ingredient;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _ingredient.getName();
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return _amount;
		
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
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return _ingredient.getIsVegetarian();
	}

	@Override
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return _ingredient.getIsRice();
	}

	@Override
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return _ingredient.getIsShellfish();
	}
	
	@Override
	public abstract IngredientPortion combine(IngredientPortion other);
			
	
	/*public IngredientPortion combine(IngredientPortion other) {
		// TODO Auto-generated method stub
		if(other == null) {
			return this;
		}
		
		if (!this.getName().equals(other.getName())) {
			throw new RuntimeException("Different ingredient");
		}
		return new IngredientPortionImpl(this.getIngredient(), this.getAmount() + other.getAmount());
	}*/

}
