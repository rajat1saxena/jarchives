/*
* This class shows that how abstract classes can be used to 
* provide the contract which does something and subclasses of 
* this abstract class can enforce additional properties i.e full
* adds more methods on top of what provided by basic class.
*/
abstract class basic{
	abstract int add(int i, int j);
	abstract int minus(int i,int j);
}

abstract class full extends basic{
	abstract int multiply(int i, int j);
	abstract int divide(int i, int j);
}

class abstracty extends full{
	int add(int i, int j){
		return i+j;
	}

	int minus(int i, int j){
		return i-j;
	}

	int multiply(int i, int j){
		return i*j;
	}

	int divide(int i, int j){
		return i/j;
	}

	public static void main(String args[]){
		int i,j;
		i = 6;
		j = 3;
		abstracty a = new abstracty();

		System.out.println("Sum: "+a.add(i,j));
	}
}