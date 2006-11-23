package ru.ifmo.rain.breslav.deferred.tests;


import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import ru.ifmo.rain.breslav.deferred.DObject;
import ru.ifmo.rain.breslav.deferred.ResolveFailedException;

public class TestDObject {

	private final class ResolvableString extends DObject<String> {
		@Override
		protected String doResolve() throws ResolveFailedException {
			return RESOLVED;
		}
		
		@Override
		protected void valueResolved(String v) {
			flag = v;
		}
	}

	private final class NotResolvableString extends DObject<String> {
		@Override
		protected String doResolve() throws ResolveFailedException {
			throw new ResolveFailedException();
		}
	}

	private static final String RESOLVED = "resolved";
	private DObject<String> dstr;
	private DObject<String> nrstr;
	public String flag;

	@Before
	public void setUp() throws Exception {
		dstr = new ResolvableString();
		nrstr = new NotResolvableString();
		flag = null;
	}

	@Test
	public void testIsResolved() throws Exception {
		assertFalse(nrstr.isResolved());
		assertFalse(dstr.isResolved());
	}
	
	@Test
	public void testResolve() throws Exception {
		String string = dstr.resolve();
		assertEquals(string, RESOLVED);
		assertTrue(dstr.isResolved());
	}
	
	@Test
	public void testResolveFailed() throws Exception {
		try {
			nrstr.resolve();
			fail();
		} catch (ResolveFailedException e) {
			assertFalse(nrstr.isResolved());
		}
	}
	
	@Test
	public void testValueResolved() throws Exception {
		// valueResolved sets the flag field to it's argument 
		String string = dstr.resolve();
		assertEquals(string, flag);
	}
	
	@Test
	public void testValueResolvedFailed() throws Exception {
		// valueResolved sets the flag field to it's argument 
		try {
			nrstr.resolve();
		} catch (ResolveFailedException e) {
			assertSame(null, flag);
		}
	}
	
}
