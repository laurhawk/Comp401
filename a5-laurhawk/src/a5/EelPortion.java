package a5;

public class EelPortion extends IngredientPortionImpl {

	//creates an EelPortion
	public EelPortion(double amount) {
		super(new Eel(), amount);
		if (amount < 0) {
			throw new RuntimeException("Eel cannot be null");
		}

	}

	/*implements the abstract combine method within the EelPortion class,
	 throws a RuntimeException if the ingredients do not match */
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
