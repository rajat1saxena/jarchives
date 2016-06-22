/**
* Representative of Item 32: Use EnumSet instead of bit fields.
*
* This program demonstrates a simple way to representing on/off states
* of similar kind of data. Let's suppose there are five friends. How would
* you represent how many of them where in your party last night?
*
* NOTE: This program is a reconstruction of algorithms/BitField.java
*/
import java.util.Set;
import java.util.EnumSet;
import java.util.Iterator;

final class Item32 {
	private static enum Member { RAMESH, SURESH, PRIYA, AHSAN, GITA; }

	/**
	* Prints members present in the party.
	*
	* @param str enumset for members who attended the party
	*/
	private static void printStatus(Set<Member> str) {
		// Dump the raw state to the console.
		// Since it is a set so the items in str will be in same order
		// as they are defined in the enum Member.
		System.out.println(str.toString());

		for (Iterator it = str.iterator(); it.hasNext(); ) {
			// Get the member from iterator
			Member member = (Member) it.next();

			// Individual checks for each members
			switch (member) {
				case RAMESH:
					System.out.println("Ramesh was present\n");
					break;
				case SURESH:
					System.out.println("Suresh was present\n");
					break;
				case PRIYA:
					System.out.println("Priya was present\n");
					break;
				case AHSAN:
					System.out.println("Ahsan was present\n");
					break;
				case GITA:
					System.out.println("Gita was present\n");
					break;
			}
		}
	}	

	public static void main(String args[]) {
		// First party
		// Only Ramesh and Suresh attended the party
		System.out.println("First party's listing: \n");
		printStatus(EnumSet.of(Member.RAMESH, Member.SURESH));	
		
		// Second party
		System.out.println("Second party's listing: \n");
		printStatus(EnumSet.of(Member.RAMESH, Member.GITA, Member.PRIYA));	
		
	}
} 
