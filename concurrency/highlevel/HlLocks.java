/**
* This program demonstrates how to use Locks in java.
*
* This program simulates a printer queue, where we will queue, printing
* jobs and the job will be printed one-after-other.
*/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class HlLocks {
	/**
	* Printing Job
	*
	* This class is the printing job which will be executed 
	* by printingqueue.
	*/
	private static class PrintingJob implements Runnable {
		private PrintingQueue mPrintQueue;

		public PrintingJob(PrintingQueue printQueue) {
			this.mPrintQueue = printQueue;
		}	

		@Override public void run() {
			System.out.println("Submitted: " + Thread.currentThread().getName());
			mPrintQueue.printJob(new Object());
		}
	}	

	/**
	* Printing Queue [Shared resource]
	*
	* This is the printing queue, which ultimately prints the jobs.
	* Here we are using lock because there will be multiple threads trying
	* to get their jobs printed simultaneously, but PrintingQueue, being
	* a shared resource, needs to be synchronized.
	*/
	private static class PrintingQueue {
		private final Lock mLock = new ReentrantLock();

		/**
		* Prints the job.
		*/
		public void printJob(Object document) {
			mLock.lock();
			try {
				System.out.println("Printing: " + Thread.currentThread()
							.getName() + "; " + document.toString()); 
			} finally {
				mLock.unlock();	
			}
		}
	}

	// Driver program
	public static void main(String args[]) {
		PrintingQueue mPrintQueue = new PrintingQueue();

		// Initialized and start 10 threads 
		for (int i=0; i<10; i++) {
			new Thread(new PrintingJob(mPrintQueue),
										Integer.toString(i))
						.start();
		}
	}
}
