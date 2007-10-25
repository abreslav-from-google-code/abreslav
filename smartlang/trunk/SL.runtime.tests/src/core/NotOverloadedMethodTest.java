package core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import pascal.types.BooleanType;
import pascal.types.IntegerType;

public class NotOverloadedMethodTest {

	private NotOverloadedMethod nom;
	private IGenericFunction.Unary nomImpl = new IGenericFunction.Unary() {
		
		@Override
		public Instance run1(Instance thiz) {
			return null;
		}
		
	};

	@Before
	public void setUp() throws Exception {
		nom = new NotOverloadedMethod(BooleanType.BOOLEAN, "nom", new FunctionWrapper(nomImpl, BooleanType.BOOLEAN, BooleanType.BOOLEAN));
	}

	@Test
	public void testNotOverloadedMethod() {
		assertEquals("nom", nom.getName());
		assertEquals(BooleanType.BOOLEAN, nom.getDeclaringType());
	}

	@Test
	public void testLookupFunctionSuccess() {
		IFunction f = nom.lookupFunction(BooleanType.BOOLEAN);
		assertSame(nomImpl, f.asUnary());
	}

	@Test
	public void testLookupFunctionFail() {
		IFunction f = nom.lookupFunction(BooleanType.BOOLEAN, IntegerType.INTEGER);
		assertSame(NoSuch.FUNCTION, f);
	}
}
