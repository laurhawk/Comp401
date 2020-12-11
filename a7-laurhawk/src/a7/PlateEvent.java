package a7;

import comp401sushi.Plate;

//plate event object which creates an enumeration based on
//if the plates are placed on the belt or removed from the belt
public class PlateEvent {
	public enum EventType {
		PLATE_PLACED, PLATE_REMOVED
	};

	private EventType type;
	private Plate plate;
	private int position;

	public PlateEvent(EventType type, Plate plate, int position) {
		this.type = type;
		this.plate = plate;
		this.position = position;
	}

	public EventType getType() {
		return type;
	}

	public Plate getPlate() {
		return plate;
	}

	public int getPosition() {
		return position;
	}
}