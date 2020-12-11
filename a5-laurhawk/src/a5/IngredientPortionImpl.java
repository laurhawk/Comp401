package a5;

abstract public class IngredientPortionImpl implements IngredientPortion {

	//private variables of the class
	private Ingredient _ingredient;
	private double _amount;
	
	/*main constructor of the class, passes variables through and throws
	RuntimeException if the amount passed through is negative*/
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
	//multiplies the amount of calories within an object by the amount of that object
	public double getCalories() {
		// TODO Auto-generated method stub
		return _ingredient.getCaloriesPerOunce() * _amount;
	}

	@Override
	//multiplies the cost of an object by the amount of that object
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
	//creates abstract IngredientPortion combine method
	public abstract IngredientPortion combine(IngredientPortion other);
			
	

}
