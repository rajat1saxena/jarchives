/**
* This program demonstrates the use of 'wait'
*
* One thread waits for another thread to set a flag, when set it will act accordingly
*/
class waiter{
  public boolean flag = false;
  
  // Keeps on executing while flag is false;
  public synchronized void notFlagged(){
    while(!flag){
      try{
        wait();
      }catch(InterruptedException e){
        System.out.println("Interrupted :"+Thread.currentThread().getId());
      }
    }
    // print upon exit of while loop i.e. notification
    System.out.println("Notified: "+Thread.currentThread().getId());
  }
  
  public synchronized void setFlag(){ 
    this.flag = true;
    notifyAll(); // taking out the 'synchronized' keyword from this method will result in this error 'java.lang.IllegalMonitorStateException' at this line
  }
  
  // this method only set flag and does not notify, let's see what happens
  public void setFlag2(){
    this.flag = true;
  }
}
class waited implements Runnable{
  static waiter w;
  
  public waited(waiter w){
    this.w = w;
  }
  
  public void run(){
    // start notFlagged
    this.w.notFlagged();
  }
  
  public static void main(String args[]){
    // create a new instance of waiter
    w = new waiter();
    
    Thread t = new Thread(new waited(w));
    Thread s = new Thread(new waited(w));
    
    t.start();
    s.start();
    
    // let main sleep for some time
    try{
      Thread.sleep(3000);
    }catch(InterruptedException e){
      System.out.println("Interrupted main\n");
    }
    
    // set flag
    w.setFlag();
//     w.setFlag2(); // using this will let the program wait forever
  }
}