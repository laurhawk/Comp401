package a6;

public class ShrimpPortion extends IngredientPortionImpl {
	
	//creates a shrimp portion
	public ShrimpPortion(double amount) {
		super(new Shrimp(), amount);
		if (amount < 0) {
			throw new RuntimeException("Shrimp cannot be null");
		}
	}

	/*implements the abstract combine method within the ShrimpPortion class,
	 throws a RuntimeException if the ingredients do not match */
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new ShrimpPortion(this.getAmount() + other.getAmount());

		} else {
			throw new RuntimeException("Different ingredient");
		}
	}
}
