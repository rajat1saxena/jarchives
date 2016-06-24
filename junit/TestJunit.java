/**
* Test to check if JUnit setup is working fine or not.
*/

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public final class TestJunit {
	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
}
