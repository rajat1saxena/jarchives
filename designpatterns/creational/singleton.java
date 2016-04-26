package creational;

/*
* Efficient Java::Item 3
* 
* This program shows two ways of creation singleton pattern
* While you are at it, also read "Item 3" from Chapter 2, Effective
* Java.
*
* Also about the setAccessible() method in the book, refer:
* http://stackoverflow.com/questions/4081227/singleton-pattern
*/

// Singleton with public final field
class Elvis{
	public static final Elvis INSTANCE = new Elvis();
	private Elvis(){}
	public void pleaseSing(){
		System.out.println("Huh hmmmmm...");
	}
}
// The disadvantage of this method is that it is open to
// AccessibleObject.setAccessible() reflection attacks. Read more online.

// Singleton with private final field
class Wayne{
	private static final Wayne INSTANCE = new Wayne();
	private Wayne(){}
	public static Wayne getInstance() { return INSTANCE; } // notice we are not checking null INSTANCE 
	// and doing any lazy-loading stuff. The INSTANCE is created at the class loading time and 
	// will result in performance gain (read from http://stackoverflow.com/a/4081508/942589)
	public void pleaseRap(){
		System.out.println("Young mula baby!");
	}
}

// Singleton using enum - preffered way
// Available since Java 1.5
enum Darius{
	INSTANCE;

	public void pleaseSingCountry(){
		System.out.println("Without youou...uhu");
	}
}

class singleton{
	public static void main(String args[]){
		Elvis elv = Elvis.INSTANCE;
		elv.pleaseSing();

		Wayne wayn = Wayne.getInstance();
		wayn.pleaseRap();

		Darius.INSTANCE.pleaseSingCountry();
	}
}
