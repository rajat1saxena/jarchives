/*
 * Example of how Collections may be implemented
 */
interface Pet{
	void doTheThing();
}

class Dog implements Pet{
	public void doTheThing(){
		System.out.println("Bark!");
	}
}

class Cat implements Pet{
	public void doTheThing(){
		System.out.println("Mew!");
	}
}

class interfaceManyImplementation{
	public static void main(String args[]){
		Pet myPet = new Dog();
		myPet.doTheThing();
	}
}