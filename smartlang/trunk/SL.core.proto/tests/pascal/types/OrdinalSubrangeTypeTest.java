package pascal.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class OrdinalSubrangeTypeTest {

	private OrdinalSubrangeType type = new OrdinalSubrangeType(
			IntegerType.INTEGER, 
			IntegerType.INTEGER.createInstance(1),
			IntegerType.INTEGER.createInstance(3)
			);	
	
	@Test
	public void testGetLow() {
		assertSame(IntegerType.INTEGER.createInstance(1), type.getLow());
	}

	@Test
	public void testGetHigh() {
		assertSame(IntegerType.INTEGER.createInstance(3), type.getHigh());
	}

	@Test
	public void testCreateNoFail() {
		assertSame(IntegerType.INTEGER.createInstance(3), type.createInstance(3));
	}

	@Test(expected=RangeCheckException.class)
	public void testCreateFailMore() {
		type.createInstance(4);
	}

	@Test(expected=RangeCheckException.class)
	public void testCreateFailLess() {
		type.createInstance(0);
	}
	
	@Test
	public void testLowHigh() throws Exception {
		assertEquals(1, OrdinalType.F_THIS.readValue(type.getLow()));		
		assertEquals(3, OrdinalType.F_THIS.readValue(type.getHigh()));		
	}
	
	@Test
	public void testGetDefault() throws Exception {
		assertSame(type.getDefaultValue(), type.getLow());
	}
}
