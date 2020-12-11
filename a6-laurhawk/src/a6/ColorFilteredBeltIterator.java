package a6;

import java.util.Iterator;

public class ColorFilteredBeltIterator implements Iterator {

	private Belt _belt;
	private int _startPosition;
	Plate.Color _colorFilter;

	//creates a belt iterator that iterates over plate matching
	//the specified position color filter value starting at start position
	public ColorFilteredBeltIterator(Belt belt, int startPosition, Plate.Color colorFilter) {
		this._belt = belt;
		this._startPosition = startPosition;
		this._colorFilter = colorFilter;
	}

	@Override
	//checks if there is a next plate, returns true if yes, false if no
	public boolean hasNext() {
		for (int i = 0; i < _belt.getSize(); i++) {
			if (!(_belt.getPlateAtPosition(i) == null)) {
				if (_belt.getPlateAtPosition(i).getColor() == (_colorFilter)) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	//retrieves the next plate from belt
	public Plate next() {
		if (hasNext()) {
			for (int i = _startPosition + 1; i < _belt.getSize(); i++) {
				if (!(_belt.getPlateAtPosition(i) == null)) {
					if (_belt.getPlateAtPosition(i).getColor() == (_colorFilter)) {
						_startPosition = i;
						return _belt.getPlateAtPosition(i);
					}
				}
				for (int j = 0; j <= _startPosition; j++) {
					if (!(_belt.getPlateAtPosition(j) == null)) {
						if (_belt.getPlateAtPosition(j).getColor() == (_colorFilter)) {
							_startPosition = j;
							return _belt.getPlateAtPosition(j);
						}
					}

				}
			}
		} else {
			throw new java.util.NoSuchElementException();
		}
		return null;
	}
}
