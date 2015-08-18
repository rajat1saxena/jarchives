/**
 * Prints collection using For-each
 */
// -- Java 8
// ~/Dev/jdk1.8.0_45/bin/javac
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class intro{
	public static void main(String args[]){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Rajat");
		names.add("Saxena");
		names.add("Arvind");
		names.add("Preet");
		names.add("Rajat");
		names.add("Arvind");

		ArrayList<String> lastnames = new ArrayList<String>();
		lastnames.add("Preet");
		lastnames.add("Arvind");

		// for(Iterator<?> it=names.iterator(); it.hasNext();){
		// 	it.next();
		// 	System.out.println(it);
		// 	it.remove();
		// }

		for(String name:names){
			System.out.println(name);
		}

		// remove duplicates using Sets; Hashset for unordered Set/ TreeSet for ordered Set
		Set<String> noDupNames = new TreeSet<String>(names);

		System.out.println("------------");
		for(String name:noDupNames){
			System.out.println(name);
		}

		Set<String> replica = new TreeSet<String>(names);

		// Intersection
		System.out.println("------------");
		replica.retainAll(lastnames);
		for(String name:replica){
			System.out.println(name);
		}
	}
}