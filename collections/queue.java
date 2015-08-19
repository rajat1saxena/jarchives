import java.util.*;

class queue{
  public static void main(String args[]){
    Queue<String> que = new LinkedList<String>();
    que.add("Rajat");
    que.add("Saxena");
    que.offer("Fyi");
    que.add("Rohit");
    que.offer("Neeraj");
    
    while(!que.isEmpty()){
      System.out.println(que.remove());
    }
    
  }
}