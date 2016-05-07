/**
* Implementation of Stack
* Inspired from Effective Java
*/
import java.util.Arrays;
import java.util.EmptyStackException;

class Stack{
	private final static int DEFAULT_CAPACITY = 16;
	private Object[] elements;
	private int size = 0;

	public Stack(){
		this.elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(Object e){
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop(){
		if ( size == 0 ) throw new EmptyStackException();
		Object returnable = elements[--size];
		elements[size]=null; // marking memory to be re-claimed by GC
		return returnable;
	}

	public void ensureCapacity() {
		if( elements.length == size ) {
			elements = Arrays.copyOf(elements, 2*size + 1);
		}
	}
}


class stack{
	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(new Object());
		try{
			System.out.println(s.pop());
		} catch(EmptyStackException e) {
			e.printStackTrace();
		}
	}
}