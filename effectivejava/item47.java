/**
* Representative of Item 47: Know and use the libraries
*/
import java.util.Random;

final class Item47 {
	private final static Random rnd = new Random();

	public static void main(String args[]) {
		// JBloch enlisted the flaws in using
		// Math.abs((new Random()).nextInt) %n
		// Following is the correct way to 
		// generate random numbers
		System.out.println(rnd.nextInt(2000));
	}
}
