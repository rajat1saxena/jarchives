/*
* Codechef: https://www.codechef.com/problems/CIELAB
*/
import java.io.*;

class cielab2{
	private static BufferedReader reader;
	private static BufferedWriter writer;

	static{
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));	
	}

	public static void main(String args[]) throws IOException{
		// String a,b;
		// if((a=reader.readLine())==null || a.length()==0){
		// 	System.exit(0);
		// }
		// if((b=reader.readLine())==null || b.length()==0){
		// 	System.exit(0);
		// }
		String[] input = reader.readLine().split(" ");

		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);

		int result = A-B;

		int temp = (result%10==9) ? --result : ++result;
		writer.append(Integer.toString(temp));
		writer.flush();
	}
}