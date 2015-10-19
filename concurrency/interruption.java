/*
* This program demonstrates thread interruptions
*
* This class counts till infinity
*/
class infinity implements Runnable{
  int counter = 0;
  public void run(){
// Approach 1: try catch
    try{
      while(true){
         if(counter>500){
           // this class will throw compilation error here as Thread.sleep is not a valid method here as it does not extend Thread class
            Thread.sleep(1000);
          }
        System.out.println(counter++);
      } 
    }catch(InterruptedException e){
      System.out.println("infinity Interrupted at "+counter);
    }
  }
}

class infinityT extends Thread{
  int counter = 0;
  public void run(){
// Approach 1: try catch
//     try{
//       while(true){
//          if(counter>500){
//            // this class will throw compilation error here as Thread.sleep is not a valid method here as it does not extend Thread class
//             Thread.sleep(1000);
//           }
//         System.out.println(counter++);
//       } 
//     }catch(InterruptedException e){
//       System.out.println("infinity Interrupted: "+counter);
//     }
    
    // Approach 2: Thread.interrupted flag
    while(true){
      if(counter>500){
        counter++; // Thread.sleep throws an Interruped exception so ALWAYS should be surrounded by try-catch
      }
      System.out.println(counter++);
      
      // check for interruptions
      if(Thread.interrupted()){
        System.out.println("Approach 2 interrupted at "+counter);
        return;
      }
    }
  }
}

class interruption{
  public static void main(String args[]){
    Thread t = new Thread(new infinityT());
    
    // start the thread
    t.start();
    
    try{
      // main thread does not seem to interrupt
      Thread.currentThread().interrupt();
      Thread.sleep(100);
    }catch(InterruptedException e){
      System.out.println("Main thread interrupted!");
    }
    
    // wait for t to finish for 100 milliseconds
    t.join(100);
    
    // join after 100 milliseconds
    
  
    // t.interrupt();
  }
}