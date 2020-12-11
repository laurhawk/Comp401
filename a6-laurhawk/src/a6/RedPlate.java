package a6;

public class RedPlate extends PlateImpl {
	
	//creates RedPlate object set to plate color, contents, and price
	public RedPlate(Sushi contents) throws PlatePriceException{
		super(Plate.Color.RED, contents, 1.0);
	}
}
