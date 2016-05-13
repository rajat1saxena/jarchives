/**
* Define constants using class 
* (and we should not use interface to define constants)
*/

// using static import to avoid qualifying constants
import static jbloch.ScientificNumbers.*;

class item19 {
	public static void main(String[] args) {
		System.out.println("BOLTZMANN_CONSTANT: " + Double.toString(BOLTZMANN_CONSTANT));
	}
}