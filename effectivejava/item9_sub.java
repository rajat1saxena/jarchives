/**
* This demonstrates:
* As of release 1.5, it is now legal for an overriding method's return
* type to be a subclass of the overridden method's return type
*/
class Person{
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person getPerson() {
		return this;
	}
}

class IndianPerson extends Person{

	// Pitfall: Always implement constructor in subclass otherwise error:
	// constructor IndianPerson in class IndianPerson cannot be applied to given types;
	// Person p = new IndianPerson("Rajat", 28);
	public IndianPerson(String name, int age) {
		super(name, age);
	}

	// notice here return type here; it is the subclass of Person
	@Override public IndianPerson getPerson() {
		return this;
	}
}

class item9_sub {
	public static void main(String args[]) {
		Person p = new IndianPerson("Rajat", 28);
		System.out.println(p.getPerson());
	}
}