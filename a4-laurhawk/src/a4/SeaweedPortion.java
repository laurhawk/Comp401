package a4;

public class SeaweedPortion extends IngredientPortionImpl {
	public SeaweedPortion(double amount) {
		super(new Seaweed(), amount);
		if (amount < 0) {
			throw new RuntimeException("Seaweed cannot be null");
		}
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new SeaweedPortion(this.getAmount() + other.getAmount());

		} else {
			throw new RuntimeException("Different ingredient");
		}
	}
}
