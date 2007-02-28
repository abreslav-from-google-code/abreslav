package ru.amse.sd.mvc.onetomany;

import java.util.Collection;
import java.util.LinkedHashSet;

import ru.amse.sd.mvc.onetoone.DataArray;

public class NotifyingDataArray extends DataArray {

	private final Collection<DataChangedListener> listeners = new LinkedHashSet<DataChangedListener>();
	
	public void addDataChangedListener(DataChangedListener listener) {
		listeners.add(listener);
	}
	
	public void removeDataChangedListener(DataChangedListener listener) {
		listeners.remove(listener);
	}
	
	public void fireDataChanged() {
		for (DataChangedListener listener : listeners) {
			listener.dataChanged();
		}
	}
	
	@Override
	public void add(int value) {
		super.add(value);
		fireDataChanged();
	}
	
	@Override
	public void set(int index, int value) throws IndexOutOfBoundsException {
		super.set(index, value);
		fireDataChanged();
	}
	
	
}
