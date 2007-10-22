package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ArrayIteratorTest {

	@Test
	public void testHasNextOnEmpty() {
		ArrayIterator<Integer> i = new ArrayIterator<Integer>(new Integer[] {});
		assertFalse(i.hasNext());
	}

	@Test
	public void testHasNextOnFirst() {
		ArrayIterator<Integer> i = new ArrayIterator<Integer>(
				new Integer[] { 1 });
		assertTrue(i.hasNext());
	}

	@Test
	public void testHasNextOnLast() {
		ArrayIterator<Integer> i = new ArrayIterator<Integer>(
				new Integer[] { 1 });
		i.next();
		assertFalse(i.hasNext());
	}

	@Test
	public void testHasNextInTheMiddle() {
		ArrayIterator<Integer> i = new ArrayIterator<Integer>(new Integer[] {
				1, 2, 3 });
		i.next();
		assertTrue(i.hasNext());
	}

	@Test
	public void testNext() {
		ArrayIterator<Integer> i = new ArrayIterator<Integer>(new Integer[] {
				1, 2, 3 });
		assertEquals(1, i.next());
		assertEquals(2, i.next());
		assertEquals(3, i.next());
	}

	@Test
	public void testRemove() {
		ArrayIterator<Integer> i = new ArrayIterator<Integer>(new Integer[] {
				1, 2, 3 });
		try {
			i.remove();
			fail();
		} catch (UnsupportedOperationException e) {

		}
	}

}
