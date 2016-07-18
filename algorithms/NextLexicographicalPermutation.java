// This program find the next permutation of number sequence.
// Read Wikipedia article or Stack Overflow question for the details

final class NextLexicographicalPermutation {
	/**
	* Returns the largest i such that {@code A[i] < A[i+1]}
	*
	* @param A reference array in which we have to find the pivot
	* @returns the pivot point such that {@code A[pivot] < A[pivot +1]}
	*/
	private static int findPivot (int A[]) {
		int pivot = -1; 		// edge case, A is the final permutation
		for (int i=0; i<A.length-1; i++) {
			if (A[i] < A[i+1]) {
				pivot = i;
			}
		}
		return pivot;
	}

	/**
	* Return the largest index in array A such that {@code A[i] < A[output]}
	*
	* @param A reference array in which we have to find the pivot
	* @param i pivot's index
	* @return largest index such that {@code A[i] < A[largestIndex]}
	*/
	private static int findLargestIndex(int A[], int i) {
		int largestIndex = -1; // this should never happen
		for (int j=i+1; j<A.length; j++) {
			if (A[j] > A[i]) {
				largestIndex = j;
			}
		}
		return largestIndex;
	}

	/**
	* Reverses the input array {@literal A[]} from start to {@code A.length}
	*
	* @param A input array, to be reversed
	* @param start the index from which the reverse process should start
	*/
	private static void reverseSubArray(int A[], int start) {
		int end = A.length - 1;
		while (start < end) {
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++;
			end--;
		}
	}

	// Driver program
	public static void main(String args[]) {
		int A[] = new int[4];
		A[0] = 1;
		A[1] = 2;
		A[2] = 3;
		A[3] = 4;
		
		int pivot = findPivot(A);
		if (pivot == -1) {
			System.out.println("Array is the last permutation");
			return;
		}

		// find largest index such that A[pivot] < A[largestIndex]
		int largestIndex = findLargestIndex(A, pivot);
		if (largestIndex == -1) {
			System.exit(1);
		}

		// swap A[pivot] with A[largestIndex]
		int temp = A[pivot];
		A[pivot] = A[largestIndex];
		A[largestIndex] = temp;

		// reverse the array from pivot+1 till end
		reverseSubArray(A, pivot + 1);

		// print the final array
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + "\t");	
		}
	}
}
