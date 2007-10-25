package pascal.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static pascal.types.BooleanType.BOOLEAN;
import static pascal.types.BooleanType.FALSE;
import static pascal.types.BooleanType.TRUE;

import org.junit.Before;
import org.junit.Test;

import core.IMethod;
import core.Instance;

public class BooleanTypeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadBooleanValue() throws Exception {
		assertEquals(false, BOOLEAN.readBooleanValue(FALSE));
		assertEquals(true, BOOLEAN.readBooleanValue(TRUE));
	}


	@Test(expected=AssertionError.class)
	public void testReadBooleanValueFail() throws Exception {
		assertEquals(false, BOOLEAN.readBooleanValue(IntegerType.INTEGER.getDefaultValue()));
	}
	
	@Test
	public void testMethodSet() throws Exception {
		IMethod and = BOOLEAN.lookupMethod(" and ");
		IMethod lt = BOOLEAN.lookupMethod(" < ");
		assertSame(BooleanType.AND, and.lookupFunction(BOOLEAN, BOOLEAN).asBinary());
		assertSame(BooleanType.LT, lt.lookupFunction(BOOLEAN, BOOLEAN).asBinary());
	}
	
	@Test
	public void testAND() throws Exception {
		Instance res = BooleanType.AND.run2(TRUE, FALSE);
		assertSame(FALSE, res);
		res = BooleanType.AND.run2(TRUE, TRUE);
		assertSame(TRUE, res);
	}
}
