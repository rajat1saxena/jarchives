/**
* Representative of Item 66: Synchronize access to shared mutable data
*
*/
final class Item66 {
	// Member to be used a flag to indicate stop request
	private static boolean stopRequested;

	// Member to be used for the same purpose but offers synchronized access
	// Additionally, you can mark this member 'volatile' which will force each thread
	// to read it's updated variable, every single time.
	private static boolean stopRequestedSynced;

	/**
	* Sets stopRequestedSynced
	*/
	private synchronized static void setStopRequestedSynced() {
		stopRequestedSynced = true;
	}

	/**
	* Returns stopRequestedSynced
	*/
	private synchronized static boolean getStopRequestedSynced() {
		return stopRequestedSynced;
	}

	public static void main (String args[]) throws InterruptedException {
		// Create a new thread
		Thread newThread = new Thread (new Runnable(){
			@Override public void run () {
				int i = 0;
				// Without synchronization, there is no guarantee that
				// this background thread will ever see the updated value
				// of stopRequested.

				// Uncomment the following line to see effects of non-synchronized
				// flag 'stopRequested'.
				// while (!stopRequested) {
				while (!getStopRequestedSynced()) {
					System.out.println("Running " + i++);
				}
			}
		});

		// start the thread
		newThread.start();

		Thread.sleep(1);
		
		// request the thread to stop
		// stopRequested = true;
		setStopRequestedSynced();
	}
}

