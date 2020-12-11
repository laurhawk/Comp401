package a4;

public class CrabPortion extends IngredientPortionImpl {

	public CrabPortion(double amount) {
		super(new Crab(), amount);
		if (amount < 0) {
			throw new RuntimeException("Crab cannot be null");
		}
	}

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
