package runtime.contexts;

import core.Instance;

public interface IEvaluatorContext {

	Instance getInstance(int id);
	Instance getCurrentStackFrame();
	Instance pushStackFrame(StackFrame stackFrame);
	void popStackFrame();
}
