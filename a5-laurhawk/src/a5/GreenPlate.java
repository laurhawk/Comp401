package a5;

public class GreenPlate extends PlateImpl{
	
	//creates a GreenPlate object set to plate color, contents, and price
	public GreenPlate(Sushi contents) throws PlatePriceException{
		super(Plate.Color.GREEN, contents, 2.0);
	}
}
