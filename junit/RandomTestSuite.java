/**
* A test suite for running TestJunit and TestJunit2 tests
*/
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestJunit.class, 
	TestJunit2.class
})

public final class RandomTestSuite {
}
