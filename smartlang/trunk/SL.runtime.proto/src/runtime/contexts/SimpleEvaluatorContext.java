package runtime.contexts;

import java.util.ArrayList;

import core.Instance;

public class SimpleEvaluatorContext implements IEvaluatorContext {

	private final ArrayList<Instance> myInstances = new ArrayList<Instance>();
	private final ArrayList<Instance> myStackFrames = new ArrayList<Instance>();
	
	public Instance getInstance(int id) {
		return myInstances.get(id);
	}

	public int addInstance(Instance instance) {
		myInstances.add(instance);
		return myInstances.size() - 1;
	}

	public Instance pushStackFrame(StackFrame stackFrame) {
		Instance stackFrameInstance = StackFrameType.STACK_FRAME.createInstance(stackFrame);
		myStackFrames.add(stackFrameInstance);
		return stackFrameInstance;
	}
	
	public Instance getCurrentStackFrame() {
		return myStackFrames.get(myStackFrames.size() - 1);
	}

	public void popStackFrame() {
		myStackFrames.remove(myStackFrames.size() - 1);
	}
}
