/**
* Square root calculator. Calculates {@code floor(sqrt(x)) }.
*/
public final class Squareroot {
	public static void main(String args[]) {
		int number = Integer.parseInt(args[0]);
		
		int max = number;
		int min = 0;
		int mid = (max+min)/2;

		// Base cases
		if (number == 0 || number==1) {
			System.out.println(Integer.toString(number));
		}
		
		while (min <= max) {
			if (mid*mid == number) {
				break;
			}
			if (mid*mid > number) {
				max = mid;// - 1;
			}
			if (mid*mid < number) {
				min = mid;// + 1;
			}
			// Calculate mid
			mid = (max+min)/2;
		}

		// Print the result
		System.out.println(Integer.toString(mid));
	}
}
