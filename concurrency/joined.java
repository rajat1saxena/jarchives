class joined implements Runnable{
  public void run(){
    for(int i=0;i<4000;i++){
      try{
        Thread.sleep(10);
      }catch(InterruptedException e){
        System.out.println("Interrupted!");
        return;
      }
    }
  }
  public static void main(String args[]){
    Thread t = new Thread(new joined());
    t.start();
    
    long startTime = System.currentTimeMillis();
    
    for(int j=0;j<300;j++){
       try{
        Thread.sleep(10);
      }catch(InterruptedException e){
        System.out.println("Interrupted!");
      }
    }
    
    // main thread's loop completed
    long endTime = System.currentTimeMillis();
   
//     // if thread t is alive then wait for 2 more seconds and then terminate the thread if still not finished
//     if(t.isAlive()){
//       t.join(2000);
//     }
    
    System.out.println("Thread main finished");
    
    // wait indefinitely for thread t to complete
    try{
      // at the following command the main thread will wait indefinitely for thread t to finish
      t.join(100);
      t.interrupt();
    }catch(InterruptedException e){
      // do nothing
    }
    
    
  }
}