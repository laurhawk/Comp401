package a4;

public class AvocadoPortion extends IngredientPortionImpl {

	public AvocadoPortion(double amount) {
		super(new Avocado(), amount);
	}

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
