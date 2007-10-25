package pascal.types;

import static org.junit.Assert.*;
import static pascal.types.StringType.*;
import static pascal.types.CharType.CHAR;
import org.junit.Test;

import core.Instance;

public class StringTypeTest {

	Instance s1 = STRING.createString("abc");
	Instance s2 = STRING.createString("123");
	Instance c1 = CHAR.createInstance((int) '1');
	Instance c2 = CHAR.createInstance((int) '2');

	@Test
	public void testConcat() throws Exception {
		Instance res = CONCAT_WITH_STRING.asBinary().run2(s1, s2);
		assertEquals(STRING.createString("abc123"), res);
	}

	@Test
	public void testConcatWithChar() throws Exception {
		Instance res = CONCAT_WITH_CHAR.asBinary().run2(s1, c1);
		assertEquals(STRING.createString("abc1"), res);
	}

	@Test
	public void testConcatCharWith() throws Exception {
		Instance res = CONCAT_CHAR_WITH.asBinary().run2(c1, s1);
		assertEquals(STRING.createString("1abc"), res);
	}

	@Test
	public void testConcatTwoChars() throws Exception {
		Instance res = CONCAT_TWO_CHARS.asBinary().run2(c1, c2);
		assertEquals(STRING.createString("12"), res);
	}
}
