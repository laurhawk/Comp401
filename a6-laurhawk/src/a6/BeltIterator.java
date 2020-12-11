package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator implements Iterator {
	
	private Belt _belt;
	private int _startPosition;
	private int lastIndex;
	private boolean canRemove;

	public BeltIterator(Belt belt, int startPosition) {
		_belt = belt;
		_startPosition = startPosition;
		lastIndex = 0;
		canRemove = false;

	}

	@Override
	//If there is a next plate object to be iterated, returns true.
	//If the belt is completely empty, returns false.
	public boolean hasNext() {
		for (int i = 0; i < _belt.getSize(); i++) {
			if (!(_belt.getPlateAtPosition(_startPosition) == null)) {
				return true;
			}
			_startPosition++;
		}
		return false;
	}

	@Override
	//retrieves the next plate from belt 
	public Plate next() {
		if (!hasNext()) {
				throw new NoSuchElementException();
			}
		canRemove = true;
		_startPosition++;
		lastIndex = _startPosition - 1;
		return _belt.getPlateAtPosition(_startPosition - 1);
		
	}

	//removes the next plate from belt
	public void remove() {
		
		if (canRemove == true) {
			// do what we need to do to remove
			_belt.removePlateAtPosition(lastIndex);
			canRemove = false;
		} else {
			throw new IllegalStateException();
		}
	}

	
}
