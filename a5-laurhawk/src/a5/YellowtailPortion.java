package a5;

public class YellowtailPortion extends IngredientPortionImpl {
	
	//creates a YellowtailPortion
	public YellowtailPortion(double amount) {
		super(new Yellowtail(), amount);
		if (amount < 0) {
			throw new RuntimeException("Yellowtail cannot be null");
		}
	}

	/*implements the abstract combine method within the YellowtailPortion 
	 class, throws a RuntimeException if the ingredients do not match */
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new YellowtailPortion(this.getAmount() + other.getAmount());

		} else {

			throw new RuntimeException("Different ingredient");
		}
	}
}
