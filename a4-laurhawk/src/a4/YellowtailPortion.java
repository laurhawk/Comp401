package a4;

public class YellowtailPortion extends IngredientPortionImpl {
	public YellowtailPortion(double amount) {
		super(new Yellowtail(), amount);
		if (amount < 0) {
			throw new RuntimeException("Yellowtail cannot be null");
		}
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new YellowtailPortion(this.getAmount() + other.getAmount());

		} else {

			throw new RuntimeException("Different ingredient");
		}
	}
}
