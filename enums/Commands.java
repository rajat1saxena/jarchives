/**
* This example is based on Java Magazine - MarchApril 2016
*
* Post: Making the most of Enums
*/
public class Commands {
	enum Command {
		GO, STOP, FORWARD, BACK, DIE
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
					result = name + " goes";
					break;
				case STOP:
					result = name + " stops";
					break;
				case FORWARD:
					result = name + " forwards";
					break;
				case BACK:
					result = name + " backs";
					break;
				case DIE:
					result = name + " dies";
					break;
			}	
			// Print out the result
			System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("Error! Supply player's name");
		}	
	}
}
