/**
* Insertion Sort
*/
class insertionsort{
	public static void main(String args[]){
		int A[] = new int[100];

		// filling array A with random values between 0 and 100(exclusive)
		for(int i=0;i < A.length;i++){
			A[i] = (int)(Math.random()*(100-0) + 0);
		}

		// printing initial array
		for(int i=0;i < A.length; i++){
			System.out.println(Integer.toString(A[i]));
		}

		System.out.println("\n");

		// Insertion sort algo
		for(int i = 1;i < A.length; i++){
			for(int j=i;j > 0;j--){
				if(A[j] < A[j-1]){
					int temp = A[j];
					A[j] = A[j-1];
					A[j-1] = temp;
				}
			}
		} 
		// Insertion sort algo ends

		// printing final array
		for(int i=0;i < A.length; i++){
			System.out.println(Integer.toString(A[i]));
		}
	}
}