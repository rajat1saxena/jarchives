/**
* Work in progress
* ----------------
* This example uses Iterable<T> interface.
*/
class Person<E> implements Iterable<E> {
	public Iterator<E> iterator() {
		return new PersonIterator<E>();
	}
}
class PersonIterator<T> implements Iterator<T> {
	@Override public boolean hasNext() {
		System.out.println("Has next");
	}
	@Override public T next() {
		System.out.println("Next");
	}
}
