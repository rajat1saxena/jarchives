/**
* Person
*/
package ser;

import java.io.Serializable;

final class Person implements Serializable {
	// One should explicitly define serialVersionUID, as it recommended
	// by Java docs. Read more about this, in this SO answer by Jon Skeet
	// http://stackoverflow.com/a/285809/942589
	private static final long serialVersionUID = 42L;

	private String name;
	private Address address;
	private transient int age;
	
	public Person (String name, Address address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	// accessors
	public String getName() { return this.name; }
	public int getAge() { return this.age; }
	public Address getAddress() { return this.address; }

	// no mutator

	@Override public String toString() {
		return this.name + "|" + this.age + "|" + this.address;
	}
}
