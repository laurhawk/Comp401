package a7;

//creates an observer for the belt object which handles
//when plates are removed or added
public interface BeltObserver {
	void handlePlateEvent(PlateEvent e);
}
