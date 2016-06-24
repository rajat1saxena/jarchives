/**
* A random Test for JUnit. It is used for running as Suite
*/
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public final class TestJunit2 {
	private static final String name = "Rajat";

	@Test
	public void testName() {
		assertEquals("Rajat", name);
	}
}
