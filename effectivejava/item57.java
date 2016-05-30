/**
* Representative of Item 57: Use exceptions only for exceptional
* conditions.
*
* In this program we will test that using exceptions to break out
* of the loop is slower as compared to explicit checks.
*
* PITFALL: If 'int i' is defined in the method, you cannot 
* re-define int i in a for loop like this for(int i=0;i 
*/
import java.math.*;

final class Item57 {
	public static void main(String args[]) {
		int[] a = new int[500];
		
		// Assign dummy values to the array elements
		for(int i=0; i < a.length; i++) {
			a[i] = i*2;
		}

		// Use exception to iterate
		long startTime = System.currentTimeMillis();
		int i = 0;
		try {
			while(true) {
				System.out.print(a[i++]);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Loop completed with exception");
		}
		long endTime = System.currentTimeMillis();
		long diff = endTime - startTime;
		System.out.println("Total elapsed time: " +
				diff);

		// Use for loop (explicit checking)
		startTime = System.currentTimeMillis();
		for(int j=0; j < a.length; j++) {
			System.out.print(a[j]);
		}
		endTime = System.currentTimeMillis();
		long diff2 = endTime - startTime;
		System.out.println("Total elapsed time: " +
				diff2);
		BigDecimal exception = new BigDecimal(diff);
		BigDecimal explicit = new BigDecimal(diff2);
		// Why the following divide() method is used
		// read more about this error: 
		// Non-terminating decimal expansion; no exact 
		// representable decimal result.
		BigDecimal ratio = exception.divide(explicit, 
						2, RoundingMode.HALF_UP);
		
		System.out.println("Exception/Explicit: " + ratio.toString());
	}
}
