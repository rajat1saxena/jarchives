/**
* Item 42: Use varargs judiciously
*
* JBloch: We can replace last argument of any function
* which is a array with a vararg.
*/
import java.util.Arrays;

final class Item42{
	static int sum(int... args) {
		int sum = 0;
		for(int arg : args) {
			sum += arg;
		}
		return sum;
	}	
	
	// Following function expects 'one or more' arguments
	// it solves problem 1
	static int sum2(int a, int... args) {
		int sum = a;
		for(int arg : args) {
			sum += arg;
		}
		return sum;
	}	

	public static void main(String args[]) {
		int sume = sum(1,2,3,4);
		System.out.println(sume);

		// problem 1: the sum() method does not check
		// if no argument in passed to it.Hence it is 
		// not well defined. It is created to
		// accept 'zero or more' arguments which we
		// definitely don't want in our case.
		// You can try the following to validate it.
		// it will run just fine but is not a valid case.
		int sume2 = sum();
		
		// Following will produce compile time error
		// System.out.println(sum2());
		// Following will produce compile time error
		System.out.println(sum2(2));

		// problem 2: printing array of int using Array.asList()
		// This will print useless output like [[I@659e0bfd]
		// Read more about it on page 199.
		int[] digits = {1,2,4,45,78,89};
		System.out.println(Arrays.asList(digits));
		// To solve problem 2, there is a toString() method
		System.out.println(Arrays.toString(digits));
	}
}
