/**
* In this program we will see we can mutate some array which happens
* to be private final member of an immutable class. 
* Conclusion: The array is successfully manipulated, so defensive copying
* is a must as far as mutable objects are concerned.
*/

// Note: This class is not exactly immutable as it has an array which is
// always mutable and we are not using techniques like defensive copying
// etc.
final class Immut {
	private final int id;
	private final int[] rollNumbers;

	public Immut(int id, int[] rollNumbers) {
		this.id = id;
		this.rollNumbers = rollNumbers;
	}

	// no mutator i.e setter

	// getters
	public int getId() { return this.id; }
	public int[] getRollNumbers() { return this.rollNumbers; }
}

class ImmutableArrayChange {
	public static void main (String args[]) {
		int[] imArr = {1, 2, 3};
		Immut im = new Immut(1, imArr);

		// let's try to manipulate the array
		int[] refArr = im.getRollNumbers(); // Get the reference to array
		// change a member of array
		refArr[1] = -1;
		// let's print the original array
		for(int i : im.getRollNumbers()) {
			System.out.println(Integer.toString(i));
		}
	}
} 
