/**
* Quicksort Implementation.
*
* As provided in CLRS.
*/
import java.io.*;

final class QuickSort {
	/**
	* Sorts input array using Quick sort.
	*
	* @param A input array
	* @param low lower limit for quick sort
	* @param high upper limit for quick sort
	*/
	static void qsort(int[] A, int low, int high) {
		if (low < high)
		{
			// Get the partition point
			int partitionIndex = partition(A, low, high);

			qsort(A, low, partitionIndex-1);
			qsort(A, partitionIndex + 1, high);
		}
	}

	/**
	* Return the pivot point such that {@code A[i]<pivot} and
	* {@code A[j]>pivot } where i are for elements at left hand side
	* and j is for elements at the right hand side.
	*
	* @param A input array
	* @param low lower limit 
	* @param high upper limit 
	*/
	static int partition(int[] A, int low, int high) {
		int pivot = A[high];
		int i = low - 1;
		for(int j=low; j < high; j++) {
			if(A[j] <= pivot) {
				// Increment i
				i+=1;
				// Swap A[i] and A[j]
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		// Swap A[i + 1] and A[high] (pivot)
		A[high] = A[i+1];
		A[i+1] = pivot;
		return i+1;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
									System.in
								));
		String[] digits = (reader.readLine()).split(" ");
		// Create new array
		int A[] = new int[digits.length];
		// Allocate item to array
		for(int i=0; i<digits.length; i++) {
			A[i] = Integer.parseInt(digits[i]);
		}	
		
		// Call quick sort
		qsort(A, 0, digits.length-1);

		// Print the array
		for (int i=0; i<digits.length; i++ ) {
			System.out.println(Integer.toString(A[i]));
		}
	}
}
