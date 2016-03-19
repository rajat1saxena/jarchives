/**
* The ultra simple hash table
*
* It only maps a string value to its integer equivalent index
*/
public class hashtable1{
	private static final int arraySize = 30;
	// to hold the hashtable, the +1 is 
	// for 'array starts with 0 and end at n-1, if number is n'
	// private String[] out = new String[arraySize + 1];

	public hashtable1(String[] inp,String[] out){
		for(int i=0;i<inp.length;i++){
			// it basically allocate "5" at the array position 5
			out[Integer.parseInt(inp[i])] = inp[i];
		}
	}

	public static void main(String args[]) {
		String[] inp = {
			"1",
			"2",
			"4",
			"9",
			"0",
			"12",
			"21",
			"8"
		};

		String[] out = new String[arraySize + 1]; 

		hashtable1 ht = new hashtable1(inp,out);

		// print hashtable
		for(int i=0;i<=arraySize;i++) {
			System.out.print(i+":"+out[i]+"\t");
		}
	}
}