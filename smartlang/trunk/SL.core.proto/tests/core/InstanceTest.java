package core;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import pascal.types.IntegerType;

public class InstanceTest {

	@Test
	public void testInstanceITypeIPrimitiveInitializerOfTT() {
		Instance instance = new Instance(IntegerType.INTEGER, 10);
		assertSame(IntegerType.INTEGER, instance.getType());
	}

}
