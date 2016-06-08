/**
* This class demonstrates the bitwise and bit shift operations
* in Java language.
*/
class Bitwise {
	public static void main(String args[]) {
		int i = 8;

		System.out.println("Before shift: " + Integer.toBinaryString(i));
		// The <<< operator will pad 0 to leftmost bit while
		// << operator will leave the leftmost bit intact and
		// same as of origin number i.e. if the number is 
		// negative the result will be negative as well.
		System.out.println("After >>: " + Integer.toBinaryString(i>>1));
		System.out.println("After >>>: " + Integer.toBinaryString(i>>>1));
		System.out.println("After >>: " + Integer.toString(i>>1));
		System.out.println("After >>>: " + Integer.toString(i>>>1));
		
		// In Java 7 we can use '0b' notation to represent number in
		// binary and '0x' to represent number in hex.
		System.out.println("Bitwise AND: " + Integer.toBinaryString(0b1010&0b1111));
		// following operation is also known as inclusive OR
		System.out.println("Bitwise OR: " + Integer.toBinaryString(0b1010_0000|0b1111_1101));
		// following operation is also known as exclusive OR
		System.out.println("Bitwise XOR: " + Integer.toBinaryString(0b1010_0000^0b1111_1101));
	}
}
