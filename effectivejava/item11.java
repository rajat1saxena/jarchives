/**
* Overriding clone()
* Even if you implements Cloneable interface and does not write clone() 
* method at all, the class will still compile because Cloneable interface
* modifies the behaviour of protected method clone() of the super class 
* java.lang.Object and does not provide clone() in its contract.
*/
class HashTable implements Cloneable{
	private Entry[] buckets;
	private static final int DEFAULT_SIZE = 16;

	public HashTable(){
		buckets = new Entry[DEFAULT_SIZE];
	}

	public HashTable(int size) {
		buckets = new Entry[size];
	}

	private static class Entry {
		final Object key;
		Object value;
		Entry next;

		Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		// creates a new linked list for the bucket
		Entry deepCopy() {
			return new Entry(key, value, next == null ? null : next.deepCopy());
		}
	}

	@Override public HashTable clone() {
		try {
			HashTable result = (HashTable) super.clone();
			result.buckets = new Entry[buckets.length];
			// notice how we are recursively cloning individual linked lists i.e buckets
			for( int i=0; i<buckets.length; i++) {
				if (buckets[i] != null)
					result.buckets[i] = buckets[i].deepCopy();
			}
			return result;
		} catch(CloneNotSupportedException e) {
			throw new AssertionError(); // can't happen
		}
	}
}