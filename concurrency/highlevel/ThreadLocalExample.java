/**
* A blueprint for an object which provides transaction ID, unique to each
* thread.
*/
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ThreadLocalExample {
	// Atomic integer containing the next transaction ID for next thread
	private static final AtomicInteger nextTransactionID = new AtomicInteger
(0);

	// Thread local variable containing each thread's transaction ID
	// It is initialized once for each thread, so this will stay unique for
	// every new thread
	private static final ThreadLocal<Integer> threadTransactionID = 
		new ThreadLocal<Integer>() {
			@Override protected Integer initialValue() {
				return nextTransactionID.getAndIncrement();
			}
		};

	// Return current thread's unique transaction ID
	public static int get() {
		return threadTransactionID.get();
	}

	public static void main (String args[]) {
		// As the following variable is accessed from inner class, later,
		// this is marked as 'final'
		final ThreadLocalExample threadLocal = new ThreadLocalExample();

		// Get an executorservice instance to run new threads
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		// Run 5 new threads
		for(int i=0; i<5; i++) {
			executor.submit(
				// Each threads prints it's transaction id, which is
				// supposed to be unique
				new Runnable() {
					@Override public void run() {
						System.out.println(
							// Thread-local's initialValue() is called
							// when get() is called, so the initial value
							// i.e (unique transaction id)
							// for each transaction is set at this step.
							threadLocal.get()
						);
					}
				}
			);			
		}

		// Disable new tasks from being submitted
		executor.shutdown();

		try {
			if (!executor.awaitTermination(60, TimeUnit.NANOSECONDS)) {
				executor.shutdownNow(); // Cancel currently executing tasks
			} 
		} catch (InterruptedException e) {
			executor.shutdownNow(); // Cancel currently executing tasks
		}
	}
}
