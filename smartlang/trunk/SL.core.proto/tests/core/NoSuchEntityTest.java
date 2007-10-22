package core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Test;

public class NoSuchEntityTest {

	@Test(expected=UnsupportedOperationException.class)
	public void testNoSuchFunction() throws Exception {
		NoSuch.FUNCTION.run(NoSuch.OBJECT);
	}

	@Test
	public void testNoSuchFieldDescriptor() throws Exception {
		assertSame(NoSuch.OBJECT, NoSuch.FIELD.readValue(null));
		try {
			NoSuch.FIELD.writeValue(null, null);
			fail();
		} catch (UnsupportedOperationException e) {
			
		}
	}

	@Test
	public void testNoSuchMethod() throws Exception {
		assertSame(NoSuch.TYPE, NoSuch.METHOD.getDeclaringType());
		assertSame("", NoSuch.METHOD.getName());
		assertSame(NoSuch.FUNCTION, NoSuch.METHOD.lookupFunction());
	}

	@Test
	public void testNoSuchType() throws Exception {
		assertFalse(NoSuch.TYPE.conformsTo(NoSuch.TYPE));
		assertSame(NoSuch.OBJECT, NoSuch.TYPE.getDefaultValue());
		assertSame(NoSuch.FIELD, NoSuch.TYPE.lookupField("any"));
		assertSame(NoSuch.METHOD, NoSuch.TYPE.lookupMethod("any"));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testNoSuchBinaryFunction() throws Exception {
		NoSuch.BINARY_FUNCTION.run2(NoSuch.OBJECT, NoSuch.OBJECT);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testNoSuchUnaryFunction() throws Exception {
		NoSuch.UNARY_FUNCTION.run1(NoSuch.OBJECT);
	}
}
