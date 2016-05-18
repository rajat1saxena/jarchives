/**
* This class establishes some of the best practices told under item 40
*
* - For parameter types, favor interfaces over classes
* - Prefer two-element enum types to boolean parameters
*/
import java.util.*;

class Item40{
	// the following enum saves us from designing the 
	// printPersonType in a boolean way i.e true for good person
	// and false for bad person. Plus in future we can add more
	// types as well.
	private static enum PersonType {
		GOOD,
		BAD
	}

	// simple method to print person type
	private static void printPersonType(PersonType p) {
		System.out.println("Person type: " + p);
	}
	
	// simple method to iterate over Map
	// this tests the first point of this demo
	private static void printMap(Map m) {
		System.out.println("Printing map...");
		System.out.println("---------------");
		// There is a gotcha in the following statement
		// read this for more details:
		// http://stackoverflow.com/a/7219154/942589
		for(Map.Entry<String, String> entry : (Set<Map.Entry<String, String>>) m.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	public static void main(String args[]) {
		// simply prints person type based on enum passed
		printPersonType(PersonType.GOOD);
		
		// create a new hashmap
		Map<String, String> m = new HashMap<String, String>();
		m.put("Rajat", "Saxena");
		m.put("Mohd", "Asif");
		printMap(m);
	}
}
