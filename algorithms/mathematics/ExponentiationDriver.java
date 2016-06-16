/**
* The class provides 'Exponentiation by Squaring' functions.
*
* Read following links:
* https://en.wikipedia.org/wiki/Exponentiation_by_squaring
* https://discuss.codechef.com/questions/20451/a-tutorial-on-fast-modulo-multiplication-exponential-squaring
*/
class Exponentiation {
	/**
	* Produces output by method 1 on Wikipedia.
	* 
	* For large enough result, {@code result%1000000007 } is produced
	* as final result;
	*/
	public static long raiseTo (int base, int exp) {
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
	* the results are inclusive. Additionally, this implementation also
	* assumes that first digit in binaryRepresentation is not zero.
	* Read: http://stackoverflow.com/a/14927639/942589 
	*/
	public static int totalMultiplications(int base, int exp) {
		// Get binary representation of the exponent in an int array
		String binaryRepresentation = getBinaryRepresentation(exp);
		int result = 0;
		// In following statement, variable i starts from 1 as it is 
		// assumed that first digit is always 1 and we are not mult-
		// plying at that stage.
		for (int i=1; i<binaryRepresentation.length(); i++) {
			int value = Integer.parseInt(
							binaryRepresentation.substring(i, i+1)
						);
			if (value==0)
				result += 1; // Squaring
			else 
				result += 2; // Squaring and multiplication
		}
		return result;
	}

	/**
	* Returns binary representation of a decimal number
	*
	* @param  decimal a decimal number
	* @return 		  binary representation as a string
	*/
	public static String getBinaryRepresentation(int decimal) {
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
}

// Driver
class ExponentiationDriver {
	public static void main(String args[]) {
		// Print pow(a, b)
		/*
		System.out.println( Exponentiation.raiseTo(
				Integer.parseInt(args[0]),
				Integer.parseInt(args[1])
			)
		);
		*/

		// Get total number of multiplications
		System.out.println( 
			Exponentiation.totalMultiplications(
				Integer.parseInt(args[0]),
				Integer.parseInt(args[1])
			)
		);
	}
}
