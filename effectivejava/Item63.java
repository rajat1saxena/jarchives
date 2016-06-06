/**
* Representative of Item 63: Include failure-capture information
* in detail messages.
*
* It is recommended to read more about the constructors 'Exception'
* class offers. Link: https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
*
* Note: This item produces an exception and it is the expected
* outcome.
*/
final class Item63 {
	/**
	* Custom exception wrapper for IndexOutOfBoundsException.
	*
	* Since it extends Exception class so it will be a checked
	* exception so it should be explicitly caught or declared
	* to be thrown.
	*/
	private static class InvalidIndexException extends
		Exception {

		// Constructors
		public InvalidIndexException() {
			super();
		}
		public InvalidIndexException(Throwable cause) {
			super(cause);
		}
		public InvalidIndexException(int lowerBound, int upperBound,
			int index, Throwable cause) {
			super("Lower bound: " + lowerBound + ", Upper Bound: "+
				upperBound + ", Index: " + index, cause);
		}
	}

	private static class Api {
		private final static int MAX_ITEMS = 5;

		/**
		* Iterates over a fixed array to produce an exception.
		* @throws InvalidIndexException if the index is out of
		* range {@code index<0 || index > size()}.
		*/
		static void iterateAndThrow() throws InvalidIndexException {
			int[] a = new int[MAX_ITEMS];

			// Allocate values to elements of array
			for(int i=0; i<MAX_ITEMS; i++) {
				a[i] = i;
			}

			// Iterate to access inaccessible element
			for(int i=0; i<10; i++) {
				try {
					System.out.println(a[i]);
				} catch(IndexOutOfBoundsException e) {
					// If you pass exception object 'e'
					// as an argument as shown below, you
					// will get an extra 'Caused by...'
					// section in exception's stack trace
					// This is due to the exception chaining
					// constructor we have used in our
					// InvalidIndexException class.
					// throw new InvalidIndexException(e);
						
					// ** Alternate scenario **
					// No exception chaining, hence no 'Caused
					// by...' clause for the following throw.
					// throw new InvalidIndexException();

					// ** Alternate scenario 2 **
					// If you pass lowerbound, upperbound and the
					// the index for which the error occurred, it
					// will be more beneficial for a developer using
					// your library
					throw new InvalidIndexException(0, MAX_ITEMS-1, i, e);
				}
			}
		}
	}

	public static void main(String args[]) {
		try {
			// Call the Api's method so that an exception
			// can be generated.
			Api.iterateAndThrow();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
