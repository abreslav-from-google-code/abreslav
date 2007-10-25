package pascal.types;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static pascal.types.IntegerType.BYTE;
import static pascal.types.IntegerType.INTEGER;

import org.junit.Before;
import org.junit.Test;

import core.IFunction;
import core.IMethod;
import core.Instance;

public class IntegerTypeTest {

	private Instance i2;
	private Instance i5;

	@Before
	public void setUp() throws Exception {
		i2 = INTEGER.createInstance(2);
		i5 = INTEGER.createInstance(5);
	}
	
	@Test
	public void testF_THIS() throws Exception {
		assertEquals(2, IntegerType.F_THIS.readValue(i2));
	}
	
	@Test
	public void testADD() throws Exception {
		Instance sum = IntegerType.ADD.run2(i5, i2);
		assertEquals(7, IntegerType.F_THIS.readValue(sum));
	}

	@Test
	public void testSUB() throws Exception {
		Instance res = IntegerType.SUB.run2(i5, i2);
		assertEquals(3, IntegerType.F_THIS.readValue(res));
	}

	@Test
	public void testMUL() throws Exception {
		Instance res = IntegerType.MUL.run2(i5, i2);
		assertEquals(10, IntegerType.F_THIS.readValue(res));
	}

	@Test
	public void testDIV() throws Exception {
		Instance res = IntegerType.DIV.run2(i5, i2);
		assertEquals(2, IntegerType.F_THIS.readValue(res));
	}

	@Test
	public void testMOD() throws Exception {
		Instance res = IntegerType.MOD.run2(i5, i2);
		assertEquals(1, IntegerType.F_THIS.readValue(res));
	}

	@Test
	public void testNEG() throws Exception {
		Instance res = IntegerType.NEG.run1(i5);
		assertEquals(-5, IntegerType.F_THIS.readValue(res));
	}

	@Test
	public void testLT() throws Exception {
		Instance res = IntegerType.LT.run2(i2, i5);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testLE() throws Exception {
		Instance res = IntegerType.LE.run2(i5, i5);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testEQ() throws Exception {
		Instance res = IntegerType.EQ.run2(i2, i5);
		assertSame(BooleanType.FALSE, res);
	}

	@Test
	public void testNE() throws Exception {
		Instance res = IntegerType.NE.run2(i2, i5);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testGE() throws Exception {
		Instance res = IntegerType.GE.run2(i2, i5);
		assertSame(BooleanType.FALSE, res);
	}

	@Test
	public void testGT() throws Exception {
		Instance res = IntegerType.GT.run2(i5, i2);
		assertSame(BooleanType.TRUE, res);
	}

	@Test
	public void testSUCC() throws Exception {
		Instance res = IntegerType.SUCC.run1(i5);
		assertSame(6, IntegerType.F_THIS.readValue(res));
	}

	@Test
	public void testPRED() throws Exception {
		Instance res = IntegerType.PRED.run1(i5);
		assertSame(4, IntegerType.F_THIS.readValue(res));
	}

	@Test
	public void testGetHigh() throws Exception {
		assertEquals(Integer.MAX_VALUE, IntegerType.F_THIS.readValue(INTEGER.getHigh()));
		assertSame(IntegerType.F_THIS.readValue(INTEGER.getHigh()),
				IntegerType.F_THIS.readValue(INTEGER.getHigh()));
	}

	@Test
	public void testGetLow() throws Exception {
		assertEquals(Integer.MIN_VALUE, IntegerType.F_THIS.readValue(INTEGER.getLow()));
		assertSame(IntegerType.F_THIS.readValue(INTEGER.getLow()),
				IntegerType.F_THIS.readValue(INTEGER.getLow()));
	}

	@Test
	public void testOperationOverloadingArithm() throws Exception {
		IMethod plus = INTEGER.lookupMethod(" + ");
		IFunction addInt = plus.lookupFunction(BYTE, BYTE);
		assertSame(addInt.asBinary(), IntegerType.ADD);
		IFunction addReal = plus.lookupFunction(RealType.REAL, INTEGER);
		assertSame(addReal.asBinary(), RealType.ADD);
	}

	@Test
	public void testOperationOverloadingComparisons() throws Exception {
		IMethod lt = INTEGER.lookupMethod(" < ");
		IFunction addInt = lt.lookupFunction(BYTE, BYTE);
		assertSame(addInt.asBinary(), IntegerType.LT);
		IFunction addReal = lt.lookupFunction(RealType.REAL, INTEGER);
		assertSame(addReal.asBinary(), RealType.LT);
	}
}