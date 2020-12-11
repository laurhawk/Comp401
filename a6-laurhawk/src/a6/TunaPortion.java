package a6;

public class TunaPortion extends IngredientPortionImpl {
	
	//creates a TunaPortion
	public TunaPortion(double amount) {
		super(new Tuna(), amount);
		if (amount < 0) {
			throw new RuntimeException("Tuna cannot be null");
		}
	}

	/*implements the abstract combine method within the TunaPortion class,
	 throws a RuntimeException if the ingredients do not match */
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new TunaPortion(this.getAmount() + other.getAmount());

		} else {
			throw new RuntimeException("Different ingredient");
		}

	}
}
