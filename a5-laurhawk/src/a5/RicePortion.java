package a5;

public class RicePortion extends IngredientPortionImpl {
	
	//creates a RicePortion
	public RicePortion(double amount) {
		super(new Rice(), amount);
		if (amount < 0) {
			throw new RuntimeException("Rice cannot be null");
		}
	}

	/*implements the abstract combine method within the RicePortion class,
	 throws a RuntimeException if the ingredients do not match */
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new RicePortion(this.getAmount() + other.getAmount());

		} else {
			throw new RuntimeException("Different ingredient");
		}
	}

}
