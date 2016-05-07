package competitive;

/*
* Problem: http://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
*/
class formarray{
	private static int[] elem;

	private static boolean areAllZeros(){
		for(int i=0; i<elem.length;i++){
			if(elem[i]>0){
				return false;
			}
		}
		return true;
	}

	private static boolean hasAnyOdd(){
		for(int i=0; i<elem.length;i++){
			if(elem[i]%2 != 0){
				// odd element discovered
				return true;
			}
		}
		return false;
	}

	private static boolean decreaseFirstOddByOne(){
		for(int i=0; i<elem.length;i++){
			if(elem[i]%2 != 0) {
				// odd element discovered
				elem[i]-=1;
				// return true if one is decreased from first odd element
				return true;
			}
		}
		return false;
	}

	private static void DivideArrayElementsByTwo(){
		for(int i=0; i<elem.length;i++){
			// we are not checking element to be even as it has already been checked
			elem[i] = elem[i]/2;
		}
	}

	public static void main(String args[]){
		elem = new int[args.length];

		// assign values
		for(int i=0;i<args.length;i++){
			elem[i] = Integer.parseInt(args[i]);
		}

		int steps=0;
		while(!areAllZeros()){
			if(hasAnyOdd()){
				// the array has odd members
				if(decreaseFirstOddByOne()){
					steps++;
				}
			} else {
				DivideArrayElementsByTwo();
				steps++;
			}
		}

		System.out.println("Total steps required: "+steps);

	}
}