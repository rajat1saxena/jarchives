/**
* This program illustrates techinques to fast multiply using
* 'exponentiation by squaring' technique.
*/
class Exponentiation {
	/**
	* Produces output by method 1 on Wikipedia.
	* 
	* For large enough result, {@code result%1000000007 } is produced
	* as final result;
	*/
	private static long raiseTo (int base, int exp) {
		// Base cases
		if (exp == 0) return 1;
		if (exp == 1) return base;
		
		long temp;
		if (exp % 2 == 0) {
			temp = (long) Math.pow(raiseTo(base, exp/2), 2);	
		} else {
			temp =  base * (long) Math.pow(raiseTo(base, (exp -1)/2), 2); 
		}

		if (temp >= 1000000007) return temp % 1000000007;
		else return temp;
	}

	/**
	* Calculates the number of multiplications in 'exponentiation by
	* squaring' process.
	*
	* This implementation considers squaring as a multiplication. So
	* the results are inclusive.
	*/
	private int totalMultiplications(int base, int exp) {
		// Get binary representation of the exponent in an int array
		// int binary[] = getBinaryRepresentation(exp);
		return 0;
	}

	/**
	* Returns binary representation of a decimal number
	*
	* @param  decimal a decimal number
	* @return 		  binary representation as a string
	*/
	private static String getBinaryRepresentation(int decimal) {
		String binary = "";
		
		while (true) {
			binary = binary + Integer.toString(decimal % 2);
			decimal = decimal / 2; 	
			if (decimal == 0) break;
		}

		String result = "";
		for(int i=binary.length()-1; i >= 0; i--) {
			result = result + binary.charAt(i);
		}

		return result;
	}

	public static void main(String args[]) {
		// Print pow(a, b)
		/*
		System.out.println( raiseTo(
				Integer.parseInt(args[0]),
				Integer.parseInt(args[1])
			)
		);
		*/

		System.out.println( 
			getBinaryRepresentation(
				Integer.parseInt(args[0]) 
			)
		);
	}
}
