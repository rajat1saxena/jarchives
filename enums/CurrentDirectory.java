/**
* The enum used in an Android app for storing the "current directory"
* variable accross multiple activities.
*
* This pattern can be used in places where we need global variables
* and can avoid subclassing {@literal Application} in its entirety.
*/
enum Path {
	NAME("/");

	// Internal property to hold the current directory path
	private String path;

	Path(String path) { this.path = path; }

	@Override public String toString() { return this.path; }

	/**
	* Sets path property to the given string.
	*/
	void setPath (String path) {
		this.path = path;
	}
}

// Driver program
// --------------
// Threads are used to check the behavior of enum in context of Threads.
// Like do we actually get same result if the enum is getting used accross
// multiple threads. The result in positive.
public class CurrentDirectory {
	public static void main(String args[]) {
		System.out.println(Path.NAME);
		Thread T1 = new Thread(new Runnable() {
			@Override public void run() {
				System.out.println("Before T1: " + Path.NAME);
				// Set the new path
				Path.NAME.setPath("/lol/img.jpg");
			}
		});
		Thread T2 = new Thread(new Runnable() {
			@Override public void run() {
				System.out.println("Before T2: " + Path.NAME);
				// Set the new path
				Path.NAME.setPath("/haha/monster.jpg");
			}
		});

		// Start both threads;
		T2.start(); 
		T1.start();

		// Print final path
		System.out.println(Path.NAME);

		//Path.NAME.setPath("/ignorant/joker.png");
		//System.out.println(Path.NAME);
	}
}
