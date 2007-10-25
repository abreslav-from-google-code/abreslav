package pascal.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static pascal.types.RealType.REAL;

import org.junit.Before;
import org.junit.Test;

import core.IMethod;
import core.Instance;

public class RealTypeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDefaultValue() {
		assertSame(REAL.getDefaultValue(), REAL.getDefaultValue());
	}

	private Instance i2 = REAL.createInstance(2.0);
	private Instance i5 = REAL.createInstance(5.0);

	@Test
	public void testF_THIS() throws Exception {
		assertEquals(2, RealType.F_THIS.readValue(i2));
	}
	
	@Test
	public void testADD() throws Exception {
		Instance sum = RealType.ADD.run2(i5, i2);
		assertEquals(7, RealType.F_THIS.readValue(sum));
	}

	@Test
	public void testSUB() throws Exception {
		Instance res = RealType.SUB.run2(i5, i2);
		assertEquals(3, RealType.F_THIS.readValue(res));
	}

	@Test
	public void testMUL() throws Exception {
		Instance res = RealType.MUL.run2(i5, i2);
		assertEquals(10, RealType.F_THIS.readValue(res));
	}

	@Test
	public void testDIV() throws Exception {
		Instance res = RealType.DIV.run2(i5, i2);
		assertEquals(2.5, RealType.F_THIS.readValue(res));
	}

	@Test
	public void testNEG() throws Exception {
		Instance res = RealType.NEG.run1(i5);
		assertEquals(-5, RealType.F_THIS.readValue(res));
	}

	@Test
	public void testLT() throws Exception {
		Instance res = RealType.LT.run2(i2, i5);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testLE() throws Exception {
		Instance res = RealType.LE.run2(i5, i5);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testEQ() throws Exception {
		Instance res = RealType.EQ.run2(i2, i5);
		assertSame(BooleanType.FALSE, res);
	}

	@Test
	public void testNE() throws Exception {
		Instance res = RealType.NE.run2(i2, i5);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testGE() throws Exception {
		Instance res = RealType.GE.run2(i2, i5);
		assertSame(BooleanType.FALSE, res);
	}

	@Test
	public void testGT() throws Exception {
		Instance res = RealType.GT.run2(i5, i2);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testMethods() throws Exception {
		IMethod less = REAL.lookupMethod(" < ");
		IMethod add = REAL.lookupMethod(" + ");
		assertSame(RealType.LT, less.lookupFunction(REAL, REAL).asBinary());
		assertSame(RealType.ADD, add.lookupFunction(REAL, REAL).asBinary());
	}
}
