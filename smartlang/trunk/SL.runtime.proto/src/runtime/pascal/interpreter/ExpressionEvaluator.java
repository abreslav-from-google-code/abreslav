package runtime.pascal.interpreter;

import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import core.Instance;

public class ExpressionEvaluator implements IExpressionNodeVisitor<Instance> {

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

	public Instance evaluate(IExpressionNode expression) {
		return expression.acceptExpressionNodeVisitor(this);
	}
}