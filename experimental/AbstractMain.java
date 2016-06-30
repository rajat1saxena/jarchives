/**
* This program demonstrates that "An abstract class cannot be instantiated
* but can be invoked if it contains a main method".
*/
abstract class AbstractMain {
	/**
	* A random abstract method.
	*/
	abstract void randomMethod();

	public static void main(String args[]) {
		System.out.println("Success!");
	}
}
