package pascal.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class EnumeratedTypeTest {

	private EnumeratedType type = new EnumeratedType("a", "b");
	
	@Test
	public void testGetLiteralName() {
		assertEquals("a", type.getLiteralName(type.createInstance(0)));
	}

	@Test
	public void testCreateInteger() {
		assertSame(type.createInstance(0), type.createInstance(0));
	}

	@Test
	public void testConformsTo() {
		assertFalse(type.conformsTo(IntegerType.INTEGER));
	}

	@Test
	public void testLow() {
		assertSame(type.getLow(), type.createInstance(0));
	}

	@Test
	public void testHigh() {
		assertSame(type.getHigh(), type.createInstance(1));
	}
}
