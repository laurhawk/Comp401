package a7;

import java.util.ArrayList;
import java.util.List;

import comp401sushi.Plate;


public class BeltImpl implements Belt {

	private Plate[] _belt;
	private ArrayList<BeltObserver> _observer;
	private Customer[] _customer;
	
	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		
		_belt = new Plate[belt_size];
		_observer = new ArrayList<BeltObserver>();
		_customer = new Customer[belt_size];
	}

	@Override
	public int getSize() {
		return _belt.length;
	}

	@Override
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}

	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		_belt[position] = plate;
		this.notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position));
	}


	@Override
	public void clearPlateAtPosition(int position) {
		position = normalize_position(position);
		
		this.notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, _belt[position], position));
		_belt[position] = null;		
		
	}

	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}
	
	
	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position+offset);

				return normalize_position(position+offset);
			}
			catch (BeltPlateException e) {
				offset += 1;
			}
		}
		throw new BeltFullException(this);
	}

	@Override
	public void rotate() {
		Plate last_plate = _belt[getSize()-1];
		
		for (int i=getSize()-1; i>0; i--) {
			_belt[i] = _belt[i-1];
		}
		_belt[0] = last_plate;
		
		for(int i = 0; i < _customer.length; i++) {
			if(_customer[i] != null) {
				if(_belt[i] != null) {
					_customer[i].observePlateOnBelt(this, _belt[i], i);
				}
			}
		}
		
		
	}

	@Override
	public void addBeltObserver(BeltObserver o) {
		// TODO Auto-generated method stub
		_observer.add(o);
		
	}

	@Override
	public void removeBeltObserver(BeltObserver o) {
		// TODO Auto-generated method stub
		_observer.remove(o);
		
	}
	
	public void notifyObservers(PlateEvent e) {
		for(BeltObserver observer : _observer) {
			observer.handlePlateEvent(e);
		}
	}

	@Override
	public void registerCustomerAtPosition(Customer c, int position) {
		position = normalize_position(position);
		if(c == null) {
			throw new IllegalArgumentException();
		}
		if(_customer[position] != null) {
			throw new RuntimeException();
		}
		for(int i = 0; i < _customer.length; i++) {
			if(c == _customer[i]) {
				throw new RuntimeException();
			}
		}
		_customer[position] = c;
	}

	@Override
	public Customer unregisterCustomerAtPosition(int position) {
		position = normalize_position(position);
		if(_customer[position] == null) {
			return null;
		}
		Customer unregistered = _customer[position];
		_customer[position] = null;
		return unregistered;
	}
}
