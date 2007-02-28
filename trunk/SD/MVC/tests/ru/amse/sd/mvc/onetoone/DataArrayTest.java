package ru.amse.sd.mvc.onetoone;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataArrayTest {

	private DataArray dataArray;

	@Before
	public void setUp() {
		dataArray = new DataArray();
		dataArray.add(0);
		dataArray.add(1);
		dataArray.add(2);
	}
	
	@Test
	public void testConstructor() {
		dataArray = new DataArray();
		assertTrue(dataArray.size() == 0);
	}

	@Test
	public void testSize() {
		assertTrue(dataArray.size() == 3);
	}

	@Test
	public void testAdd() {
		assertTrue(dataArray.get(0) == 0);
		assertTrue(dataArray.get(1) == 1);
		assertTrue(dataArray.get(2) == 2);
	}

	@Test
	public void testIsEmptyOnEmpty() {
		assertFalse(dataArray.isEmpty());
	}

	@Test
	public void testIsEmptyOnNonEmpty() {
		dataArray = new DataArray();
		assertTrue(dataArray.isEmpty());
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetFail() {
		dataArray.get(1000);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetFail() {
		dataArray.set(1000, 0);
	}

	@Test
	public void testGetSet() {
		dataArray.set(0, 100);
		assertTrue(dataArray.get(0) == 100);
	}

}
