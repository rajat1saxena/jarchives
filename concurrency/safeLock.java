/**
* This class demonstrates the use of ReentrantLock
*
*/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class safeLock{
	static class Friend{
		private String name;
		private Lock lock = new ReentrantLock();
		
		public Friend(String name){
			this.name = name;	
		}
		
		public String getName(){
			return this.name;
		}
		
		public boolean ensureLock(Friend bower){
			Boolean myLock = false;
			Boolean yourLock = false;
			try{
				myLock = this.lock.tryLock();
				yourLock = bower.lock.tryLock();
			}
			finally{
				//reset locks if not able to acquire lock on both Friend objects
				if(!(myLock && yourLock)){
					if(myLock){
						lock.unlock();
					}
					if(yourLock){
						bower.lock.unlock();
					}
				}
			}
			return myLock && yourLock;
		}

		public void bow(Friend bower){
			if(ensureLock(bower)){
				System.out.format("%s: bowed to %s\n",this.name,bower.getName());
				bower.bowBack(this);

				// release locks
				lock.unlock();
				bower.lock.unlock();
			}else{
				System.out.format("%s: %s tried to bow,but I was already bowing to him\n",this.name,bower.getName());
			}
		}

		public void bowBack(Friend bower){
			System.out.format("%s: %s bowed to me\n",this.name,bower.getName());
		}
	}

	static class BowLoop implements Runnable{
		private Friend bower;
		private Friend bowee;
		
		public BowLoop(Friend bower,Friend bowee){
			this.bower = bower;
			this.bowee = bowee;
		}

		public void run(){
			for(;;){
				try{
					Thread.sleep(200);
				}catch(InterruptedException e){
					// do nothing
				}
				
				bower.bow(bowee);
			}
		}
	}

	public static void main(String args[]){
		Friend jack = new Friend("Jack");
		Friend martin = new Friend("Martin");
		new Thread(new BowLoop(jack,martin)).start();
		new Thread(new BowLoop(martin,jack)).start();
	} 
}