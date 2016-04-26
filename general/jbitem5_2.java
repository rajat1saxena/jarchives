/*
* Efficient Java::Item 5
* Avoid creating unnecessary objects
* 
* Here auto-boxing slows things down. Always prefer primitive to boxes primitives
*/
class jbitem5_2{
	public static void main(String args[]){
		// Boxed primitive way :: slower than primitive variable
		Long sum = 0L;
		long startTime = System.currentTimeMillis();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			sum+=i; // 2pow31 unnecessary Long instances
		}
		long endTime = System.currentTimeMillis();
		long diff = endTime-startTime;
		System.out.println("Elapsed: " + Long.valueOf(diff) + " ms");

		// Primitive way :: much faster
		long sum2 = 0L;
		startTime = System.currentTimeMillis();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			sum2+=i;
		}
		endTime = System.currentTimeMillis();
		diff = endTime-startTime;
		System.out.println("Elapsed: " + Long.valueOf(diff) + " ms");
	}
}