package item62;

/**
* Api for all things item62.
*/
public final class Api {
	/**
	* Prints arg to the console.
	*
	* Please <b>DO NOT</b> use it in production environments.
	*
	* @param arg the value to print to console
	* @throws NullPointerException if {@code arg==null}.
	*/
	public void printer(String arg) {
		System.out.println(arg);
	}

	/**
	* Compares two strings.
	*
	* @param arg1 first string value
	* @param arg2 second string value to compare with the first
	* @return comparison result of {@code arg1.equals(arg2)}
	* @throws NullPointerException if
	* {@code arg1==null}.
	*/
	public boolean isEqual(String arg1, String arg2) {
		return arg1.equals(arg2);
	}
}
