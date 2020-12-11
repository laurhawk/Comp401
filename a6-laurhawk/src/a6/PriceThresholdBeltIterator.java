package a6;

import java.util.Iterator;

//creates a belt iterator that iteratoes over plates with a price
//less than or equal to the specified max price starting at
//position specified as start position
public class PriceThresholdBeltIterator implements Iterator {

	private Belt _belt;
	private int _startPosition;
	private double _maxPrice;

	public PriceThresholdBeltIterator(Belt belt, int startPosition, double maxPrice) {
		this._belt = belt;
		this._startPosition = startPosition;
		this._maxPrice = maxPrice;
	}

//checks is there is a next plate object to be iterated
	@Override
	public boolean hasNext() {
		for (int i = 0; i < _belt.getSize(); i++) {
			if (!(_belt.getPlateAtPosition(i) == null)) {
				if (_belt.getPlateAtPosition(i).getPrice() <= (_maxPrice)) {
					return true;
				}
			}
		}
		return false;

	}

	
	//retrieves next applicable plate from belt
	@Override
	public Object next() {
		if (hasNext()) {
			for (int i = _startPosition + 1; i < _belt.getSize(); i++) {
				if (!(_belt.getPlateAtPosition(i) == null)) {
					if (_belt.getPlateAtPosition(i).getPrice() <= (_maxPrice)) {
						_startPosition = i;
						return _belt.getPlateAtPosition(i);
					}
				}
				for (int j = 0; j <= _startPosition; j++) {
					if (!(_belt.getPlateAtPosition(j) == null)) {
						if (_belt.getPlateAtPosition(j).getPrice() <= (_maxPrice)) {
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
