/**
* Representative of Item 49: Prefer primitive type to
* boxed primitives.
*
* Note: This program results in NPE, which is a desired
* result.
*/
import java.util.*;

class Item49 {
	//Problem 1:  Boxed primitives can have same value
	// and different identities.
	private final static Comparator<Integer> naturalOrderBroken = new Comparator<Integer>() {
		public int compare(Integer first, Integer second) {
			return first < second ? -1 : (first == second ? 0 : 1);
		}
	};
	//Problem 1[Fixed]: Following comparator function will first
	// store Integer values to primitive type int values.  
	private final static Comparator<Integer> naturalOrder = new Comparator<Integer>() {
		public int compare(Integer first, Integer second) {
			int f = first; // Auto-unboxing
			int s = second; // Auto-unboxing
			return f < s ? -1 : (f == s ? 0 : 1);
		}
	};

	// Problem 2: Boxed primitives can have null values.
	// Also note that static primitive types are 
	// automatically initialized with default values, 
	// mostly 0 while objects are always null.
	static Integer i;

	// Problem 3: Mixing boxed primitives and primitives
	// in a single operation inside a loop.
	// This is cause severe performance degradation due
	// to the overhead of creating additional objects.
	// An example of this is already done in Item 5.

	public static void main(String args[]) {
		// This will print 1 because compare()'s first and second
		// check will fail as we are comparing objects of type 
		// Integer and not primitive int.
		System.out.println(naturalOrderBroken.compare(
			new Integer(32), new Integer(32)
		));
		// This will print correct answer
		System.out.println(naturalOrder.compare(
			new Integer(32), new Integer(32)
		));

		// Following will result in NPE
		if (i == 32) {
			System.out.println("Nice");
		}	
	}
}
