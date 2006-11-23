package ru.ifmo.rain.breslav.deferred.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ru.ifmo.rain.breslav.deferred.DArray;
import ru.ifmo.rain.breslav.deferred.DObjectNullPossible;
import ru.ifmo.rain.breslav.deferred.ResolveFailedException;

public class TestDArray {

	private static final int SIZE = 3;
	private DArray<Integer> darr;
	private DObjectNullPossible<Integer> b0;
	private DObjectNullPossible<Integer> b1;
	private DObjectNullPossible<Integer> b2;

	@Before
	public void setUp() throws Exception {
		darr = new DArray<Integer>(new Integer[SIZE]);
		b0 = darr.get(0);
		b1 = darr.get(1);
		b2 = darr.get(2);
	}

	@Test
	public final void testGet() {
		assertSame(darr.get(0), b0);
	}

	@Test
	public final void testGetFail() {
		try {
			darr.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {			
		}
		try {
			darr.get(SIZE);
			fail();
		} catch (IndexOutOfBoundsException e) {			
		}
	}

	@Test
	public final void testSet() throws ResolveFailedException {
		Integer[] values = setAllAndResolve();
		assertEquals(values.length, SIZE);
		for (int i = 0; i < values.length; i++) {
			assertEquals(values[i], i);
		}
	}

	private Integer[] setAllAndResolve() throws ResolveFailedException {
		darr.set(0, 0);
		darr.set(1, 1);
		darr.set(2, 2);
		Integer[] values = darr.resolve();
		return values;
	}

	@Test
	public final void testSetFail() {
		try {
			darr.set(-1, 0);
			fail();
		} catch (IndexOutOfBoundsException e) {			
		}
		try {
			darr.set(SIZE, 0);
			fail();
		} catch (IndexOutOfBoundsException e) {			
		}
	}

	@Test
	public final void testLength() {
		assertEquals(darr.length(), 3);
	}

	@Test
	public final void testValueResolved() throws ResolveFailedException {
		assertFalse(b0.isResolved());
		assertFalse(b1.isResolved());
		assertFalse(b2.isResolved());
		setAllAndResolve();
		assertTrue(b0.isResolved());
		assertTrue(b1.isResolved());
		assertTrue(b2.isResolved());
	}

	@Test
	public final void testResolve() {
		try {
			setAllAndResolve();
			assertTrue(darr.isResolved());
		} catch (ResolveFailedException e) {
			fail();
		}		
	}

	@Test
	public final void testIsResolved() {
		assertFalse(darr.isResolved());
	}

	@Test
	public final void testValues() throws ResolveFailedException {
		setAllAndResolve();
		assertEquals(b0.resolve(), 0);
		assertEquals(b1.resolve(), 1);
		assertEquals(b2.resolve(), 2);
	}

	@Test
	public final void testValuesNulls() throws ResolveFailedException {
		darr.set(0, 0);
		darr.set(2, 2);
		darr.resolve();
		assertEquals(b0.resolve(), 0);
		assertTrue(b0.isResolved());
		assertSame(b1.resolve(), null);
		assertTrue(b1.isResolved());
		assertEquals(b2.resolve(), 2);
		assertTrue(b2.isResolved());
	}

	@Test
	public final void testSetAfterResolve() throws ResolveFailedException {
		darr.resolve();
		try {
			darr.set(0, 0);
			fail();
		} catch (IllegalStateException e) {			
		}
	}

	@Test
	public final void testGetAfterResolve() throws ResolveFailedException {
		darr = new DArray<Integer>(new Integer[3]);
		darr.set(0, 0);
		darr.set(1, 1);
		darr.set(2, null);
		darr.resolve();
		assertEquals(0, darr.get(0).resolve());
		assertEquals(1, darr.get(1).resolve());
		assertEquals(null, darr.get(2).resolve());
	}
}
