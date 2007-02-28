package ru.amse.sd.mvc.onetoone;

import java.util.ArrayList;

public class DataArray {

	private final ArrayList<Integer> data = new ArrayList<Integer>();
	
	public int size() {
		return data.size();		
	}
	
	public void add(int value) {
		data.add(value);
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public int get(int index) throws IndexOutOfBoundsException {
		return data.get(index);
	}
	
	public void set(int index, int value) throws IndexOutOfBoundsException {
		data.set(index, value);
	}
}
