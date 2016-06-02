/**
* Representative of Item 60: Favor the use of standard exceptions.
*
* Here we are going to implement a custom list and throw Unsupported-
* OperationException (standard exception) wherever required.
*
* Note: This program produces UnsupportedOperationException as an
* expected result.
*/
import java.util.*;
import java.lang.UnsupportedOperationException;

class Item60 {
		/**
		* A custom implementation of the List interface to throw various
		* exceptions.
		*
		* It's a wrapper class and follows composition pattern. Whatever
		* method of List interface we didn't want to use, we have thrown
		* UnSupportedOperationException for that.
		*
		*/
		private static class ExceptionalList<T> implements List<T> 
		{
		List<T> source; // composition pattern

		public ExceptionalList() {
			source = new ArrayList<T>();
		}

		@Override public boolean add(T t) { 
			return source.add(t); 
		}
		@Override public void add(int index, T element) {
			source.add(index, element);
		}
		@Override public boolean addAll(Collection<? extends T> t) {
			throw new UnsupportedOperationException();
		}
		@Override public boolean addAll(int index, Collection<? extends T> t) {
			throw new UnsupportedOperationException();
		}
		@Override public void clear() { source.clear(); }
		@Override public boolean contains(Object o) { 
			return source.contains(o);
		}
		@Override public boolean containsAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override public boolean equals(Object o) { return source.equals(o); }
		@Override public T get(int index) { return source.get(index); }
		@Override public int hashCode() { return source.hashCode(); }
		@Override public int indexOf(Object o) { return source.indexOf(o); }
		@Override public boolean isEmpty() { return source.isEmpty(); }
		@Override public Iterator<T> iterator() { return source.iterator(); }
		@Override public int lastIndexOf(Object o) { 
			return source.lastIndexOf(o);
		}
		@Override public ListIterator<T> listIterator() {
			return source.listIterator();
		}
		@Override public ListIterator<T> listIterator(int index) {
			return source.listIterator(index);
		}
		@Override public T remove(int index) 
			throws UnsupportedOperationException { 
			throw new UnsupportedOperationException();
		}
		@Override public boolean remove(Object o) 
			throws UnsupportedOperationException { 
			throw new UnsupportedOperationException();
		}
		@Override public boolean removeAll(Collection<?> c) { 
			throw new UnsupportedOperationException();
		}
		@Override public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override public T set(int index, T element) { 
			return source.set(index, element);
		}
		@Override public int size() { return source.size(); }
		@Override public List<T> subList(int fromIndex, int toIndex) {
			return source.subList(fromIndex, toIndex);
		}
		@Override public Object[] toArray() {
			return source.toArray();
		}
		@Override public <T> T[] toArray(T[] a) { return source.toArray(a); }
		}

	public static void main(String args[]) {
		List<String> list = new ExceptionalList<String>();	
		list.add("Rajat");
		System.out.println(list.get(0));

		// This will produce UnsupportedOperationException
		list.remove("Rajat");
	}
}

