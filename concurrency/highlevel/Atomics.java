/**
* This program demonstrates how to use Atomic Variables in concurrency
* scenarios.
*
* The program creates a counter and uses it using various threads.
*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; // Contains Factory methods
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.TimeUnit;

final class Atomics {
	/**
	* Counter
	* The methods and members of this class are static as it is 
	* a shared class for Printer threads.
	*/
	private static class Counter  {
		private static AtomicInteger c = new AtomicInteger(0);

		/**
		* Increment the counter.
		*/
		public static void incCounter() { c.incrementAndGet(); }

		/**
		* Decrement the counter.
		*/
		public static void decCounter() { c.decrementAndGet(); }

		/**
		* Get counter's value.
		*/
		public static int getCounter() { return c.get(); }	
	}

	/**
	* Printer
	* This class is an instance of Runnable, basically prints thread name
	* and current counter count.
	*/
	private static class Printer implements Runnable {
		@Override public void run() {
			System.out.println("Thread: " + Thread.currentThread()
												.getName() +
									", Value: " + Counter.getCounter());
			// Increment the counter
			Counter.incCounter();
		}
	}

	// Driver program
	public static void main(String args[]) {
		// Create at-least 10000 different instances of Printer job,
		// to be run by ThreadPool, having only 10 worker threads.
		
		ExecutorService executor = Executors.newFixedThreadPool(10);

		// Give work to worker threads
		for (int i=0; i<10000; i++) {
			executor.execute(new Printer());
		}
		// [Java Docs.] Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. Invocation has no additional effect if already shut down.
		executor.shutdown();

		// [Java Docs.] Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
		try {
			executor.awaitTermination(1, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
		}
		System.out.println("All thread finished");
	}
}
