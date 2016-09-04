/**
 * This is how you invoke a JS function using Nashorn.
 */
import javax.script.*;

public class Intro {
	public static void main (String args[]) throws ScriptException {
		ScriptEngine e = new ScriptEngineManager().getEngineByName("nashorn");
		e.eval("function f(x) { return x < 2 ? 1: f(x-1) * x }");

		Invocable i = (Invocable) e;

		try {
			System.out.println(i.invokeFunction("f", new Object[] {"5"}));
		} catch (NoSuchMethodException u) {
			// Do nothing
		}
	}
}
