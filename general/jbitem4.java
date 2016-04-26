/*
* Efficient Java::Item 4
* Private constructors to enforce noninstantiability
*/
public class jbitem4{
	// suppress default constructor for noninstantiability
	private jbitem4(){
		throw new AssertionError("This class should not be instantiated");  // Guarantee to avoid: Just in-case constructor is invoked from within class
	}
	// Also note that the private constructor has side effects:
	// - This class cannot be subclassed as all constructors must invoke a superclass constructor
	//   explicity or implicitly. In this case there would be no accessible superclass constructor.

	public static void main(String args[]){
		jbitem4 jb = new jbitem4();
	}
}