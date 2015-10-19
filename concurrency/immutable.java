/**
This class demonstrates how to create an immutable object
*/

/*
We can create immutable objects by following rules:
1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
2. Make all fields final and private.
3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
    - Don't provide methods that modify the mutable objects.
    - Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning 
*/

final class immut{
  private final int propA = 10;
  public immut(){} // either make class final or constructor private to make this immutable 
  
  // no setter for propA
  
  // contains no method which modifies mutable objects
  
  // getter
  public int getpropA(){
    return this.propA;
  }
}

class immutable{
  public static void main(String args[]){
    immut m = new immut();
    
    System.out.println("propA value: "+m.getpropA());
  }
}