/*
* Demonstration of Telescopic Constructor anti pattern
*
* In this anti pattern, there are too many constructors with
* different signatures. 
*
* Rajat says: This pattern basically acts like a funnel, no matter which
* constructor you call, you will fall through following constructors in the
* sequence and eventually fall through the main constructor having all the
* parameters.
*
* Advantages: 
* 1. It works 
* 2. Thread safety (gotta explore)
* source: http://www.captaindebug.com/2011/05/telescoping-constructor-antipattern.html#.VxC_W1Z948o
*/
class Person{
	private final String name;
	private final int age;
	private final String address;
	private final boolean maritalstatus;

	/* Update Apr, 26: The following constructors do not actually
	 * make up the telescopic constructor pattern, I did not read properly. 
	 * The constructors were random here.
	 * I read from "Effective Java" about this pattern, the new constructors
	 * are truly telescopic.

	public Person(String name) {
		this(name, 0, "", false);
	}

	public Person(String name,int age) {
		this(name, age, "", false);
	}

	public Person(String name,String address) {
		this(name, 0, address, false);
	}

	public Person(int age,String address) {
		this("", age, address, false);
	}

	public Person(boolean maritalstatus){
		this("", 0, "", maritalstatus);
	}
	*/
	public Person(String name){
		this(name,0);
	}
	public Person(String name, int age){
		this(name,age,"<Not specified>"); // notice the default value of address parameter
	}
	public Person(String name, int age, String address){
		this(name,age,address,false);
	}

	// main constructor :; All the above constructors will eventually lead to this one
	public Person(String name, int age, String address, boolean maritalstatus){
		this.name = name;
		this.age = age;
		this.address = address;
		this.maritalstatus = maritalstatus;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public String getAddress(){
		return address;
	}

	public boolean getMaritalstatus(){
		return maritalstatus;
	}
}

public class telescopicconstructor{
	public static void main(String args[]){
		Person person1 = new Person("Rajat");
		System.out.print("Name: " + person1.getName() + "\t");
		System.out.println("Age: " + person1.getAge());
		System.out.println("Address: " + person1.getAddress()+"\n");

		Person person2 = new Person("Shivani",26,"Lal Quila, Agra");
		System.out.print("Name: " + person2.getName() + "\t");
		System.out.println("Age: " + person2.getAge());
		System.out.println("Address: " + person2.getAddress());
	}
}