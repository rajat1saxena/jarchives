/*
* This program shows how to create new annotations and use them reflectively in the code using
* a simple test runner design.
*/
import java.lang.annotation.*;
import java.lang.reflect.*;

/**
* Marker annotation to mark methods as 'Test' which should be picked by our test runner
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}

/**
* An example test suit containing our tests.
*/
final class MyTestSuite {
	@Test public static void myMethod() { }
	@Test public static void tooSweet() {
		throw new RuntimeException("I am not that sweet");
	}
	// non test method
	public static void dontTestMe() {
		System.out.println("This should not be printed");
	}
	@Test public void instanceMethod() { } // Invalid use of the 'Test' annotation
	@Test public static void exceptMe() {
		throw new RuntimeException("I have to be excepted");
	}
	@Test public static void goodTest() { }
}

/**
* Test runner, which consumes MyTestSuite.
*/
public class CreateAndUseNewAnnotations {
	public static void main(String args[]) {
		int tests = 0;
		int passed = 0;
		Class testSuite = Class.forName("MyTestSuite");
	}
}
