package a6;

public class AvocadoPortion extends IngredientPortionImpl {
	//creates an AvocadoPortion
	public AvocadoPortion(double amount) {
		super(new Avocado(), amount);
	}

	/*implements the abstract combine method within the AvocadoPortion class,
	 throws a RuntimeException if the ingredients do not match */
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new AvocadoPortion(this.getAmount() + other.getAmount());

		} else {
			throw new RuntimeException("Different ingredient");
		}

	}
}
