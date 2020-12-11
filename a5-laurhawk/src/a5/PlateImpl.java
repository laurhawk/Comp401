package a5;

public class PlateImpl implements Plate {

	private Plate.Color color;
	private Sushi sushi;
	private double price;
	
	/* Main constructor of the class, sets the variables
	 * to what is being passed through the constructor and
	 throws PlatePriceException if price is wrong*/
	public PlateImpl(Plate.Color color, Sushi sushi, double price) throws PlatePriceException {
		this.color = color;
		this.sushi = sushi;
		this.price = price;
		
		if (sushi != null && price < sushi.getCost()) {
			throw new PlatePriceException();
		}
	}
	
	
	@Override
	public Sushi getContents() {
		// TODO Auto-generated method stub
		return sushi;
	}

	@Override
	/*Returns null if plate is already empty and if not 
	 makes plate empty and returns previous contents*/
	public Sushi removeContents() {
		// TODO Auto-generated method stub
		if(sushi == null) {
			return null;
		}
		else {
			Sushi priorContents = sushi;
			sushi = null;
			return priorContents;
		}
		
	}

	@Override
	/*sets the contents of the plate to be the Sushi object
	 * passed in as parameter s, and replaces any prior contents
	 that the plate may have had. If the price of the plate
	 is less than or equal to cost, throws PlatePriceException*/
	public void setContents(Sushi s) throws PlatePriceException{
		if(s == null) {
			throw new IllegalArgumentException();
		}
		if(s != null && price <= s.getCost()) {
			throw new PlatePriceException();
		}
		sushi = s;
		
		
	}

	@Override
	//Returns true if plate has contents and false if not
	public boolean hasContents() {
		// TODO Auto-generated method stub
		if(sushi == null) {
			return false;
		}
		return true;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	/*returns profit made by subtracting cost of sushi from
	price of plate and rounding */
	public double getProfit() {
		// TODO Auto-generated method stub
		if(sushi == null) {
			return 0;
		}
		else {
			double profit = price-sushi.getCost();
			return Math.floor(profit*100) / 100;
			
		}
		
	}

}
