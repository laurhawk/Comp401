package a6;

public class BluePlate extends PlateImpl{
	
	//creates BluePlate object set to plate color, contents, and price
	public BluePlate(Sushi contents) throws PlatePriceException{
		super(Plate.Color.BLUE, contents, 4.0);
	}
}
