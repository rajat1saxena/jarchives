/**
* Bubble Sort
*/
class bubblesort{
	public static void main(String args[]){
		boolean swapped = false;
		//int A[] = {56,-89,45,8,23,12,32,0,-78,35,67,1000,-1,785,324};
		int A[] = new int[1000];
		//generating random numbers to fill the array
		for(int i=0;i<1000;i++){
			A[i] = 0 + (int)(Math.random()*(1000)+1); 
		}

		long startTime = System.currentTimeMillis();
		
		/*
		do{
			swapped = false;
			for(int i=1;i<A.length;i++){
				
				if(A[i-1]>A[i]){
					int temp = A[i-1];
					A[i-1] = A[i];
					A[i] = temp;
					// set swapped
					swapped = true;
				}
			}
		}while(swapped==true);
		
		
		// optimization 1
		int n = A.length;
		do{
			swapped = false;
			for(int i=1;i<=n-1;i++){
				if(A[i-1]>A[i]){
					int temp = A[i-1];
					A[i-1] = A[i];
					A[i] = temp;
					// set swapped
					swapped = true;
				}
			}
			n = n-1;    // reduces by one on each iteration, so one comparison less
			
		}while(swapped==true);
		*/

		// optimization 2
		int n;
		do{
			n = 0;
			for(int i=1;i<A.length;i++){
				if(A[i-1]>A[i]){
					int temp = A[i-1];
					A[i-1] = A[i];
					A[i] = temp;
					// set n to i
					n = i;
				}
			}
		}while(n!=0);

		long endTime = System.currentTimeMillis();
		System.out.format("Total running time: %d\n\n",endTime);
		System.out.format("Total running time: %d\n\n",startTime);
		
		for(int i=0;i<A.length;i++){
			System.out.format("%d\n",A[i]);
		}
	}
}