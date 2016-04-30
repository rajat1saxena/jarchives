/*
* Efficient Java::Item 5
* Avoid creating unnecessary objects
* 
* Here Calendar,TimeZone and Date instances are created only once.
*/
import java.util.*;

public class jbitem5{
	private final Date birthDate;
	private final static Date BOOM_START;
	private final static Date BOOM_END;

	public jbitem5(Date birthDate){
		this.birthDate = birthDate;
	}

	// Executed only once, at class loading time
	static{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = cal.getTime();
		cal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = cal.getTime();
	}

	public boolean isBabyBoomerStatic(){
		return birthDate.compareTo(BOOM_START) >= 0 &&
			birthDate.compareTo(BOOM_END) < 0;
	}

	public boolean isBabyBoomer(){
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = cal.getTime();
		cal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = cal.getTime();
		return birthDate.compareTo(boomStart) >= 0 &&
			birthDate.compareTo(boomEnd) < 0;
	}

	public static void main(String args[]){
		jbitem5 jb = new jbitem5(new Date());

		// We are going to compare time-duration for one million iterations
		// for both methods
		long startTime = System.currentTimeMillis();
		for(int i=0; i<1000000;i++){
			jb.isBabyBoomer();
		}
		long endTime = System.currentTimeMillis();
		long diff = endTime-startTime;
		System.out.println("Time elapsed: " + Long.toString(diff)); // Note: you cannot 
		// do 
		// - ("Time elapsed" + diff) : this will give error "bad operand types..." 
		// - ("Time elapsed" + diff) : this will give error "long cannot be dereferenced" as 
		// you cannot call methods on primitives

		// the faster method :; I tested it
		// Results: this method ran in 7 millis while the prior one ran in 1024 millis :P
		startTime = System.currentTimeMillis();
		for(int i=0; i<1000000;i++){
			jb.isBabyBoomerStatic();
		}
		endTime = System.currentTimeMillis();
		diff = endTime-startTime;
		System.out.println("Time elapsed: " + Long.toString(diff));
	}
}