package designpatterns.behavioral;

/**
* Template Method
*
* This design pattern works on "Don't call us, we'll call you" principle
* Most of the functionality is implemented by the template class and some
* parts of an algorithm implementations are left out (or a default implem-
* entation is provided), which the subclasses can choose to implement.
*/

/**
* Template for Workers.
* Most of the common functionality which is common across all workers are
* provided by this template, but the core performTask() is the one which
* is different for different kinds of workers. So performTask() has to be
* implemented by subclasses for specific implementation.
*/
abstract class Template {
	/**
	* Lets the worker perform his dailyRoutine.
	* We do not want any subclass to override this behavior, that's why 
	* it is marked 'final'.
	*/
	public final void dailyRoutine() {
		wakeUp();
		getDressed(); // Template method, also known as hooks
		goToWork();
		performTask(); // Template method
		comebackToHome();
		relaxThanSleep();
	}

	// Concrete and non-final implementation of non-template methods.
	// This method is not marked final and private so as to check why
	// other private final methods are available in the subclass's 
	// instance.
	void wakeUp() { System.out.println("Worker wakes up"); }

	// Concrete and final implementation of non-template methods.
	private final void goToWork() { System.out.println("Worker comes to work"); }	
	private final void comebackToHome() { 
		System.out.println("Workr comes back"); 
	}
	private final void relaxThanSleep() { 
		System.out.println("Worker goes to bed"); 
	}

	/**
	* Readies the worker by putting on a perfect dress required to perform
	* the job well.
	* Note: No implementation is provided for this method in this template.
	* Note 2: The method is marked 'protected' so that any subclass (even 
	* outside of our package) can use this Template.
	*/
	protected abstract void getDressed();

	/**
	* Lets worker do his/her task.
	*
	* Note: A default implementation is provided but it can be overridden
	* in a subclass with a specific implementation.
	*/
	protected void performTask() {
		System.out.println("Worker performs the task");
	}

	// Driver method
	public static void main(String args[]) {
		// Create a lumberjack
		Template lumberjack = new LumberJack();
		
		// ask him to perform his routine
		lumberjack.dailyRoutine();
	}
} 

/**
* A Lumberjack :: Concrete implementation of the worker Template.
*
* In this specific implementation to some methods are provided, which
* are behaviors specific to lumberjacks.
*/
final class LumberJack extends Template {
	// This method gets called no matter how you create an instance e.g.
	// 1. Template lumberjack = new LumberJack();
	// OR
	// 2. Lumberjack lumberjack = new LumberJack();
	@Override void wakeUp() {
		System.out.println("Lumberjack wakes up");
	}

	@Override protected void getDressed() {
		System.out.println("Worker puts on Lumberjack's dress");
	}

	@Override protected void performTask() {
		System.out.println("Worker cuts the trees");
	}
}


