package a7;

import comp401sushi.Plate;

//creates an interface for the type customer which accepts
//parameters based on their interaction with the belt
public interface Customer {
	void observePlateOnBelt(Belt b, Plate p, int position);
}
