package a7;

//creates an exception if the belt is full
public class BeltFullException extends Exception {
	private Belt _belt;
	
	public BeltFullException(Belt belt) {
		super("Belt full");
		_belt = belt;
	}
	
	public Belt getBelt() {
		return _belt;
	}
}
