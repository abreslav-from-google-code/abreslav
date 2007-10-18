package pascal.types;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JPrimitivesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testByte() throws Exception {
		Integer i = -10;
		assertEquals(-10, i.byteValue());

		i = 256;
		assertEquals(0, i.byteValue());
		
		i = -1024;
		assertEquals(0, i.byteValue());

		i = -1;
		assertEquals(-1, i.byteValue());
	}
}
