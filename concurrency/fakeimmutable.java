/**
* This demonstrates the fake immutable class i.e a class that appears to be immutable but the individual items can still be mutated. hence the class is not immutable
*
* Read official doc here: https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
* - Point 4: 2nd sub point.
*
* Stack overflow link: https://stackoverflow.com/questions/3142817/java-immutable-class-rules
*/

// not an immutable class, but appears to be. Array a's elements can be manipulated
final class mutt{
  private final int[] a;
  public mutt(int[] a){
    this.a = a;
  }
}

class fakeimmutable{
  public static void main(String args[]){
    int[] v1 = new int[5];
    mutt m = new mutt(v1);
    
    v1[2] = 45; // here we are trying to change the value of one of the elements of an array(supposed to be immutable)
    
    System.out.format("Value of v1[2]: %d%n",v1[2]);
  }
}

