package a6;

public class GoldPlate extends PlateImpl{
	
	//creates a GoldPlate object set to plate color, contents, and price
	public GoldPlate(Sushi contents, double price) throws PlatePriceException{
		super(Plate.Color.GOLD, contents, price);

		//throws IllegalArgumentException if plate price is less than 5 dollars
		if(price <= 5.0) {
			throw new IllegalArgumentException();
		}
	}
	
}
