/**
* Representative of Item 53: Prefer interfaces to reflection.
*
* To be true, I don't know much about Java Reflection.
*
* This example uses reflection to create instance of the classes
* which are not known at compile time. In this example we don't
* know the Set type i.e HashSet or TreeSet user of this program
* pass to this program. We will use Class.newInstance() method
* to create instance of the passed class and we will refer to 
* the instance using the interface it implements.
*
* PITFALL: I learnt that annotations cannot be applied to assign-
* -ments like s = c.newInstance(). So @SuppressWarning failed to
* compile when it is put right above the assignment. So now it 
* has been moved to main()'s declaration which is allowed by JLS.
*
* Run the program like this:
* > java Item53 java.util.TreeSet haha rajat kaun hai
*/
import java.util.*;

final class Item53 {
	
	// This cast is correct as we are assuming
	// that the user will pass some implementation
	// of a Set interface.
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		Class<?> c = null;
		
		// Find the class
		try {
			c = Class.forName(args[0]);
		} catch(ClassNotFoundException e) {
			// Notice how we are using System.err for
			// catch() clause
			System.err.println("Class not found");
			System.exit(1);
		}

		// Instantiate the class
		Set<String> s = null;
		try {
			s = (Set<String>) c.newInstance();
		} catch(IllegalAccessException e) {
			System.err.println("Class not accessible");
			System.exit(1);
		} catch(InstantiationException e) {
			System.err.println("Class not instantiable");
			System.exit(1);
		}

		// Exercise the set
		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(s);
	}
}
