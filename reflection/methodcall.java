package reflection;

/**
* This example looks for test() method in an object of unknow type
*/
import java.lang.reflect.*;

class Person{
	private final String name;
	private final int age;

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public void test(){
		System.out.println(this.name + " is fine");
	}
}

class methodcall{
	public static void main(String args[]) 
		throws NoSuchMethodException,
			IllegalAccessException,
			InvocationTargetException
			{
		Person p = new Person("Rajat",28);

		Method t = p.getClass().getMethod("test");
		t.invoke(p);
	}
}