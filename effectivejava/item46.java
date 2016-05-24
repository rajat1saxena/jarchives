/**
* Representative of Item 46: Prefer for-each loops
* to traditional for loops.
*/
import java.util.*;

final class Item46{
	// TODO implement Iterable<E> on this class
	//
	// The class is marked 'static' as it does not
	// require access to enclosing instance and
	// the class is inner as Item46 is its only
	// consumer. Refer to Item 22 of Effective
	// Java.
	private final static class Person {
		private final String name;

		Person(String name) {
			this.name = name;
		}

		// accessor
		String getName() {
			return this.name;
		}

		// mutator not required
	}

	// Why are these defined here and not at the start?
	// Refer Item 45 of Effective Java.
	enum Car { LAMBORGHINI, FERRARI, SUBRU, HONDA, BUGGATI };
	enum Color { RED, GREEN, YELLOW, BLUE }

	public static void main(String args[]) {
		// Let's print all combinations for cars and colors
		System.out.println("Available Cars");
		Collection<Car> cars = Arrays.asList(Car.values());
		Collection<Color> colors = Arrays.asList(Color.values());
		for (Car c: cars) {
			for (Color co: colors) {
				System.out.println(co + " " + c);
			}
		}
	}
}
