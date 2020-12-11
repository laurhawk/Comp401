package a4;

public class RicePortion extends IngredientPortionImpl {
	public RicePortion(double amount) {
		super(new Rice(), amount);
		if (amount < 0) {
			throw new RuntimeException("Rice cannot be null");
		}
	}

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
