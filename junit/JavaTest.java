/**
* A simple fixture.
* 
* This example shows how setUp and tearDown methods work.
*/
import junit.framework.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
// import a static member of a class
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class JavaTest{
	private int value1, value2;

	@Before
	public void setUp() {
		value1 = 3;
		value2 = 3;
	}

	@Test
	public void testAdd() {
		int result = value1 + value2;
		assertTrue(result == 6);
	}

	@After
	public void tearDown() {
		value1 = 0;
		value2 = 0;
		assertEquals(value1, 0);
		assertEquals(value2, value1);
	}
}
