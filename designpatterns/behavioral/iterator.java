package designpatterns.behavioral;

/**
* Iterator Pattern
*/

/**
* Iterator interface to iterate over any datastructure.
*/
interface AnyIterator<T> {
	boolean hasNext();
	T next();
}	

/**
* Simple container to contain any object
*/
interface Container<T> {
	AnyIterator getIterator();
}

/**
* Concrete implementation of StringContainer which provides an iterable
* interface.
*/
class StringContainer implements Container<String> {
	// List of names
	private final String[] names = {
		"Rajat",
		"Neeraj",
		"Vaibhav",
		"Rohit"
	};

	@Override
	public AnyIterator getIterator() {
		return new StringIterator();
	}

	public class StringIterator implements AnyIterator<String> {
		// Counter variable to iterate
		private int index;

		@Override
		public boolean hasNext() {
			if (index >= names.length) {
				return false;
			}
			return true;	
		}

		@Override
		public String next() {
			if (hasNext()) {
				return names[index++];
			}
			return null;
		}
	}
} 

// Client code
class Iterator {
	public static void main(String args[]) {
		Container contain = new StringContainer();

		// iterate over the contents of contain element 
		for(AnyIterator any=contain.getIterator(); any.hasNext(); ) {
			System.out.println(any.next());
		}
	}
}
