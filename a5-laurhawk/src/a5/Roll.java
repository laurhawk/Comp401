package a5;

import java.util.*;

public class Roll implements Sushi {

	//private variables of the class
	private String _name;
	private IngredientPortion[] _ingredients;

	/*Main constructor of the class, returns runtime exceptions
	 *if null values are passed through, also returns the variables
	 using the combine method and checking for seaweed amount*/
	public Roll(String name, IngredientPortion[] rollIngredients) {
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		if (rollIngredients == null) {
			throw new RuntimeException("Ingredients cannot be null");
		}
		if (rollIngredients.length < 1) {
			throw new RuntimeException("Ingredients cannot be null");
		}
		for (int i = 0; i < rollIngredients.length; i++) {
			if (rollIngredients[i] == null) {
				throw new RuntimeException("Ingredients cannot be null");
			}
		}
		_name = name;
		_ingredients = sw(combine(rollIngredients));
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return _name;
	}

	@Override
	//returns a clone of the ingredient array
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return _ingredients.clone();

	}

	@Override
	/*returns total calories of roll by looping through the items
	within the ingredient array and rounds the value*/
	public int getCalories() {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < _ingredients.length; i++) {
			sum += _ingredients[i].getCalories();
		}
		return (int)(sum + 0.5);
	}

	@Override
	/* returns total cost of roll by looping through the items 
	within the ingredient array and rounds the value*/
	public double getCost() {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < _ingredients.length; i++) {
			sum += _ingredients[i].getCost();
		}

		return Math.round(sum * 100.0) / 100.0;
	}

	@Override
	/*loops through ingredient array and checks if any ingredients
	are rice */
	public boolean getHasRice() {
		// TODO Auto-generated method stub
		for (int i = 0; i < _ingredients.length; i++) {
			if (_ingredients[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	/*loops through ingredient array and checks if any ingredients
	 are shellfish*/
	public boolean getHasShellfish() {
		// TODO Auto-generated method stub
		for (int i = 0; i < _ingredients.length; i++) {
			if (_ingredients[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	/*loops through ingredient array and checks if all items are 
	vegetarian */
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		for (int i = 0; i < _ingredients.length; i++) {
			if (!_ingredients[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;

	}
	/*implementation of the combine method which combines the 
	 * ingredients passed through the constructor if they are 
	 the same ingredient and returns it as just one of that ingredient*/
	private IngredientPortion[] combine(IngredientPortion[] rI) {
		List<IngredientPortion> within = new ArrayList<IngredientPortion>();
		for (int i = 0; i < rI.length; i++) {
			boolean doesItExist = false;
			if (!doesItExist) {
				for (int j = 0; j < within.size(); j++) {
					if (rI[i].getName().equals(within.get(j).getName())) {
						within.set(j, within.get(j).combine(rI[i]));
						j = within.size();
						doesItExist = true;
					}
				}
			}
			if (!doesItExist) {
				within.add(rI[i]);
			}
		}
		return within.toArray(new IngredientPortion[within.size()]);
	}

	/* checks the constructor to make sure that seaweed is an 
	 * ingredient and is greater than or equal to 0.1 oz, and if not, 
	 adds that to the roll or adds up until 0.1 oz*/
	private IngredientPortion[] sw(IngredientPortion[] rI) {
		for (int i = 0; i < rI.length; i++) {
			if (rI[i].getName().equals("seaweed")) {
				if (rI[i].getAmount() >= 0.1) {
					return rI;
				} else {
					rI[i] = new SeaweedPortion(0.1);
					return rI;
				}
			}
		}
		IngredientPortion[] finalSeaweed = new IngredientPortion[rI.length + 1];
		for (int i = 0; i < rI.length; i++) {
			finalSeaweed[i] = rI[i];
		}
		finalSeaweed[rI.length] = new SeaweedPortion(0.1);
		return finalSeaweed;
	}
}
