package core;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import pascal.types.BooleanType;

public class UnaryFunctionTest {

	private IGenericFunction.Unary uf = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			return BooleanType.FALSE;
		}
		
	};
	
	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRun() {
		Instance res = uf.run(BooleanType.FALSE);
		assertSame(BooleanType.FALSE, res);
	}

	@SuppressWarnings("deprecation")
	@Test(expected=AssertionError.class)
	public void testRunWronNumberOfArgs() {
		Instance res = uf.run(BooleanType.FALSE, BooleanType.TRUE);
		assertSame(BooleanType.FALSE, res);
	}

	@Test
	public void testRun1() {
		Instance res = uf.run1(BooleanType.FALSE);
		assertSame(BooleanType.FALSE, res);
	}


	@Test
	public void testAs() {
		assertSame(uf, uf.asUnary());
		assertSame(NoSuch.BINARY_FUNCTION, uf.asBinary());
	}
}
