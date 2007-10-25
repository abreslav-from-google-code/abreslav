package pascal.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static pascal.types.CharType.CHAR;

import org.junit.Test;

import core.IMethod;
import core.Instance;
import core.IGenericFunction.Binary;

public class CharTypeTest {

	private Instance c2 = CHAR.createInstance(2);
	private Instance a = CHAR.createInstance((int) 'a');

	@Test
	public void testCreateInteger() {
		assertEquals(2, CharType.F_THIS.readValue(c2));
		assertSame(c2, CHAR.createInstance(2));
	}

	@Test(expected=RangeCheckException.class)
	public void testCreateIntegerFailUp() {
		CHAR.createInstance(256);
	}

	@Test(expected=RangeCheckException.class)
	public void testCreateIntegerFailDown() {
		CHAR.createInstance(-1);
	}

	@Test
	public void testCreateChar() {
		assertEquals((int) 'a', CharType.F_THIS.readValue(a));
		assertSame(a, CHAR.createInstance((int) 'a'));
	}

	@Test
	public void testGetHigh() {
		assertSame(CHAR.createInstance(255), CHAR.getHigh());
	}

	@Test
	public void testGetLow() {
		assertSame(CHAR.createInstance(0), CHAR.getLow());
	}

	@Test
	public void testReadCharValue() {
		assertEquals('a', CHAR.readCharValue(a));
	}

	@Test
	public void testPlusOnTwoChars() {
		IMethod plus = CHAR.lookupMethod(" + ");
		Binary char_char = plus.lookupFunction(CHAR, CHAR).asBinary();
		assertEquals(StringType.CONCAT_TWO_CHARS, char_char);
	}

	@Test
	public void testPlusOnCharAndString() {
		IMethod plus = CHAR.lookupMethod(" + ");
		Binary char_str = plus.lookupFunction(CHAR, StringType.STRING).asBinary();
		assertEquals(StringType.CONCAT_CHAR_WITH, char_str);
	}
}
