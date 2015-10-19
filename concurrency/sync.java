/*
* This class demos the use of synchronization
*/
class bank{
  // amount cannot be negative, it's a design consideration for this program
  private int amount = 1000;
  
  public synchronized int getBalance(){
    return this.amount;
  }
  
  public void debit(int amount){
    this.amount -= amount;
  }
}

class sync implements Runnable{
  
  // create bank's instance
  static bank b;
  static sync s;
  
  public void processDebit(){ // marking this synchronized will make only ram execute till bank gets depleted as Thread.sleep() does not release lock so the bank object will stay hijacked by ram thread 
    int amount = b.getBalance();
    
    while(amount>0){
      // sleep a bit before debiting
      try{
        Thread.sleep(500);
      }catch(InterruptedException e){
        System.out.println("Interrupted");
      }
      
      // debit only if the amount queried in previous step is greater than amount to be debited
      if(amount >= 200){
        b.debit(200);
      }

      // query current amount from bank and make conclusions
      if((amount=b.getBalance())>=0){
        System.out.println(Thread.currentThread().getName()+" debited, remaining amount: "+amount);
      }else{
        System.out.println(Thread.currentThread().getName()+" overtook, remaining amount: "+amount);
      } 
    }  
  }
  
  public void run(){
    processDebit();
  }
  
  public static void main(String args[]){
    // get instance of this class
    s = new sync();
    
    Thread ram = new Thread(s);
    Thread meena = new Thread(s);
    
    // set names
    ram.setName("ram");
    meena.setName("meena");
    
    // get instance of the bank
    b = new bank();
    
    // check balance and debit
    ram.start();

    try{
      ram.sleep(200);
    }catch(InterruptedException e){
      // do nothing
    }
    
    meena.start();
  }
}