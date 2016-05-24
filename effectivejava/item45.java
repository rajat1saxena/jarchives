/**
* Representative of Item 45: Minimize the scope of local variables
*/
import java.util.*;

final class Item45{
	public static void main(String args[]) {
		Collection<String> c = new HashSet<String>();
		c.add("Ramesh");
		c.add("Suresh");
		c.add("Vikram");
				
		// Point #2: preferred idiom for iterating over 
		// a collection
		System.out.println("Using for-each() to iterate");
		for (String cv : c) {
			System.out.println(cv);
		}

		// Point #3: No for-each loop or generics before
		// 1.5
		System.out.println("Using iterator() to iterate");
		for(Iterator i = c.iterator(); i.hasNext(); ) {
			// Notice type conversion in following statement
			System.out.println((String) i.next()); 
		}

		// Point #1: Declare local variable when it is needed
		// and not always at the start of the method.
		String[] cvals = new String[c.size()];

		// Point #4: Declare and initilize two loop variables
		// using single 'for'. So both i and n will have proper
		// scopes
		for (int i=0, n=expensiveOperation(); i < c.size(); i++){
			cvals[i] = "Avina";
		}
	}
	
	private static int expensiveOperation() {
		return 2*3*4*56;
	}
}
