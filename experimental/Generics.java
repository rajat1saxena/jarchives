/**
* This program is demonstrate how to create instances of any class
* using reflection, Generics and .class as method argument
*/
final class Generics<T> {
	private Class<T> t;

	public Generics(Class<T> t) {
		this.t = t;
	}

	/**
	* Returns t
	* 
	* @return new instance of class T
	*/
	public T getInstance() 
	throws InstantiationException, IllegalAccessException
	{ return t.newInstance(); }

	/**
	* Type to spawn an object of.
	*/
	private static class MyObj {
		public int a;
		
		public MyObj(int a) { this.a = a; }
	}

	public static void main(String args[]) {
		Generics<MyObj> generic = new Generics<MyObj>(MyObj.class);
		System.out.println(generic.getClass());
	}
}
