package a6;

public class SeaweedPortion extends IngredientPortionImpl {
	
	//creates a SeaweedPortion
	public SeaweedPortion(double amount) {
		super(new Seaweed(), amount);
		if (amount < 0) {
			throw new RuntimeException("Seaweed cannot be null");
		}
	}

	/*implements the abstract combine method within the SeaweedPortion class,
	 throws a RuntimeException if the ingredients do not match */
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
