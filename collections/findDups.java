import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

class findDups{
	public static void main(String args[]){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Rajat");
		names.add("Saxena");
		names.add("Arvind");
		names.add("Preet");
		names.add("Rajat");
		names.add("Arvind");

		// create two sets so that both contain unique items ,one contains words
		// which occur only once and second which occur more than once
		Set<String> uniques = new HashSet<String>();
		Set<String> dups = new HashSet<String>();

		// Sort names
		for(String name:names){
			if(!uniques.add(name)){
				dups.add(name);
			}
		}

		// remove dups from unique set [destructive operation]
		uniques.removeAll(dups);

		System.out.println("Unique items\n-------------");
		for(String unique:uniques){
			System.out.println(unique);
		}
	}	
}