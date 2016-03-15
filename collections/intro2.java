/**
* Mar 2016 - Collection revist
*
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class intro2{
  public static void main(String args[]) {
    Collection<String> c = new ArrayList<String>();
    for (String a:args) {
      c.add(a);
    }

    // Conversion constructor: https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
    List<String> list = new ArrayList<String>(c); // this will create a new collection named 'list', no reference passing
    List<String> list2 = list;

    // Print the list elements using 'for'
    for (Object obj:list) {
      System.out.print(obj+"\t");
    }

    // Iterator for collection :; Also note that the following code is polymorphic
    // and can be used for any kind of collection
    for (Iterator<?> it = list2.iterator(); it.hasNext();) {
      // move to next
      it.next();
      it.remove();
    }

    // Print the list elements using 'for', so as to ensure list is empty
    System.out.println("List: ");
    for (Object obj:list) {
      System.out.print(obj+"\t");
    }

    // Print the list elements using 'for', so as to ensure list is empty
    System.out.println("List2: ");
    for (Object obj:list2) {
      System.out.print(obj+"\t");
    }

    // Print the collection elements using 'for'
    System.out.println("Collection: ");
    for (Object obj:c) {
      System.out.print(obj+"\t");
    }
    System.out.println("");

    // Checking bulk-operations true/false returning
    if (c.removeAll(Collections.singleton("all"))) {
      System.out.println("Remove successfull");
    } else {
      System.out.println("Does not exist");
    }
    // this attempt should fail
    if (c.removeAll(Collections.singleton("all"))) {
      System.out.println("Remove successfull");
    } else {
      System.out.println("Does not exist");
    }

    /* Map */
    Map<String, Integer> m = new HashMap<String, Integer>();
    for (String a:args) {
      Integer freq = m.get(a);
      m.put(a, (freq==null) ? 1 : freq+1);
    }
    System.out.println(m);

    // To create another map with same key,value pairs
    Map<String, Integer> copy = new HashMap<String, Integer>(m);
    System.out.println(copy);

    // Iterate over keySet,iterating over values is analogous
    for (String s:m.keySet()) {
      System.out.print(s);
    }
    // using iterator to iterate in keysets
    for (Iterator<?> it = m.keySet().iterator(); it.hasNext();) {
      System.out.print(it.next());
    }
    // iterating over entry
    for (Map.Entry<String, Integer> e: m.entrySet()) {
      System.out.print(e.getKey()+":"+e.getValue());
    }

    // checking validity of args
    // setting required params
    Set<String> req = new HashSet<String>();
    req.add("hola");
    req.add("man");
    // setting allowd params
    Set<String> allowed = new HashSet<String>();
    allowed.add("hola");
    allowed.add("man");
    allowed.add("eq");
    allowed.add("cash");
    if (checkParamsValidity(m,req,allowed)) {
      System.out.println("\nCheck passed");
    } else {
      System.out.println("\nCheck failed");
    }
  }

  /**
   * checks validity of params and returns true/false
  */
  public static boolean checkParamsValidity(Map<String,Integer> attr, Set<String> requiredParams, Set<String> allowedParams) {
    Set<String> params = attr.keySet();
    boolean result = true;

    // check if all the requiredParams are there is the request
    if (!params.containsAll(requiredParams)) {
      // find missing params
      Set<String> missing = new HashSet<String>(requiredParams);
      missing.removeAll(params);
      System.out.println("missing: " + missing);
      result = false;
    }

    return result;
  }
}