package a6;

public class Nigiri implements Sushi {
	//private variables of the class
	private IngredientPortion _seafood;
	private IngredientPortion _rice;
	private static double NIGIRI_MEAT_AMOUNT = 0.75;
	
	/*creates an enumeration of type Nigiri and returns a different
	type of Nigiri based on which type of meat, also incorporates
	a rice portion to account for rice in sushi*/
	public enum NigiriType{TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP}; 
	
	public Nigiri(NigiriType type) {
		switch (type) {
		case TUNA:
			_seafood = new TunaPortion(NIGIRI_MEAT_AMOUNT);
			break;
			
		case YELLOWTAIL:
			_seafood = new YellowtailPortion(NIGIRI_MEAT_AMOUNT);
			break;
		
		case EEL:
			_seafood = new EelPortion(NIGIRI_MEAT_AMOUNT);
			break;
			
		case CRAB:
			_seafood = new CrabPortion(NIGIRI_MEAT_AMOUNT);
			break;
			
		case SHRIMP:
			_seafood = new ShrimpPortion(NIGIRI_MEAT_AMOUNT);
			break;
		}
		
		_rice = new RicePortion(0.5);
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _seafood.getName() + " nigiri";
	}

	@Override
	//returns an array of the ingredients within nigiri
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return new IngredientPortion[] {_seafood, _rice};
	}

	@Override
	//returns the total amount of calories and rounds up
	public int getCalories() {
		// TODO Auto-generated method stub
		return (int)(_seafood.getCalories() + _rice.getCalories() + 0.5);
	}

	@Override
	//returns the total cost of sushi
	public double getCost() {
		// TODO Auto-generated method stub
		return _seafood.getCost() + _rice.getCost();
		
	}

	@Override
	public boolean getHasRice() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean getHasShellfish() {
		// TODO Auto-generated method stub
		return _seafood.getIsShellfish();
	}

	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return _seafood.getIsVegetarian();
	}
}
