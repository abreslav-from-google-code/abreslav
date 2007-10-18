package pascal.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import core.IGenericField;
import core.Instance;
import core.NoSuch;

public class ArrayTypeTest {

	private static final OrdinalSubrangeType ORDINAL_SUBRANGE_TYPE = new OrdinalSubrangeType(
							IntegerType.INTEGER, 
							IntegerType.INTEGER.createInstance(-1),
							IntegerType.INTEGER.createInstance(1));
	private ArrayType type;

	@Before
	public void setUp() throws Exception {
		type = new ArrayType( 
				ORDINAL_SUBRANGE_TYPE,
				IntegerType.INTEGER);
	}

	@Test
	public void testConstructor() throws Exception {
		assertEquals(IntegerType.INTEGER, type.getElementType());
	}

	@Test
	public void testMethods() throws Exception {
		assertEquals(NoSuch.METHOD, type.lookupMethod("any"));
	}

	@Test
	public void testNamedFields() throws Exception {
		assertEquals(NoSuch.FIELD, type.lookupField("any"));
	}

	@Test
	public void testCreate() throws Exception {
		Instance res = type.createInstance();
		assertSame(type, res.getType());
	}

	@Test
	public void testGetDefaultValue() throws Exception {
		Instance res = type.getDefaultValue();
		assertSame(type, res.getType());
	}

	@Test
	public void testElementDefaultValue() throws Exception {
		Instance res = type.createInstance();
		IGenericField f0 = type.getElementField(-1);
		Instance value = f0.readValue(res);
		assertEquals(0, IntegerType.F_THIS.readValue(value));
	}

	@Test(expected=AssertionError.class)
	public void testGetElementFieldIndexOutOfBoundsHigh() throws Exception {
		type.getElementField(2);
	}

	@Test(expected=AssertionError.class)
	public void testGetElementFieldIndexOutOfBoundsLow() throws Exception {
		type.getElementField(-2);
	}

	@Test
	public void testWriteToElement() throws Exception {
		IGenericField f1 = type.getElementField(1);
		Instance res = type.createInstance();
		f1.writeValue(res, IntegerType.INTEGER.createInstance(10));
		assertEquals(10, IntegerType.F_THIS.readValue(f1.readValue(res)));
	}
	
	@Test
	public void testGetElementFieldCreatesOnce() throws Exception {
		IGenericField f1 = type.getElementField(1);
		IGenericField f1_ = type.getElementField(1);
		assertSame(f1, f1_);
	}

	@Test
	public void testGetReadWriteFunctions() throws Exception {
		IGenericField f1 = type.getElementField(1);
		Instance res = type.createInstance();
		Instance v = IntegerType.INTEGER.createInstance(10);
		f1.writeValue(res, v);
		assertSame(v, f1.readValue(res));
	}
	
	@Test
	public void testGetIndexType() throws Exception {
		assertSame(ORDINAL_SUBRANGE_TYPE, type.getIndexType());
	}
}
