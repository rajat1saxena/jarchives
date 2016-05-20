/**
* Item 41: Choose overloading wisely
*
* J Bloch: Overriding is the norm and overloading is the exception
*
* In this example we are reminded the fact that in case of
* overloading which method will be invoked is chosen at
* compile time(static) hence depends on compile time type
* while in case of overriding the method is chosen from runtime
* type of the variable.
*/
import java.util.*;

class Item41{
	/*
	* The following class has 3 overloaded methods. Only
	* the third one will be invoked as it will decided during
	* compile time based on the compile time instance type, 
	* which is a Collection<?>.
	*/
	// Pitfall: To make the member methods of the following
	// class 'static', we have to make the class static itself 
	private final static class CollectionType {
		public static void printType(Set<?> s) {
			System.out.println("Set");
		}
		public static void printType(List<?> s) {
			System.out.println("List");
		}
		public static void printType(Collection<?> s) {
			System.out.println("Unknown collection");
		}

		// to solve the problem of this class, following
		// should be the only method instead of above three
		// overridden methods
		//
		// Uncomment to solve problems of these overloaded
		// methods
		/*
		public static void printType(Collection<?> s) {
			String result =  s instanceof Set ? "Set" :
				s instanceof List ? "List" : 
				"Unknown collection";
			System.out.println(result);
		}
		*/
	}

	public static void main(String args[]) {
		System.out.println("Problem: Three different types yielding same result");
		Collection<?>[] collection = {
			new HashSet<String>(),
			new ArrayList<String>(),
			new HashMap<String, Integer>().values()
		};

		// iterate and print types of collection
		for(Collection<?> c : collection) {
			CollectionType.printType(c);
		}

		System.out.println("To solve, use the 4th method as the only method, instead of three overloaded ones");
	}
}
