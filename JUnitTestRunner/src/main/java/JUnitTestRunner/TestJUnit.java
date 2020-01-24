package JUnitTestRunner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit {
	@Test
	public void testSetup() {
		String str = "I am done with junit setup";
		assertEquals(str, "I am done with junit setup");
	}
}