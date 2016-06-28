/**
* This program is demonstrate how to create instance of any class
* using reflection and .class as method argument
*/
final class Generics<T> {
	private T t;

	public Generics(T t) throws IllegalStateException{
		this.t = t.newInstance();
	}

	/**
	* Returns t
	* 
	* @return field variable
	*/
	public T getInstance() { return t; }

	/**
	* Type to spawn an object of.
	*/
	private static class MyObj {
		public int a;
		
		public MyObj(int a) { this.a = a; }
	}

	public static void main(String args[]) {
		Generics<MyObj> generic = new Generics<MyObj>(MyObj.class);
		
	}
}
