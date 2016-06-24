/**
* Observer design pattern
*/
package designpatterns.behavioral;

import java.util.Set;
import java.util.HashSet;

interface ObserverInterface {
	void notifyMe();
}

// Concreate implementations of ObserverInterface
final class Gate implements ObserverInterface {
	private final String name;

	public Gate(String name) { this.name = name; }

	@Override public void notifyMe() {
		System.out.println(this.name + " closed");
	}
}

final class Bulb implements ObserverInterface {
	private final String name;

	public Bulb(String name) { this.name = name; }

	@Override public void notifyMe() {
		System.out.println(this.name + " switched off");
	}
}

/**
* Controller for all home electrical equipments.
*/
final class HomeController{
	// Container for all of the home equipments
	private Set<ObserverInterface> equipments;
	
	public HomeController() {
		equipments = new HashSet<ObserverInterface>();
	}

	/**
	* Register a new observer.
	*
	* @param observer observer
	*/
	public void register(ObserverInterface observer) {
		this.equipments.add(observer);	
	}

	/**
	* Un-register a new observer.
	*
	* @param observer observer
	*/
	public void unregister(ObserverInterface observer) {
		this.equipments.remove(observer);	
	}

	/**
	* Signal all of the home equipments in case of a breach.
	*/
	public void isBreached() {
		System.out.println("Home security breadched!\n");
		// Iterate over the collection of equipments
		for(ObserverInterface ob : equipments) {
			ob.notifyMe();
		}
	}
}

public class Observer {
	public static void main(String args[]) {
		HomeController myHomeController = new HomeController();

		// add electrical equipments
		myHomeController.register(new Bulb("Door bulb"));
		myHomeController.register(new Bulb("Toilet bulb"));
		myHomeController.register(new Bulb("Bedroom 1 bulb"));
		myHomeController.register(new Gate("Front gate"));
		
		// notify that the home security is breached
		myHomeController.isBreached();
	}
}
