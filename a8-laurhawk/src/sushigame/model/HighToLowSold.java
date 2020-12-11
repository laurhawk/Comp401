package sushigame.model;

import java.util.Comparator;

public class HighToLowSold implements Comparator<Chef> {

	@Override
	public int compare(Chef a, Chef b) {
		// We do b - a because we want largest to smallest
		return (int) (Math.round(b.foodConsumed()*100.0) - 
				Math.round(a.foodConsumed()*100));
	}		
}
