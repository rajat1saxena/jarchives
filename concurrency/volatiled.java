/**
* This program demonstrates the use of volatile keyword.
*
* Threads might cache variables if not marked volatile. Hence, cannot see changes
*/
class volatiled implements Runnable{
  private boolean isRunning;
  private int counter = 0;
  
  public void setisRunning(boolean value){
    this.isRunning = value;
  }
  
  public void run(){
    while(this.isRunning){
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
         System.out.println("Error: "+e.toString());
      }
      
      if(Thread.currentThread().getName().equals("T")){
        // change is running
        if(counter++>10){
          this.isRunning = false;
        }
        
      }
      
      System.out.format("Thread running: %s\n",Thread.currentThread().getName());
      if(Thread.interrupted()){
        System.out.format("Thread interrupted: %s\n",Thread.currentThread().getName());
        return;
      }
    }  
  }
  
  public static void main(String args[]){
    
    volatiled v = new volatiled();
    
    // set is running 
    v.setisRunning(true);
    
    Thread t = new Thread(v);
    Thread s = new Thread(v);
    Thread u = new Thread(v);
    Thread vi = new Thread(v);
    Thread w = new Thread(v);
    Thread x = new Thread(v);
    Thread y = new Thread(v);
    Thread z = new Thread(v);
    
    // set thread names
    t.setName("T");
    s.setName("S");
    u.setName("U");
    vi.setName("V");
    w.setName("W");
    x.setName("X");
    y.setName("Y");
    z.setName("Z");
   
    t.start();
    s.start();
    u.start();
    vi.start();
    w.start();
    x.start();
    y.start();
    z.start();
    
    //stopThread(v);
  }
  
  private static void stopThread(volatiled v){
    v.setisRunning(false);
  }
}