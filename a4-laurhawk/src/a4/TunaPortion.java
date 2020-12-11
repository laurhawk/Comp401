package a4;

public class TunaPortion extends IngredientPortionImpl {
	public TunaPortion(double amount) {
		super(new Tuna(), amount);
		if (amount < 0) {
			throw new RuntimeException("Tuna cannot be null");
		}
	}

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
