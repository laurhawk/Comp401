package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

import a6.Plate.Color;

public class BeltImpl implements Belt {

	private Plate[] _belt;
	private int _size;

	public BeltImpl(int belt_size) {
		_belt = new Plate[belt_size];
		_size = belt_size;
		if (belt_size < 1) {
			throw new IllegalArgumentException();

		}
	}

	@Override
	public int getSize() {
		return _belt.length;
	}

	// returns the plate at position, if plate at position is null returns null
	@Override
	public Plate getPlateAtPosition(int position) {
		int normalizedPosition = ((position % _size) + _size) % _size;
		
		if (!(_belt[normalizedPosition] == null)) {
			return _belt[normalizedPosition];
		} else {
			return null;
		}

	}

	@Override
	/*
	 * sets plate at position passed through the constructor if value for plate is
	 * null, throws illegal argument exception if value for position is null, throws
	 * belt plate exception
	 */
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}
		if (this.getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}
		int normalizedPosition = position;
		if (position >= _size - 1 || position < 0) {
			normalizedPosition = ((position % _size) + _size) % _size;
		}
		_belt[normalizedPosition] = plate;
	}

	@Override
	// clears plate at a given position
	public void clearPlateAtPosition(int position) {
		_belt[position] = null;
	}

	@Override
	// removes plate at a given position and returns prior plate
	public Plate removePlateAtPosition(int position) {
		if (_belt[position] == null) {
			throw new NoSuchElementException();
		} else {
			Plate priorPlate = _belt[position];
			_belt[position] = null;
			return priorPlate;
		}

	}

	/*
	 * loops through the belt array, and sets plate to either position passed
	 * through the constructor or the closest null index. Loops through all indices
	 * back to beginning of array if null index isn't numbered behind passed
	 * position
	 */
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {

		for (int i = 0; i < _size; i++) {
			try {
				setPlateAtPosition(plate, position + i);
				return position;
			} catch (BeltPlateException e) {

			}
		}

		throw new BeltFullException(this);
	}
	
	public Iterator iterator() {
		return new BeltIterator(this,0);
	}

	@Override
	public Iterator iteratorFromPosition(int position) {
		// TODO Auto-generated method stub
		return new BeltIterator(this, position);
	}

	//rotates the plate array by position + 1
	public void rotate() {
		Plate temporaryPlate = _belt[_belt.length - 1];
		for(int i = _belt.length - 1; i > 0; i--) {
			_belt[i] = _belt[i - 1];
		}
		_belt[0] = temporaryPlate;
	}

	@Override
	public Iterator<Plate> iterator(double maxPrice) {
		return new PriceThresholdBeltIterator (this, 0, maxPrice);
	}

	@Override
	public Iterator<Plate> iterator(Color color) {
		return new ColorFilteredBeltIterator(this, 0, color);
	}

	@Override
	public Iterator<Plate> iteratorFromPosition(int position, double maxPrice) {
		return new PriceThresholdBeltIterator(this, position, maxPrice);
	}

	@Override
	public Iterator<Plate> iteratorFromPosition(int position, Color color) {
		return new ColorFilteredBeltIterator(this, position, color);
	}

}
