/**
* Some Java Regex adventures
*/
import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class regexIntro{
	public static void main(String args[]){
		Console console = System.console();
		if(console==null){
			System.err.println("Console absent\n");
			System.exit(1);
		}	
		
		//indefinite loop
		while(true){
			Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));
			Matcher matcher = pattern.matcher(console.readLine("%nEnter your string to search: "));
			boolean found = false;
			while(matcher.find()){
				console.format("Found \"%s\" at %d to %d%n",matcher.group(),matcher.start(),matcher.end());
				found = true;
			}

			if(!found){
				console.format("No match");
			}
		}
	}

}