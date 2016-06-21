/**
* Bit Field Enumeration.
*
* This program demonstrates a simple way to representing on/off states
* of similar kind of data. Let's suppose there are five friends. How would
* you represent how many of them where in your party last night?
*/
final class BitField {
	private static final int MEMBER_RAMESH = 1 << 0;
	private static final int MEMBER_SURESH = 1 << 1;
	private static final int MEMBER_PRIYA = 1 << 2;
	private static final int MEMBER_AHSAN = 1 << 3;
	private static final int MEMBER_GITA = 1 << 4;

	/**
	* Prints members present in the party.
	*
	* @param str bitfield string of members
	*/
	private static void printStatus(int str) {
		// Individual checks for each members
		if ((str & (1 << 0)) == (1 << 0))   System.out.println("Ramesh was present\n");
		if 	((str & (1 << 1)) == (1 << 1))   System.out.println("Suresh was present\n");
		if ((str & (1 << 2)) == (1 << 2))   System.out.println("Priya was present\n");
		if ((str & (1 << 3)) == (1 << 3))   System.out.println("Ahsan was present\n");
		if ((str & (1 << 4)) == (1 << 4))   System.out.println("Gita was present\n");
	}	

	public static void main(String args[]) {
		if (args.length==0) {
			System.out.println("Provide argument");
		} else {
			int str = Integer.parseInt(args[0]);
			printStatus(str);
		}
	}
} 
