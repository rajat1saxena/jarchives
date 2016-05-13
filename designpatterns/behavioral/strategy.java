package designpatterns.behavioral;
/**
* Strategy Pattern
*
* Here we will design many different strategies to compare Strings based on
* different criterion. We will use the Comparator<T> interface as the default
* interface required for implementing this pattern.
*/
import java.util.*;

// Step 1: Define interface :; We have used Comparator which has following 
// definition:
//
// public interface Comparator<T>{
// 	public int compare(T t1, T t2);
// }

// You can implement concrete classes separately here as public or protected
// classes or define anonymous classes
class strategy{
	// Strategy 1: Length comparison (Concrete strategy)
	private static class LengthCmp implements Comparator<String> {
		@Override public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	}

	// Strategy 2: Lexicographical comparison (Concrete strategy)
	private static class LexicoCmp implements Comparator<String> {
		@Override public int compare(String s1, String s2) {
			return s1.compareTo(s2); // compareTo compares Lexicographically
		}
	}

	private static final Comparator<String> LENGTH_COMPARATOR = new LengthCmp();
	private static final Comparator<String> LEXICO_COMPARATOR = new LexicoCmp();
	// one can also define new Comparator as an anonymous class like as follows:
	// p.s.f Comparator NEW_COMPARATOR = new Comparator<String>() {..}

	// takes strategy as function
	private static int compare(String s1, String s2, Comparator<String> algo) {
		return algo.compare(s1, s2);
	}

	public static void main(String[] args) {
		String a, b;
		a = "Rajat";
		b = "Ankita";

		System.out.println("Length comparison: " 
			+ strategy.compare(a, b, LENGTH_COMPARATOR));
		System.out.println("Lexicographical comparison: " 
			+ strategy.compare(a, b, LEXICO_COMPARATOR));
	}
} 