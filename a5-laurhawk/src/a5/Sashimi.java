package a5;

public class Sashimi implements Sushi{
	
	//private variables of the class
	private IngredientPortion _seafood;
	private static double sashimiAmount = 0.75;
	
	/*creates an enumeration of type Sashimi and returns a different
	type of Sashimi based on which type of meat*/
	public enum SashimiType{TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	
	public Sashimi(SashimiType type) {
		switch(type) {
		case TUNA:
			_seafood = new TunaPortion(sashimiAmount);
			break;
			
		case YELLOWTAIL:
			_seafood = new YellowtailPortion(sashimiAmount);
			break;
			
		case EEL:
			_seafood = new EelPortion(sashimiAmount);
			break;
			
		case CRAB:
			_seafood = new CrabPortion(sashimiAmount);
			break;
			
		case SHRIMP:
			_seafood = new ShrimpPortion(sashimiAmount);
			break;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _seafood.getName() + " sashimi";
	}

	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return new IngredientPortion[] {_seafood};
	}

	@Override
	//returns the total amount of calories and rounds up
	public int getCalories() {
		// TODO Auto-generated method stub
		return (int)(_seafood.getCalories() + 0.5);
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return _seafood.getCost();
	}

	@Override
	public boolean getHasRice() {
		// TODO Auto-generated method stub
		return _seafood.getIsRice();
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
