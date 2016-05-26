/**
* Representative of Item 51: Beware of performance 
* of String concatenation.
*
* This program measures the performance of string
* concatenation against StringBuilder's.
* 
* IMPORTANT: String concatenation takes quadratic
* time while StringBuilder takes linear time.
*/
final class Item51 {
	private final static String CONSTANT_LINE =	"Hello everyone!"
			+ "This is how you create multiline string in Java"
			+ "Isn't it a LOL thing?";
	private final static int ITERATIONS = 100000;

	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		String result = "";
		for(int i=0; i< ITERATIONS; i++) {
			result += Item51.CONSTANT_LINE;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Concatention took: " + (endTime-startTime)/1000);
		
		// Now test using StringBuilder
		StringBuilder sb = new StringBuilder(ITERATIONS * CONSTANT_LINE.length());
		startTime = System.currentTimeMillis();
		for(int i=0; i < ITERATIONS; i++) {
			sb.append(CONSTANT_LINE);	
		}
		endTime = System.currentTimeMillis();	
		System.out.println("StringBuilder took: " + (endTime-startTime)/1000);
	}
}
