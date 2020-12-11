package a3;

public class IngredientImpl implements Ingredient{

	private String _name;
	private double _price;
	private int _calories;
	private boolean _is_vegetarian;
	
	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		if(name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		if(price < 0) {
			throw new RuntimeException("Price cannot be negative");
		}
		if(calories < 0) {
			throw new RuntimeException("Calories cannot be negative");
		}
		
		_name = name;
		_price = price;
		_calories = calories;
		_is_vegetarian = is_vegetarian;
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _name;
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return _is_vegetarian;
	}

	@Override
	public double getPricePerOunce() {
		// TODO Auto-generated method stub
		return _price;
	}

	@Override
	public int getCaloriesPerOunce() {
		// TODO Auto-generated method stub
		return _calories;
	}

	@Override
	public double getCaloriesPerDollar() {
		// TODO Auto-generated method stub
		return _calories/_price;
	}

}
