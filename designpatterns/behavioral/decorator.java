/**
* Decorator Pattern
*
* We will make a standard coffee first and then add
* several toppings and blendings to it. 
*/

interface Coffee {
	String getName();
	String getDescription();
}

// Concrete implementation of Coffee interface
final class StandardCoffee implements Coffee {
	@Override public String getName() {
		return "Coffee";
	}			

	@Override public String getDescription() {
		return "Standard coffee";
	}
}

// We want to add some toppings to this coffee.
// hence we create an abstract helper class which
// let's us add various toppings.
// Please note that this is just a helper class and
// is not a must to create decorator pattern. Read
// the related question of StackOverflow for more 
// information regarding this.
abstract class CoffeeAddition implements Coffee {
	protected Coffee coffee;

	CoffeeAddition(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override public String getName () {
		return coffee.getName(); // delegation
	}
	@Override public String getDescription () {
		return coffee.getDescription(); // delegation
	}
}

// Concrete implementation of CoffeeAddition
class NutellaCoffee extends CoffeeAddition {
	public NutellaCoffee(Coffee coffee) {
		super(coffee);	
	}

	// Notice we did not override getName() as CoffeeAddition
	// abstract class has enabled us to selectively implement 
	// only desired behaviors in concrete classes. If we were
	// to create a concrete class out of the Coffee interface
	// we would have to implement getName().
	@Override public String getDescription() {
		// decoration done
		prepareForBlend();
		return super.getDescription() + " Nutella";
	}
	
	private void prepareForBlend() {
		System.out.println("Preparing to blend Nutella...");
	}
}
// Concrete implementation of CoffeeAddition
class ChocolateCoffee extends CoffeeAddition {
	public ChocolateCoffee(Coffee coffee) {
		super(coffee);	
	}

	// notice we did not override getName as CoffeeAddtion
	// has enabled us to selectively implement only desired
	// behaviors in concrete classes
	@Override public String getDescription() {
		// decoration done
		addChocolate();
		return super.getDescription() + " Chocolate";
	}
	
	private void addChocolate() {
		System.out.println("Chocolate added...");
	}
}

class decorator{
	public static void main(String args[]) {
		Coffee coffee = new NutellaCoffee(
								new ChocolateCoffee(
									new StandardCoffee()
								)
							);
		System.out.println(coffee.getName());
		System.out.println(coffee.getDescription());
	}
}
