/*
* This test some of the things laid out for overriding equals()
*/
class Point{
	private final int x,y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof Point)) return false;
		Point p = (Point) o;
		return p.x==x && p.y==y;
	}
}

enum Color {
	RED,
	BLUE,
	GREEN,
	MAGENTA
}

class Colorpoint extends Point{
	private final Color color;

	public Colorpoint(int x, int y, Color c) {
		super(x,y);
		this.color = c;
	}

	// the following equal() override voilate 'symmetry'
	// hence voilate the equal() contract
	@Override public boolean equals(Object o) {
		if (!(o instanceof Colorpoint)) return false;
		return super.equals(o) && ((Colorpoint) o).color==color;
	}

	// WARNING: this class does not override hashCode() so it
	// will not be usable with HashTable and all such collections.
}

// Following class contains equals(),hashCode() override best practices
class Person{
	int age;
	String name,address;

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override public boolean equals(Object o) {
		// compare to this
		if (o==this) {
			return true;
		}
		// check instance type
		if (!(o instanceof Person)) {
			return false;
		}
		// cast to appropriate class
		Person p = (Person)o;
		// check all significant fields for equality
		return p.name.equals(name) 
				&& p.age==age 
				&& p.address.equals(address);
	}

	// refer effective java item 9 for why the following pattern and 31?
	@Override public int hashCode() {
		int result = 17;
		
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + age;
		result = 31 * result + (address != null ? address.hashCode() : 0);

		return result;
	}

	// always override toString()
	/**
	* Return a brief description of this Person. The exact details of the representation
	* are unspecified and subject to change. [taken from effective java]
	*/
	@Override public String toString() {
		return String.format("%s; %d; %s",name,age,address);
	}
}

class item8_9_10{
	private final static Point p,u,v;
	private final static Colorpoint cu;
	private final static Person pp,pv,pw;

	static{
		u = new Point(5,6);
		p = new Point(5,7);
		v = new Point(5,6);
		cu = new Colorpoint(5,6,Color.RED);
		pp = new Person("Rajat",28,"73 A Mathura");
		pv = new Person("Rajat 2",28,"73 A Mathura");
		pw = new Person("Rajat",28,"73 A Mathura");
	}

	public static void main(String args[]) {
		System.out.println("u/p: "+u.equals(p));
		System.out.println("u/v: "+u.equals(v));
		// the following should result in 'false'
		// but results in true because of equal()
		// is illogical and unacceptable
		System.out.println("u/cu: "+u.equals(cu));
		System.out.println("cu/u: "+cu.equals(u) + " -> Loss of symmetry; Compare with just previous");

		System.out.println("pp/pv: " + pp.equals(pv));
		System.out.println("pp/pw: " + pp.equals(pw));
		System.out.println(pp); // toString method is automatically invoked (page 51)
	}
}