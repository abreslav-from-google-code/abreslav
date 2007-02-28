package ru.amse.sd.mvc.onetomany;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NotifyingDataArrayTest {

	private NotifyingDataArray data;
	
	@SuppressWarnings("serial")
	private class ListenerPerformedException extends RuntimeException {
	}
	
	private DataChangedListener listener = new DataChangedListener() {
		public void dataChanged() {
			throw new ListenerPerformedException(); 
		}
	};

	@Before
	public void setUp() {
		data = new NotifyingDataArray();
		data.add(1);
		data.addDataChangedListener(listener);
	}
	
	@Test(expected=ListenerPerformedException.class)
	public void testAdd() {
		data.add(1);		
	}

	@Test(expected=ListenerPerformedException.class)
	public void testSet() {
		data.set(0, 1);
	}

	@Test
	public void testRemoveDataChangedListener() {
		data.removeDataChangedListener(listener);
		data.add(1);
		// no exception
	}

	@Test(expected=ListenerPerformedException.class)
	public void testFireDataChanged() {
		data.fireDataChanged();
	}

	@Test
	public void testAddSameListenerTwice() {
		data.addDataChangedListener(listener);
		data.removeDataChangedListener(listener);
		data.add(1);
		// no exception
	}

	@Test
	public void testAddTwoListeners() {
		data = new NotifyingDataArray();
		final boolean flags[] = {false, false};
		data.addDataChangedListener(new DataChangedListener() {
			public void dataChanged() {
				flags[0] = true;
			}
		});
		data.addDataChangedListener(new DataChangedListener() {
			public void dataChanged() {
				flags[1] = true;
			}
		});
		data.add(1);
		assertTrue(flags[0]);
		assertTrue(flags[1]);
	}

}
