/**
* Representative of Item 34: Emulate extensible enums with interfaces.
*
* The gist of this item is that in place of creating an 'abstract method'
* inside an enum declaration, use interface to define extensible enums
*/

/**
* Operator Interface.
*/
interface Operator {
	/**
	* Return the result after operation.
	*
	* @param op1 operand one
	* @param op2 operand two
	* @return double answer after applying the operator on operands
	*/
	double apply(double op1, double op2);
}

/**
* Basic operations enum.
*
* Now, if you want to add more operations to this enum, so in place
* of adding more methods to this enum, you can just create a new enum 
* containing extra operators and that enum can be used in any place where 
* this enum is used. 
*/
enum Operation implements Operator {
	ADD("+") { 
		@Override public double apply(double op1, double op2) {
			return op1 + op2;
		}
	},
	MINUS("-") { 
		@Override public double apply(double op1, double op2) {
			return op1 - op2;
		}
	},
	MULTIPLY("*") { 
		@Override public double apply(double op1, double op2) {
			return op1 * op2;
		}
	},
	DIVIDE("%") { 
		@Override public double apply(double op1, double op2) {
			return op1 % op2;
		}
	};

	// Private member for string name
	private String name;

	// Constructor
	Operation(String name) { this.name = name; }

	// Overridden toString method()
	@Override public String toString() {
		return name;
	}
}

// Driver program
public final class Item34 {
	public static void main(String args[]) {
		// Specify operation, notice the use of interface as type
		Operator op = Operation.MINUS;

		// Calculate the final value
		System.out.println(op.apply(45, 45));
	}
}
