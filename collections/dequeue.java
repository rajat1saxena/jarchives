import java.util.*;

class dequeue{
  public static void main(String args[]){
    Deque<String> que = new LinkedList<String>();
    que.addFirst("Rajat");
    que.addLast("Saxena");
    que.offerLast("Fyi");
    que.addLast("Rohit");
    que.offerFirst("Neeraj");
    
    // remove first occurence (deque method)
    // que.removeFirstOccurence("Saxena"); //not working
    
    while(!que.isEmpty()){
      System.out.println(que.remove());
    }
    
  }
}