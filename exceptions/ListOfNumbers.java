/**
* Representative of tutorial at the following page:
* https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html
*
* PITFALL: printStackTrace() return 'void' so cannot be combined
* with println().
*
* PITFALL: At line 17, we have assigned null value to pw, so as to initia-
* -lize the variable and avoid 'variable might not have been initialized'
* error. From JLS section 4.12.5:
* Each class variable, instance variable, or array component is initialized
* with a default value when it is created.
*/
import java.io.*;
import java.util.List;
import java.util.ArrayList;

class ListOfNumbers {
	private static PrintWriter pw;

	public static void main(String args[]) {
		int SIZE = 10;
		List<Integer> list = new ArrayList<Integer>(SIZE);
		PrintWriter pw = null;

		// Initialize the list with dummy values
		for (int i=0; i< SIZE; i++) {
			list.add(new Integer(i));
		}

		// Print the values to a file
		//
		// Following throws a checked exception(IOException) which
		// should be caught.
		try {
				// Checked exception. It won't let the program compile
				// until addressed using THROWS or TRY-CATCH.
				pw = new PrintWriter(new FileWriter
						("/zand/listofnumber.txt")
					);
				for (int i=0; i<SIZE; i++) {
					System.out.println("Value at " + i + " : " + list.get(i));
					// The get(int) method throws IndexOutOfBoundsException
					// which must be caught. Also note that the following
					// exception won't prevent the compilation of the prog-
					// -ram as it is an UNCHECKED exeption.
					pw.println("Value at " + i + " : " + list.get(i));
				}
		} catch(IOException e) {
			System.out.println("IOException: " + e.getMessage());
			// Following code shows hot to call the getStackTrace()
			// on the exception object.
			StackTraceElement elements[] = e.getStackTrace();
			for(int i=0, n=elements.length; i<n; i++) {
				System.err.println(elements[i].getFileName()
					+ ":" + elements[i].getLineNumber()
					+ " >> "
					+ elements[i].getMethodName() + "()");
			}	
		} catch(IndexOutOfBoundsException x) {
			System.out.println("IndexOutOfBoundsException: " + x.getMessage()); 
		}
		// The 'finally' block always executes when the try block exits.
		finally {
			if (pw != null) {
				System.out.println("Closing PrintWriter...");
				pw.close();
			} else {
				System.out.println("PrintWriter is not open");
			}
		}
	}
}
