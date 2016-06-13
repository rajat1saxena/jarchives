/**
* Fibonacci Printer
*
* This program was designed to study runtime of Java programs
* as described in Java Mag. (Mar-Apr, 2016) version.
*
* Read: What is the JIT compiler actually doing?
*
* Some commands:
* > time java -XX:+PrintCompilation Fibonacci 48
*/
public final class Fibonacci {
	/**
	* Calculates the Fibonacci series till the number n
	*
	* @param num limit 
	*/
	private static int fib(int num) {
		if (num <= 0) 
			return 0;
		else if (num == 1)
			return 1;
		else
			return fib(num-1) + fib(num-2);	
	}

	public static void main(String args[]) {
		try {
			int num = Integer.valueOf(args[0]);
			System.out.println(fib(num));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("You forgot a command line argument");
		}
	}
}
