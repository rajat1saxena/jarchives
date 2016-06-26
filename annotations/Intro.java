// To make information in @Author available in Javadoc-generated
// documentation, you must annotate the @Author definition with the
// @Documented annotation.

// Import this to use @Documented
import java.lang.annotation.*;
 
// Annotation types are a form of interface
@Documented
@interface Author {
	String name();
	String date() default "N/A";
	String[] reviewers();
}

@Author(
	name = "Rajat Saxena",
	date = "21/06/2016",
	reviewers = {"Ravi", "Krishan"}
)
public final class Intro {
	public static void main(String args[]) {
		System.out.println("Introduction to Annotations");
	}
}
