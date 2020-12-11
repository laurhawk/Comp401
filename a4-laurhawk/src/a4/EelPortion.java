package a4;

public class EelPortion extends IngredientPortionImpl {

	public EelPortion(double amount) {
		super(new Eel(), amount);
		if (amount < 0) {
			throw new RuntimeException("Eel cannot be null");
		}

	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}

		else if (this.getIngredient().equals(other.getIngredient())) {
			return new EelPortion(this.getAmount() + other.getAmount());

		} else {

			throw new RuntimeException("Different ingredient");
		}
	}

}
