/**
* Item 38: Check parameters for validity
*
* Note that this example produces 'NPE' which is a desired result
*/


class item38{

	// The class is private as item38 class is the sole consumer of the Validator
	// class and 'static' as it does not need access to enclosing class' 
	// instance(Item 22)
	private static class Validator{
		/**
		* Checks if the value is an int or not
		*
		* @param str value to be checked
		* @return true or false
		* @throws NullPointerException if str is null
		*/
		public boolean isNum(String str) {
			if (str == null) throw new NullPointerException("Argument is null");

			// The point of introducing convertAndCheck() is that I want to provide a
			// private method to check assert clause as described by Joshua.
			if (convertAndCheck(str)) {
				return true;
			} else {
				return false;
			}
		}

		// private helper function to check if the string is a number
		private static boolean convertAndCheck(String str) {
			// EJ: nonpublic methods should generally check their parameters using 
			// assertions
			assert str != null;

			// note that following might be bad design i.e using try-catch
			// as branching statement.
			try {
				int value = Integer.parseInt(str);
				return true;
			} catch(Exception e) {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Validator v = new Validator();
		String str = null;
		v.isNum(str);
	}
}