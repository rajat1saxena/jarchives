/*
* Demonstration of Telescopic Constructor anti pattern
*
* In this anti pattern, there are too many constructors with
* different signatures.
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

	// main constructor
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

		Person person2 = new Person("Shivani",26);
		System.out.print("Name: " + person2.getName() + "\t");
		System.out.println("Age: " + person2.getAge());
	}
}