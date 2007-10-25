package pascal.types;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pascal.types.BooleanType.BOOLEAN;
import static pascal.types.CharType.CHAR;
import static pascal.types.IntegerType.BYTE;
import static pascal.types.IntegerType.INTEGER;
import static pascal.types.IntegerType.SHORTINT;
import static pascal.types.RealType.REAL;
import static pascal.types.StringType.STRING;

import org.junit.Test;

import core.NoSuch;

public class TypeConformanceTest {
	
	private EnumeratedType _enum = new EnumeratedType("a", "b");
	private ArrayType a1 = new ArrayType(BYTE, INTEGER);
	private ArrayType a2 = new ArrayType(BYTE, INTEGER);

	@Test
	public void testInteger() {
		assertTrue(INTEGER.conformsTo(INTEGER));
		assertTrue(INTEGER.conformsTo(BYTE));
		assertFalse(INTEGER.conformsTo(NoSuch.TYPE));
		assertTrue(INTEGER.conformsTo(REAL));
		assertFalse(INTEGER.conformsTo(BOOLEAN));
	}

	@Test
	public void testIntTypesToEachOther() throws Exception {
		assertTrue(BYTE.conformsTo(BYTE));
		assertTrue(BYTE.conformsTo(SHORTINT));
		assertTrue(BYTE.conformsTo(REAL));
		assertTrue(BYTE.conformsTo(INTEGER));
		assertFalse(BYTE.conformsTo(BOOLEAN));
		assertFalse(BYTE.conformsTo(_enum));
		assertFalse(BYTE.conformsTo(a1));
		assertFalse(BYTE.conformsTo(NoSuch.TYPE));
	}

	@Test
	public void testBoolean() throws Exception {
		assertTrue(BOOLEAN.conformsTo(BOOLEAN));
		assertFalse(BOOLEAN.conformsTo(INTEGER));
		assertFalse(BOOLEAN.conformsTo(BYTE));
		assertFalse(BOOLEAN.conformsTo(REAL));
		assertFalse(BOOLEAN.conformsTo(_enum));
		assertFalse(BOOLEAN.conformsTo(a1));
		assertFalse(BOOLEAN.conformsTo(NoSuch.TYPE));
	}

	@Test
	public void testEnum() throws Exception {
		assertTrue(_enum.conformsTo(_enum));
		assertFalse(_enum.conformsTo(BOOLEAN));
		assertFalse(_enum.conformsTo(BYTE));
		assertFalse(_enum.conformsTo(a1));
		assertFalse(_enum.conformsTo(NoSuch.TYPE));
	}

	@Test
	public void testArray() throws Exception {
		assertTrue(a1.conformsTo(a1));
		assertFalse(a1.conformsTo(a2));
		assertFalse(a1.conformsTo(BOOLEAN));
		assertFalse(a1.conformsTo(REAL));
		assertFalse(a1.conformsTo(INTEGER));
		assertFalse(a1.conformsTo(BYTE));
		assertFalse(a1.conformsTo(NoSuch.TYPE));
	}

	@Test
	public void testReal() throws Exception {
		assertTrue(REAL.conformsTo(REAL));
		assertFalse(REAL.conformsTo(NoSuch.TYPE));
		assertFalse(REAL.conformsTo(INTEGER));
		assertFalse(REAL.conformsTo(BYTE));
		assertFalse(REAL.conformsTo(BOOLEAN));
		assertFalse(REAL.conformsTo(a1));
	}

	@Test
	public void testString() throws Exception {
		assertTrue(STRING.conformsTo(STRING));
		assertFalse(STRING.conformsTo(NoSuch.TYPE));
		assertFalse(STRING.conformsTo(INTEGER));
		assertFalse(STRING.conformsTo(BYTE));
		assertFalse(STRING.conformsTo(REAL));
		assertFalse(STRING.conformsTo(BOOLEAN));
		assertFalse(STRING.conformsTo(a1));
		assertFalse(STRING.conformsTo(CHAR));
	}

	@Test
	public void testChar() throws Exception {
		assertTrue(CHAR.conformsTo(CHAR));
		assertTrue(CHAR.conformsTo(STRING));
		assertFalse(CHAR.conformsTo(NoSuch.TYPE));
		assertFalse(CHAR.conformsTo(INTEGER));
		assertFalse(CHAR.conformsTo(BYTE));
		assertFalse(CHAR.conformsTo(BOOLEAN));
		assertFalse(CHAR.conformsTo(a1));
		assertFalse(CHAR.conformsTo(REAL));
	}
}
