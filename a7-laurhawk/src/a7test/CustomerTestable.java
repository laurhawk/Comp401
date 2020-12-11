package a7test;

import a7.*;
import comp401sushi.*;

public class CustomerTestable implements Customer {
	public int callCount = 0;

	public CustomerTestable() {
	}

	public void observePlateOnBelt(Belt b, Plate p, int position) {
		callCount += 1;
	}

	public int getCallCount() {
		return callCount;
	}

	public void resetCallCount() {
		callCount = 0;
	}
}