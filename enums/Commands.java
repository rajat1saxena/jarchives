/**
* This example is based on Java Magazine - MarchApril 2016
*
* Post: Making the most of Enums
*/
public class Commands {
	enum Command {
		GO("goes", 1), 
		STOP("stops", 2), 
		FORWARD("forwards", 3), 
		BACK("backs", 4), 
		DIE("dies", 5);
		
		private String commandString;
		private int commandPriority;
		
		// Enum constructors are always private
		Command(String commandString, int commandPriority) {
			this.commandString = commandString;
			this.commandPriority = commandPriority;
		}

		@Override
		public String toString() {
			return commandString + " at " + commandPriority;
		}
	}

	/**
	* @throws Exception when {@code args.length==0}
	*/
	public static void main(String args[]) {
		try {
			String name = args[0];
			// Hard-coded command
			Command commandword = Command.STOP;
			String result = name;
			switch (commandword) {
				case GO:
					result = name + " " + commandword;
					break;
				case STOP:
					result = name + " " + commandword;
					break;
				case FORWARD:
					result = name + " " + commandword;
					break;
				case BACK:
					result = name + " " + commandword;
					break;
				case DIE:
					result = name + " " + commandword;
					break;
			}	
			// Print out the result
			System.out.println(result);
			
			// Enum values are objects, not ints
			if (Command.GO instanceof Object) {
				System.out.println("Go is an instance of Object");
			}

			// Enums inherit from Java standard class 'Enum'
			//
			// The class has three important methods i.e name(),
			// ordinal() and the static method values().
			Command cmd = Command.DIE;
			System.out.format("Name, Ordinal: %s, %d\n", cmd.name(),cmd.ordinal());
			for (Command c:Command.values()) {
				System.out.println(c);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("Error! Supply player's name");
		}	
	}
}
