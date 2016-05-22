/**
* Item 43: Return empty arrays or collections, not nulls
*
* Note: The following program returns NullPointerException
* which is an expected behavior.
*/
import java.util.*;

final class Item43{
	// The right way to return an array from a collection
	private static final String[] EMPTY_ITEM_ARRAY = new String[0];

	private static List<String> listitems;

	// Following function return 'null' on empty
	// input collection or array of all items
	private static String[] getArray(List<String> items) {
		// This check is the problem which should
		// be avoided
		if (items.size()==0)
			return null;

		String[] output = new String[items.size()];

		for (int i=0; i< items.size(); i++) {
			output[i] = items.get(i);
		}

		return output;
	}

	// Following function solve the null returning
	// problem of getArray(). Collection.toArray(T[]) guarantees
	// that the input array will be returned if it is large 
	// enough to holde the collection. Therefore the idiom
	// never allocates an empty array.
	private static String[] getArray2(List<String> items) {
		return items.toArray(EMPTY_ITEM_ARRAY);
	}

	public static void main(String args[]) {
		listitems = new ArrayList<String>();
		listitems.add("Rajat");
		listitems.add("Saxena");
		listitems.add("Himani");
		listitems.add("Uganda");
		listitems.add("Ina");

		// Problem: The following function can cause 
		// runtime error in an empty array is passed to
		// the function due to 'return null' in the
		// function. So while accessing the 'newitems' we
		// will get NPE. Try swapping getArray() with getArray2()
		// to avoid NPE.
		String[] newitems = getArray(new ArrayList<String>());
		for(String item: newitems) {
			System.out.println(item);
		}
	}	
}
