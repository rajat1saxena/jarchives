// List
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.ListIterator;

class shuffle{
  
  
	public static void main(String args[]){
		List<String> names = new ArrayList<String>();
    names.add("Rajat");
    names.add("Neeraj");
    names.add("Vaibhav");
    names.add("Rohit");
    names.add("Davinder");
    names.add("Bhatia");
    names.add("Saxena");
    
    //Collections.shuffle(names);
    
    for(String name:names)
      System.out.println(name);
    
    Collections.shuffle(names);
    
    System.out.println("---------------");
    // get iterator
    for(ListIterator<String> it = names.subList(2,4).listIterator();it.hasNext();)
      System.out.println(it.nextIndex()+": "+it.next());
    System.out.println("---------------");
    
    names.subList(0,5).clear();
    for(String name:names)
      System.out.println(name);
	}
}