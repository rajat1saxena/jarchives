package item62;

/**
* Representative of Item 62: Document all exceptions thrown by
* each method.
*/
public final class Item62 {
	public static void main(String args[]) {
		// Let's use isEqual, it won't throw NPE if arg2 is null.
		Api api = new Api();
		api.isEqual("Rajat", null);		
		// Following will produce NPE due to invocation of equals()
		// on null value.
		api.isEqual(null, "Rajat");
	}
}
