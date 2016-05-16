/*
* Minimize mutability
*
* This shows best practices to make a mutable class according to the author
*/
import java.util.*;

// Approach #1: Make the class final, so that it can't be subclassed
// Class cannot be extended (Step 1)
final class Complex{
	// final fields (Step 2)
	private final double re;
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	// no setter i.e no mutators (Step 3)

	// getters (Step 4)
	public double realPart() {
		return this.re;
	}

	public double imaginaryPart() {
		return this.im;
	}
}

// Approach #2: Make the class constructor private, and provide static factory
// method to return a new instance.
//
// Here, the user passes a Complex[] array and arrays are mutable so we will convert
// provide an accessor method to get the immutable List comprising of Complex[] elements.
class ComplexSet{
	// All fields are final and private (Step 2, Step 3)
	private final List<Complex> complexList;

	// Private constructor, so class cannot be extended (Step 1)
	private ComplexSet(Complex[] complexSet) {
		// Immutable object as we converted the input array which is mutable
		// (Bloch: Non-zero length array is always mutable)
		//
		// In other words we are making a "defensive copy" of mutable object(Item 39)
		this.complexList = Collections.unmodifiableList(Arrays.asList(complexSet));
	}

	// static factory method, to create new instances (Step 1 - sub part)
	public static ComplexSet valueOf(Complex[] complexSet) {
		return new ComplexSet(complexSet);
	}

	// accessor
	public Complex[] getComplexSet() {
		return this.complexList.toArray(new Complex[this.complexList.size()]);
	}
}

// Non-sense main method, just for the sake of it.
class item15 {
	public static void main(String[] args) {
		Complex c = new Complex(34.56, 45.67);
	}
}
