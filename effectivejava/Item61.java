/**
* Representative of Item 61: Throw exceptions appropriate to the 
* abstraction.
*
* This item talks about two things:
* - exception translation
* - exception chaining
*
* We are going to create a custom exception which is a high-level
* representation of a low-level exception using 'exception trans-
* lation' and set the cause using chaining-aware constructor.
*
* Note: This item produces an exception and it is the expected
* outcome.
*/
final class Item61 {
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
	}

	private static class Api {
		/**
		* Iterates over a fixed array to produce an exception.
		* @throws InvalidIndexException if the index is out of
		* range {@code index<0 || index > size()}.
		*/
		static void iterateAndThrow() throws InvalidIndexException {
			int[] a = new int[5];

			// Allocate values to elements of array
			for(int i=0; i<5; i++) {
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
					throw new InvalidIndexException(e);
						
					// ** Alternate scenario **
					// No exception chaining, hence no 'Caused
					// by...' clause for the following throw.
					// throw new InvalidIndexException();
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
