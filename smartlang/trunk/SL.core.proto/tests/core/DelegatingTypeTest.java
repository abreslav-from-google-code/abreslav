package core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static pascal.types.IntegerType.INTEGER;

import org.junit.Test;

import pascal.types.BooleanType;
import pascal.types.IntegerType;

public class DelegatingTypeTest {

	private DelegatingType<Integer, IntegerType> type = new DelegatingType<Integer, IntegerType>(INTEGER);  
	
	@Test
	public void testGetDefaultValue() {
		assertEquals(INTEGER.getDefaultValue(), type.getDefaultValue());
	}

	@Test
	public void testLookupField() {
		assertSame(NoSuch.FIELD, type.lookupField(""));
		assertSame(NoSuch.FIELD, type.lookupField("any"));
	}

	@Test
	public void testLookupMethod() {
		assertSame(IntegerType.ADD, type.lookupMethod(" + ").lookupFunction(INTEGER, INTEGER).asBinary());
	}

	@Test
	public void testConformsTo() {
		assertTrue(type.conformsTo(INTEGER));
		assertFalse(type.conformsTo(BooleanType.BOOLEAN));
	}

	@Test
	public void testGetCastFrom() {
		assertSame(INTEGER.getCastFrom(INTEGER), type.getCastFrom(INTEGER));
		assertSame(INTEGER.getCastFrom(BooleanType.BOOLEAN), type.getCastFrom(BooleanType.BOOLEAN));
	}

	@Test
	public void testCreate() {
		assertSame(INTEGER.createInstance(0), type.createInstance(0));
		assertEquals(INTEGER.createInstance(1000000), type.createInstance(1000000));
	}
}
