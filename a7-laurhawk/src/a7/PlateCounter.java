package a7;

import comp401sushi.Plate;;

public class PlateCounter implements BeltObserver {

	// variables for the amounts of plates
	private int redCount = 0;
	private int greenCount = 0;
	private int blueCount = 0;
	private int goldCount = 0;

	public PlateCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}

		b.addBeltObserver(this);

		// switch statements for the different colors of plate
		for (int i = 0; i < b.getSize(); i++) {
			Plate plate = b.getPlateAtPosition(i);
			if (plate != null) {
				switch (plate.getColor()) {
				case RED:
					redCount += 1;
					break;
				case GREEN:
					greenCount += 1;
					break;
				case BLUE:
					blueCount += 1;
					break;
				case GOLD:
					goldCount += 1;
					break;

				}
			}
		}
	}

	@Override
	// handle plate event implementation for plate counter; if
	// a plate is placed, it adds one to plate count, and if a
	// plate is removed, it takes a plate away from the plate count
	public void handlePlateEvent(PlateEvent e) {
		switch (e.getType()) {
		case PLATE_PLACED:
			if (e.getPlate() != null) {
				switch (e.getPlate().getColor()) {
				case RED:
					redCount += 1;
					break;
				case GREEN:
					greenCount += 1;
					break;
				case BLUE:
					blueCount += 1;
					break;
				case GOLD:
					goldCount += 1;
					break;

				}
			}
			break;
		case PLATE_REMOVED:
			if (e.getPlate() != null) {
				switch (e.getPlate().getColor()) {
				case RED:
					redCount -= 1;
					break;
				case GREEN:
					greenCount -= 1;
					break;
				case BLUE:
					blueCount -= 1;
					break;
				case GOLD:
					goldCount -= 1;
					break;
				}
			}
			break;
		}

	}

	// methods which return the count of each type of plate
	public int getRedPlateCount() {
		return redCount;
	}

	public int getGreenPlateCount() {
		return greenCount;
	}

	public int getBluePlateCount() {
		return blueCount;
	}

	public int getGoldPlateCount() {
		return goldCount;
	}

}
