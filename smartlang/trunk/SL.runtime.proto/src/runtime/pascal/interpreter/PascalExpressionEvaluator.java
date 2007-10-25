package runtime.pascal.interpreter;

import runtime.IEvaluatorContext;
import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import runtime.tree.expressions.InstanceAccess;
import core.Instance;

public class PascalExpressionEvaluator implements IExpressionNodeVisitor<Instance> {

	private final IEvaluatorContext myContext;

	public PascalExpressionEvaluator(IEvaluatorContext context) {
		myContext = context;
	}

	public Instance visitFieldAccessNode(FieldAccess node) {
		return node.getField().readValue(evaluate(node.getHostObject()));
	}

	public Instance visitFuctionCallNode(FunctionCall node) {
		Instance[] args = new Instance[node.getArguments().size()];
		for (int i = 0; i < node.getArguments().size(); i++) {
			args[i] = evaluate(node.getArguments().get(i));
		}
		return node.getFunction().run(evaluate(node.getHostObject()), args);
	}

	public Instance visitInstanceAccess(InstanceAccess node) {
		return myContext.getInstance(node.getId());
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