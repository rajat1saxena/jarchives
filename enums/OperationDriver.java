/**
* This example was taken from Effective Java (Item 30).
*
* This example shows how to use 'constant-specific method implementations'
* in enums.
*/
final class OperationDriver {
	private static enum Operation {
		PLUS("+") {
			double apply(double x, double y) { return x+y; }
		},
		MINUS("-") {
			double apply(double x, double y) { return x-y; }
		},
		MULTIPLY("*") {
			double apply(double x, double y) { return x*y; }
		},
		DIVIDE("/") {
			double apply(double x, double y) { return x/y; }
		};
		
		// Declare a private field to store symbol
		// Since enums are immutable, all field have to be final
		// and it is advicable to make them private.
		private final String symbol;
		
		// Constructor
		Operation(String symbol) { this.symbol = symbol; }

		@Override
		public String toString() {
			return this.symbol;
		}

		// All constants must override the following
		// abstract method, otherwise the compiler will
		// complain.
		abstract double apply(double x, double y);
	}

	public static void main(String args[]) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		for (Operation op: Operation.values()) {
			System.out.printf("%f %s %f: %f%n",
				x, op, y, op.apply(x, y));
		}	
	}
}
