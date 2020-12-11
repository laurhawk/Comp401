package a7;

import comp401sushi.Plate;

public class ProfitCounter implements BeltObserver {

	private Belt _b;
	private double totalProfit;
	private int plateCount;

	public ProfitCounter(Belt b) {
		totalProfit = 0.0;
		plateCount = 0;

		if (b == null) {
			throw new IllegalArgumentException();
		}

		this._b = b;
		b.addBeltObserver(this);

		// if plate is not null, add to plate count and total profit
		for (int i = 0; i < _b.getSize(); i++) {
			Plate p = _b.getPlateAtPosition(i);
			if (p != null) {
				plateCount++;
				totalProfit += p.getProfit();
			}
		}

	}

	// switch case which adds to the plate count and total
	// profit if a plate is placed on belt and takes away
	// from plate count and total profit if a plate is
	// removed from the belt
	public void handlePlateEvent(PlateEvent e) {
		switch (e.getType()) {
		case PLATE_PLACED:
			plateCount++;
			totalProfit += e.getPlate().getProfit();
			break;
		case PLATE_REMOVED:
			plateCount--;
			totalProfit -= e.getPlate().getProfit();
			break;
		}
	}

	public double getTotalBeltProfit() {
		return totalProfit;

	}

	// divides total profit by amount of plates to return
	// an average profit
	public double getAverageBeltProfit() {
		if (plateCount == 0) {
			return 0.0;
		} else {
			return totalProfit / plateCount;
		}

	}
}
