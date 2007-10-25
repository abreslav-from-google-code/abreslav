package pascal.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static pascal.types.BooleanType.BOOLEAN;
import static pascal.types.BooleanType.FALSE;
import static pascal.types.BooleanType.TRUE;
import static pascal.types.CharType.CHAR;
import static pascal.types.IntegerType.BYTE;
import static pascal.types.IntegerType.INTEGER;
import static pascal.types.IntegerType.SHORTINT;
import static pascal.types.IntegerType.SMALLINT;
import static pascal.types.IntegerType.WORD;
import static pascal.types.RealType.REAL;
import static pascal.types.StringType.STRING;

import org.junit.Test;

import core.IFunction;
import core.IType;
import core.Instance;
import core.NoSuch;

public class TypeCastTest {

	private Instance i5 = INTEGER.createInstance(5);
	private Instance i1000 = INTEGER.createInstance(1000);
	private Instance i1 = INTEGER.createInstance(1);
	private Instance i0 = INTEGER.createInstance(0);
	private Instance b5 = BYTE.createInstance(5);
	private Instance si5 = SHORTINT.createInstance(5);
	private Instance smi5 = SMALLINT.createInstance(5);
	private Instance w5 = WORD.createInstance(5);
	private Instance c5 = CHAR.createInstance(5);
	private Instance c1 = CHAR.createInstance(1);
	private Instance c0 = CHAR.createInstance(0);
	private Instance r5 = REAL.createInstance(5.0);
	private IType ARR = new ArrayType(BYTE, INTEGER);
	private Instance arr = ARR.getDefaultValue();
	private EnumeratedType ENUM = new EnumeratedType("a", "b");
	private Instance _a = ENUM.createInstance(0);
	private Instance _b = ENUM.createInstance(1);
	private Instance str = STRING.createString("");
	
	
	private void testCast(Instance o, IType dest, Instance res) {
		IFunction cast = dest.getCastFrom(o.getType());
		Instance casted = cast.asUnary().run1(o);
		assertEquals(res, casted);
	}
	
	private void assertNoCast(Instance o, IType dest) {
		IFunction cast = dest.getCastFrom(o.getType());
		assertSame(NoSuch.FUNCTION, cast);
	}

	private void assertCheckFails(Instance o, IType dest, Instance res) {
		try {
			testCast(o, dest, res);
			fail();
		} catch (RangeCheckException e) {
			
		}
	}
	
	@Test
	public void testInteger() throws Exception {
		assertNoCast(i5, INTEGER);
		assertNoCast(b5, INTEGER);
		assertNoCast(w5, INTEGER);
		assertNoCast(si5, INTEGER);
		assertNoCast(smi5, INTEGER);
		assertNoCast(r5, INTEGER);
		assertNoCast(arr, INTEGER);
		assertNoCast(str, INTEGER);
		testCast(TRUE, INTEGER, i1);
		testCast(FALSE, INTEGER, i0);
		testCast(c5, INTEGER, i5);
		testCast(_a, INTEGER, i0);
		testCast(_b, INTEGER, i1);
	}

	@Test
	public void testByte() throws Exception {
		testCast(b5, BYTE, b5);
		assertCheckFails(i1000, BYTE, b5);
		testCast(i5, BYTE, b5);
		testCast(w5, BYTE, i5);
		testCast(si5, BYTE, i5);
		testCast(smi5, BYTE, i5);
		assertNoCast(r5, BYTE);
		assertNoCast(arr, BYTE);
		assertNoCast(str, BYTE);
		testCast(TRUE, BYTE, i1);
		testCast(FALSE, BYTE, i0);
		testCast(c5, BYTE, i5);
		testCast(_a, BYTE, i0);
		testCast(_b, BYTE, i1);
	}

	@Test
	public void testChar() throws Exception {
		assertNoCast(c5, CHAR);
		testCast(b5, CHAR, c5);
		testCast(i5, CHAR, c5);
		testCast(i0, CHAR, c0);
		testCast(w5, CHAR, c5);
		testCast(si5, CHAR, c5);
		testCast(smi5, CHAR, c5);
		assertCheckFails(i1000, CHAR, c5);
		assertNoCast(r5, CHAR);
		assertNoCast(arr, CHAR);
		assertNoCast(str, CHAR);
		testCast(FALSE, CHAR, c0);
		testCast(TRUE, CHAR, c1);
		testCast(_a, CHAR, c0);
		testCast(_b, CHAR, c1);
	}

	@Test
	public void testBoolean() throws Exception {
		testCast(b5, BOOLEAN, TRUE);
		testCast(i5, BOOLEAN, TRUE);
		testCast(i0, BOOLEAN, FALSE);
		testCast(w5, BOOLEAN, TRUE);
		testCast(si5, BOOLEAN, TRUE);
		testCast(smi5, BOOLEAN, TRUE);
		assertNoCast(r5, BOOLEAN);
		assertNoCast(arr, BOOLEAN);
		assertNoCast(str, BOOLEAN);
		assertNoCast(TRUE, BOOLEAN);
		assertNoCast(FALSE, BOOLEAN);
		testCast(c5, BOOLEAN, TRUE);
		testCast(c0, BOOLEAN, FALSE);
		testCast(_a, BOOLEAN, FALSE);
		testCast(_b, BOOLEAN, TRUE);
	}

	@Test
	public void testReal() throws Exception {
		assertNoCast(r5, REAL);
		testCast(b5, REAL, r5);
		testCast(i5, REAL, r5);
		testCast(w5, REAL, r5);
		testCast(si5, REAL, r5);
		testCast(smi5, REAL, r5);
		assertNoCast(arr, REAL);
		assertNoCast(str, REAL);
		assertNoCast(TRUE, REAL);
		assertNoCast(FALSE, REAL);
		assertNoCast(c5, REAL);
		assertNoCast(c0, REAL);
		assertNoCast(_a, REAL);
		assertNoCast(_b, REAL);
	}

	@Test
	public void testArr() throws Exception {
		assertNoCast(r5, ARR);
		assertNoCast(b5, ARR);
		assertNoCast(i5, ARR);
		assertNoCast(w5, ARR);
		assertNoCast(si5, ARR);
		assertNoCast(smi5, ARR);
		assertNoCast(arr, ARR);
		assertNoCast(str, ARR);
		assertNoCast(TRUE, ARR);
		assertNoCast(FALSE, ARR);
		assertNoCast(c5, ARR);
		assertNoCast(c0, ARR);
		assertNoCast(_a, ARR);
		assertNoCast(_b, ARR);
	}
	@Test

	public void testString() throws Exception {
		assertNoCast(r5, STRING);
		assertNoCast(b5, STRING);
		assertNoCast(i5, STRING);
		assertNoCast(w5, STRING);
		assertNoCast(si5, STRING);
		assertNoCast(smi5, STRING);
		assertNoCast(arr, STRING);
		assertNoCast(str, STRING);
		assertNoCast(TRUE, STRING);
		assertNoCast(FALSE, STRING);
		testCast(c5, STRING, STRING.createString("\u0005"));
		testCast(c0, STRING, STRING.createString("\u0000"));
		assertNoCast(_a, STRING);
		assertNoCast(_b, STRING);
	}
}
