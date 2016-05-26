/**
* Representative of Item 50: Avoid strings where other
* types are more appropriate.
*/
import java.util.*;

class Item50 {
	/**
	* This represents a person. 
	*
	* This class is immutable.
	*/
	private final static class Person {
		private final String name;
		private final int age;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}	
		
		// accessor
		public String getName() {
			return this.name;
		}
		public int getAge() {
			return this.age;
		}

		// no mutators allowed
		
		@Override public String toString() {
			return "Person <" + this.name + ", " + this.age + ">";
		}
	}

	/**
	* Mapping of Person to a string key.
	* 
	* The problem with this class is that it uses string
	* as the key and if two Persons uses same key to store
	* their data in this map then it will be a problem.
	*/
	private static class PersonMapper {
		private static Map<String, Person> personmap = new HashMap<String, Person>();
		// Non-instantiable
		private PersonMapper(){}

		public static void set(String key, Person p) {
			personmap.put(key, p);	
		}

		public static Person get(String key) {
			return personmap.get(key);
		}
	}

	public static void main(String args[]) {
		String key = "key1";
		// All good for following two statements
		PersonMapper.set(key, new Person("Rajat", 28));
		System.out.println(PersonMapper.get(key));
		// Following assignment will result in collision
		// due to same key but different objects are being
		// stored. 'key1' does not point to 'Rajat' anymore.
		PersonMapper.set(key, new Person("Neeraj", 27));
		System.out.println(PersonMapper.get(key));
	}

	// Solution
	// We can use unforgeable key i.e Objects as keys in 
	// place of Strings. The class is marked 'abstract'
	// as no implementation is provided as of now.
	// TODO: Implement the solution based on following class.
	private abstract static class LocalKey<T> {
		public LocalKey() {}
		public abstract void set(T value);
		public abstract T get();	
	}
}
