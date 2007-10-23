package runtime;

import java.util.ArrayList;

import core.Instance;

public class SimpleEvaluatorContext implements IEvaluatorContext {

	private final ArrayList<Instance> myInstances = new ArrayList<Instance>();
	
	public Instance getInstance(int id) {
		return myInstances.get(id);
	}

	public int addInstance(Instance instance) {
		myInstances.add(instance);
		return myInstances.size() - 1;
	}
}
