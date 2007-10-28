package runtime.contexts;

import core.Instance;

public class StackFrame {
	private final Instance[] myInstances;

	public StackFrame(int size) {
		myInstances = new Instance[size];
	}
	
	public Instance getInstance(int index) {
		return myInstances[index];
	}
	
	public void setInstance(int index, Instance instance) {
		myInstances[index] = instance;
	}
}
