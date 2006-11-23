package ru.ifmo.rain.breslav.deferred.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ru.ifmo.rain.breslav.deferred.DComposite;
import ru.ifmo.rain.breslav.deferred.DObject;
import ru.ifmo.rain.breslav.deferred.ResolveFailedException;

public class TestDComposite {

	private static final class DBytes extends DComposite<List<Byte>> {

		private List<Byte> bytes = new ArrayList<Byte>();
		
		@Override
		protected List<Byte> doResolve() throws ResolveFailedException {
			return bytes;
		}
		
		public void add(byte b) { 
			bytes.add(b);
		}
		
		public DObject<Byte> get(final int index) {
			DObject<Byte> result = new DObject<Byte>() {

				@Override
				protected Byte doResolve() throws ResolveFailedException {
					if ((index < 0) || (index >= bytes.size())) {
						throw new ResolveFailedException();
					}
					return bytes.get(index);
				} 
				
			};
			addChild(result);
			return result;
		}
		
	}

	private DBytes dbytes;
	private DObject<Byte> b0;
	private DObject<Byte> b1;
	private DObject<Byte> b2;
	private DObject<Byte> b3;
	
	@Before
	public void setUp() throws Exception {
		dbytes = new DBytes();
		b0 = dbytes.get(0);
		b1 = dbytes.get(1);
		b2 = dbytes.get(2);
		b3 = dbytes.get(3);
	}

	@Test
	public final void testAddChildAndValueResolved() {
		dbytes.add((byte) 0);
		dbytes.add((byte) 1);
		dbytes.add((byte) 2);
		dbytes.add((byte) 3);
		try {
			List<Byte> bytes = dbytes.resolve();
			assertEquals(bytes.size(), 4);
			assertEquals(b0.resolve(), bytes.get(0));
			assertEquals(b1.resolve(), bytes.get(1));
			assertEquals(b2.resolve(), bytes.get(2));
			assertEquals(b3.resolve(), bytes.get(3));			
		} catch (ResolveFailedException e) {
			fail();
		}
	}

	@Test
	public final void testAddChildAndValueResolvedFail() {
		dbytes.add((byte) 0);
		dbytes.add((byte) 1);
		dbytes.add((byte) 2);
		try {
			dbytes.resolve();
			fail();
		} catch (ResolveFailedException e) {
			fail();
		} catch (RuntimeException e) {
			assertFalse(b3.isResolved());
		}
	}

}
