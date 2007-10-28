package runtime.pascal.interpreter;

import runtime.contexts.IEvaluatorContext;
import runtime.contexts.StackFrame;
import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import runtime.tree.expressions.CurrentStackFrameAccess;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import runtime.tree.expressions.InstanceAccess;
import runtime.tree.expressions.NativeFunctionCall;
import core.Instance;
import core.NoSuch;

public class PascalExpressionEvaluator implements IExpressionNodeVisitor<Instance> {

	private final IEvaluatorContext myContext;
	private final PascalInterpreter myInterpreter;

	public PascalExpressionEvaluator(IEvaluatorContext context, PascalInterpreter pascalInterpreter) {
		myContext = context;
		myInterpreter = pascalInterpreter;
	}
	
	public Instance visitFieldAccessNode(FieldAccess node) {
		return node.getField().readValue(evaluate(node.getHostObject()));
	}

	public Instance visitNativeFuctionCallNode(NativeFunctionCall node) {
		Instance[] args = new Instance[node.getArguments().size()];
		for (int i = 0; i < node.getArguments().size(); i++) {
			args[i] = evaluate(node.getArguments().get(i));
		}
		return node.getFunction().run(evaluate(node.getHostObject()), args);
	}

	public Instance visitInstanceAccess(InstanceAccess node) {
		return myContext.getInstance(node.getId());
	}
	
	public Instance visitCurrentStackFrameAccessNode(
			CurrentStackFrameAccess node) {
		return myContext.getCurrentStackFrame();
	}

	public Instance visitFunctionCallNode(FunctionCall node) {
		StackFrame stackFrame = buildStackFrame(node);
		myContext.pushStackFrame(stackFrame);
		myInterpreter.execute(node.getFunctionBody());
		myContext.popStackFrame();
		return obtainReturnValue(node, stackFrame);
	}

	private StackFrame buildStackFrame(FunctionCall node) {
		int stackFrameSize = node.getArguments().size();

		// Function's return value is finally written to the 
		// last position in the stack frame
		// also known as Result argument
		if (node.hasReturnValue()) {
			stackFrameSize++;
		}

		StackFrame stackFrame = new StackFrame(stackFrameSize);
		for (int i = 0; i < stackFrameSize; i++) {
			stackFrame.setInstance(i, evaluate(node.getArguments().get(i)));
		}
		
		return stackFrame;
	}
	
	private Instance obtainReturnValue(FunctionCall node, StackFrame stackFrame) {
		return node.hasReturnValue() 
			? stackFrame.getInstance(node.getArguments().size()) 
			: NoSuch.INSTANCE;
	}
	
	public Instance visitUnknownClass(IExpressionNode node) {
		return null;
	}
	
	/**
	 * Evaluates the expression using this evaluator
	 * @param expression
	 * @return it's value
	 */
	public Instance evaluate(IExpressionNode expression) {
		return expression.acceptExpressionNodeVisitor(this);
	}
}