package a4;

public class IngredientImpl implements Ingredient {

	private String _name;
	private double _pricePerOunce;
	private int _caloriePerOunce;
	private boolean _isVeg;
	private boolean _hasRice;
	private boolean _isShellfish;

	public IngredientImpl(String name, double pricePerOunce, int caloriePerOunce, boolean isVeg, boolean hasRice,
			boolean isShellfish) {
		this._name = name;
		this._pricePerOunce = pricePerOunce;
		this._caloriePerOunce = caloriePerOunce;
		this._isVeg = isVeg;
		this._hasRice = hasRice;
		this._isShellfish = isShellfish;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _name;
	}

	@Override
	public double getCaloriesPerDollar() {
		// TODO Auto-generated method stub
		return (double) _caloriePerOunce / _pricePerOunce;
	}

	@Override
	public int getCaloriesPerOunce() {
		// TODO Auto-generated method stub
		return _caloriePerOunce;
	}

	@Override
	public double getPricePerOunce() {
		// TODO Auto-generated method stub
		return _pricePerOunce;
	}

	@Override
	public boolean equals(Ingredient other) {
		// TODO Auto-generated method stub
		if (this.getName().equals(other.getName())) {
			if (this.getCaloriesPerOunce() == other.getCaloriesPerOunce()) {
				if (Math.abs(this.getPricePerOunce() - other.getPricePerOunce()) <= 0.01) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return _isVeg;
	}

	@Override
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return _hasRice;
	}

	@Override
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return _isShellfish;
	}

}
