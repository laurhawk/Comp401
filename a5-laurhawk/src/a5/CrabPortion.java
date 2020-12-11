package a5;

public class CrabPortion extends IngredientPortionImpl {

	//creates a CrabPortion
	public CrabPortion(double amount) {
		super(new Crab(), amount);
		if (amount < 0) {
			throw new RuntimeException("Crab cannot be null");
		}
	}

	/*implements the abstract combine method within the CrabPortion class,
	 throws a RuntimeException if the ingredients do not match */
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new CrabPortion(this.getAmount() + other.getAmount());

		} else {
			throw new RuntimeException("Different ingredient");

		}
	}
}
