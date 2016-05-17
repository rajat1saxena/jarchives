/**
* Item 39: Make defensive copies when needed
*
* Note #1: Defensive copies can have a performance penalty associated
* with it and isn't always justified. Read page 187 para 4
* Note #2: This example is also available in experiments folder
*/

final class Mutab{
	private int A;
	private int B;
	
	public Mutab(int A, int B) {
		this.A = A;
		this.B = B;
	}
	
	// accessor
	public int getA(){
		return A;
	}
	public int getB(){
		return B;
	}

	// mutators
	public void setA(int A) {
		this.A = A;
	}
	public void setB(int B) {
		this.B = B;
	}
}

// A immutable class with a Mutab(mutable) member field
final class Immut{
	private final Mutab m; // Non-exclusive access to mutable component
	// the above member field violates Step 5 for immutable classes acc. to JBloch
	// Read Item 15 for more.
	private final int id;

	public Immut(Mutab m, int id) {
		this.m = m;
		this.id = id;
	}

	// accessors
	public Mutab getM() {
		return this.m;
	}
	public int getId() {
		return this.id;
	}

	// no mutators allowed for immutable class
}

/**
* The following class is truly immutable. It follows two key rules to
* ensure exclusive access to any mutable components
* 
* - Defensive copy of mutable internal fields while creating instances
* - Return defensive copies of mutable internal fields
*/
final class Immut2{
	private final Mutab m; // Non-exclusive access to mutable component
	// the above member field violates Step 5 for immutable classes acc. to JBloch
	// Read Item 15 for more.
	private final int id;

	public Immut2(Mutab m, int id) {
		this.m = new Mutab(m.getA(), m.getB()); // Defensive copy
		this.id = id;
	}

	// accessors
	public Mutab getM() {
		return new Mutab(this.m.getA(), this.m.getB());
	}
	public int getId() {
		return this.id;
	}

	// no mutators allowed for immutable class
}
	
class mutablepass{
	public static void main(String args[]) {
		// Use Immut2, if true immutability is required
		Immut im = new Immut(new Mutab(2, 4), 0);		
		System.out.println(im.getM().getA());
		// as the Immut class contains a mutable member field 
		// we can change it's internals. Hence Immut class is
		// not really immutable. If in-case im is an instance
		// of Immut2, the following statement will change the 
		// field of new Mutab() returned by getM() of Immut2
		// so it does not effect the real Mutab member field
		// of Immut2 and you will get same answers for both
		// println commands
		im.getM().setA(56);
		System.out.println(im.getM().getA());
	}
}
