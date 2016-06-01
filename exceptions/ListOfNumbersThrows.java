/**
* Representative of tutorial at the following page:
* https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html
*
* Note: This demo is adapted for 'throws' clause.
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

final class ListOfNumbersThrows {
	/**
	* Custom exception for invalid files
	*/
	private static class InvalidTypeOfFileException
					extends Exception {
		public InvalidTypeOfFileException() {
			super();
		}
	}

	/**
	* API class to print etc.
	*/
	private static class Api {
			static void printToFile(String fileName) throws IOException,
				IndexOutOfBoundsException, 
				InvalidTypeOfFileException {

				// Check if file is .txt file or not
				if (!fileName.split("\\.")[1].equals("txt")) {
					throw new InvalidTypeOfFileException();	
				}

				int SIZE = 10;
				List<Integer> list = new ArrayList<Integer>(SIZE);

				// Initialize the list with dummy values
				for (int i=0; i< SIZE; i++) {
					list.add(new Integer(i));
				}

				// Print the values to a file
				//
				// Following throws a checked exception(IOException) which
				// should be caught.
				// Checked exception. It won't let the program compile
				// until addressed using THROWS or TRY-CATCH.
				PrintWriter pw = null;
				pw = new PrintWriter(new FileWriter
						("listofnumber.txt")
					);
				for (int i=0; i<SIZE; i++) {
					System.out.println("Value at " + i + " : " + list.get(i));
					// The get(int) method throws IndexOutOfBoundsException
					// which must be caught. Also note that the following
					// exception won't prevent the compilation of the prog-
					// -ram as it is an UNCHECKED exeption.
					pw.println("Value at " + i + " : " + list.get(i));
				}
			}
		}

	// Note that how we are not at all catching IOException in
	// our program
	public static void main(String args[]) throws IOException{
		try {
			Api.printToFile("zandfile.trt");
		} catch(InvalidTypeOfFileException e) {
			System.err.println("File should be a text file");
		}
	}
}
