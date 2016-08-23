/**
* Program to demonstrate deadlock in Java.
*
* Note: This program does not guarantee that the deadlock will occur for sure,
* 100% of the time. You could have to run the program several times before you 
* can see a deadlock in action.
*/
import java.util.concurrent.*;

class Deadlock {
	public void method1() {
		synchronized (Integer.class) {
			System.out.println("Locked Integer class");

			synchronized (String.class) {
				System.out.println("Locked String class");
			}
		}
	}
	public void method2() {
		synchronized (String.class) {
			System.out.println("Locked String class");

			synchronized (Integer.class) {
				System.out.println("Locked Integer class");
			}
		}
	}

	public static void main (String args[]) {
		final Deadlock dl = new Deadlock();
		Thread t1 = new Thread(new Runnable(){
					@Override
					public void run() {
						dl.method1();
					}
				}, "Ram");
		Thread t2 = new Thread(new Runnable(){
					@Override
					public void run() {
						dl.method2();
					}
				}, "Shyam");
		Thread t3 = new Thread(new Runnable(){
					@Override
					public void run() {
						dl.method1();
					}
				}, "Shyam");

		// start threads
		// The following commands are not resulting in the deadlock
		// I guess, it's because the threads finish before the next
		// one starts.
		//t1.start();
		//t2.start();
		//t3.start();

		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);

		// shutdown executor
		executor.shutdown();
	}
}
