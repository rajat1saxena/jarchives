/**
* Implements Comparable interface
* Re-creation of an example on:
* https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
*/
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Name implements Comparable<Name>{
  private final String lastName, firstName; //immutable so as to prevent collections using
  // them from breaking

  public String lastName() {
    return this.lastName;
  }

  public String firstName() {
    return this.firstName;
  }

  public Name(String lastName, String firstName) {
    if (lastName==null || firstName==null) {
      throw new NullPointerException();
    }
    this.lastName = lastName;
    this.firstName = firstName;
  }

  /* overriding equals :: ensure that hashCode() is overridden otherwise we will
  * end up with broken code. Read here:
  * http://eclipsesource.com/blogs/2012/09/04/the-3-things-you-should-know-about-hashcode/
  */
  public boolean equals(Object o) {
    if (!(o instanceof Name)) {
      return false;
    }
    Name n = (Name) o;
    return n.firstName.equals(firstName) && n.lastName.equals(lastName);
  }

  public int hashCode() {
    return 32*firstName.hashCode() + lastName.hashCode();
  }


  // overriding toString object method
  public String toString() {
    return lastName + " " + firstName;
  }

  public int compareTo(Name n){
    int lastCmp = lastName.compareTo(n.lastName);
    return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
  }


  public static void main(String args[]) {
//      Set<Name> names = new HashSet<Name>();
//      names.add(new Name("Saxena","Rajat"));
//      names.add(new Name("Saxena 2","Rajat"));
//      names.add(new Name("Saxena 3","Rajat"));
//      names.add(new Name("Saxena 4","Rajat"));
//      names.add(new Name("Saxena 0","Rajat"));

     Name names[] = {
       new Name("Saxena","Rajat"),
       new Name("Saxena 2","Rajat"),
       new Name("Saxena 4","Rajat"),
       new Name("Saxena 3","Rajat"),
       new Name("Saxena 0","Rajat")
     };

     System.out.println(names);

     // sort using name object's built in comparator
     // using collection's built-in method for set -
     // to array conversion
     // namesArray.addAll(names);
     //List<Name> namesArray = new ArrayList<Name>();
     List<Name> namesArray = Arrays.asList(names);

     Collections.sort(namesArray);

     System.out.println(namesArray);
  }
}