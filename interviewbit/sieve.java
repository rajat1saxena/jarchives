import java.util.ArrayList;

public class sieve {
	public static ArrayList<Integer> sieve(int a) {
    
    ArrayList<Integer> output;
      
    // allocate an array
    boolean[] primes = new boolean[a+1];
    for(int i=0;i<=a;i++){
      // mark false
      primes[i] = true;
    }
    
    // sieve of erathosthenes
    int sqrta = (int)Math.sqrt(a);
    for(int i=2;i<=sqrta;i++){
      if(primes[i]){        
        // iterate like i^2,i^2+i,i^2+2i...
        int val = (int)Math.pow(i,2);
        int counter = 0;
        while(val+counter*i <= a){
          int j = val+counter*i;
          primes[j] = false;
          counter++;
        }
      }
    }
    
    output = new ArrayList<Integer>();
    
    for(int i=2;i<=a;i++){
      if(primes[i]){
        output.add(i);
      }
    }
    
    return output;
	}
  
  public static void main(String args[]){
    ArrayList<Integer> output = sieve(30);
    for(int i=0;i<output.size();i++){
      System.out.println(output.get(i)+"");
    }
  }
}