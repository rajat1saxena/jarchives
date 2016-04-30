/*
* Codechef: https://www.codechef.com/problems/CIELAB
*/
import java.io.*;

class cielab{
	private static BufferedReader reader;
	private static BufferedWriter writer;

	static{
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));	
	}

	public static void main(String args[]) throws IOException{

		String[] input = reader.readLine().split(" ");

		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);

		// constraints
		if(B<1 || B>A || B==A || B>10000 || A>10000){
			System.exit(0);
		}
		if(!((1<=B) && (B<A) && (A<=10000))){
			System.exit(0);
		}

		int result = A-B;

		obfuscate(result);
	}

	private static void obfuscate(int result) throws IOException{
		
		// select a random number from 0 to 3
		int max = Integer.toString(result).length() - 1;
		int min = 0;
		int range = (max-min) + 1;
		int pos = (int)(Math.random()*range) + min;

		max = 9;
		min = 1;
		range = (max-min) + 1;
		int candidate = (int)(Math.random()*range) + min;

		// replace character at the random with 3
		String resultStr = Integer.toString(result);
		String temp = resultStr.substring(0,pos)+candidate+resultStr.substring(pos+1);
		if(Integer.parseInt(temp)==result){
			// repeat the process
			obfuscate(result);
		}else{
			writer.append(temp);
			writer.flush();
		}
	}
}