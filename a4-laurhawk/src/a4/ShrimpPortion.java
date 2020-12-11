package a4;

public class ShrimpPortion extends IngredientPortionImpl {
	public ShrimpPortion(double amount) {
		super(new Shrimp(), amount);
		if (amount < 0) {
			throw new RuntimeException("Shrimp cannot be null");
		}
	}

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
