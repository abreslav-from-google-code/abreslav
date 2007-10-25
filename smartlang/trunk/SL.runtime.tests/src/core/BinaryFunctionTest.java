package core;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import pascal.types.BooleanType;

public class BinaryFunctionTest {

	private IGenericFunction.Binary bf = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			return BooleanType.FALSE;
		}
		
	};
	
	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRun() {
		Instance res = bf.run(BooleanType.FALSE, BooleanType.TRUE);
		assertSame(BooleanType.FALSE, res);
	}

	@SuppressWarnings("deprecation")
	@Test(expected=AssertionError.class)
	public void testRunWronNumberOfArgs() {
		Instance res = bf.run(BooleanType.FALSE);
		assertSame(BooleanType.FALSE, res);
	}

	@Test
	public void testRun2() {
		Instance res = bf.run2(BooleanType.FALSE, BooleanType.TRUE);
		assertSame(BooleanType.FALSE, res);
	}

	@Test
	public void testAs() {
		assertSame(bf, bf.asBinary());
		assertSame(NoSuch.UNARY_FUNCTION, bf.asUnary());
	}

}
