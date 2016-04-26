/*
* Brute force solution to maximum subarray problem
*/
package maximumsubarray;

import java.io.*;

class bruteforce{
	public static void main(String args[]) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the size of an array: ");
		int n = Integer.parseInt(reader.readLine());

		// create an array to hold the required change array
		int element[] = new int[n];

		// entertain values
		int counter = 0;
		String line;

		System.out.println("Enter the elements of the array: ");
		while(counter<n && (line=reader.readLine()) != null && line.length()!=0) {
			element[counter] = Integer.parseInt(line);
			counter++;
		}

		// bruteforce solution
		int maxsum = -1;
		int start = -1;
		int end = -1;
		int sum,left_sum,max_left;
		for(int i=0;i<n;i++){
			sum = 0;
			left_sum = -1;
			max_left = i;
			for(int j=i;j>=0;j--){
				sum = sum + element[j];
				if (sum > left_sum) {
					left_sum = sum;
					max_left = j;
				}
			}

			// compare maximum subarray returned by
			// above loop with existing subarray
			if (left_sum > maxsum) {
				maxsum = left_sum;
				start = max_left;
				end = i;
			}

		}

		// print all values
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		if (maxsum > -1) {
			// program detected maximum subarray, so print
			output.append(Integer.toString(maxsum));
			output.newLine();
			output.append("Start: " + start + "; End: " + end);
		}


		// System.out.println("All elements: ");
		// BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		// for(int i=0; i<n; i++){
		// 	output.append(Integer.toString(element[i]));
		// 	output.newLine();
		// }

		output.flush();
	}
}