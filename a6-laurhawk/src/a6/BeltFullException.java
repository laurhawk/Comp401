package a6;

public class BeltFullException extends Exception {
	
	//creates a new type of exception if there is no space left on the belt
	private Belt _belt;
	public BeltFullException(Belt belt) {
		super("Belt full exception caused by belt being full");
		
		if (belt == null) {
			throw new IllegalArgumentException("belt is null");			
		}
		
		_belt = belt;
	}
	//returns a type of belt
	public Belt getBelt() {
		return _belt;
	}
}
