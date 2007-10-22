package runtime.tree.statements;

import runtime.tree.IExpressionNode;
import runtime.tree.StatementNode;


public abstract class OperatorWithCondition extends StatementNode {

	private final IExpressionNode myCondition;

	public OperatorWithCondition(IExpressionNode condition) {
		myCondition = condition;
	}

	public IExpressionNode getCondition() {
		return myCondition;
	}
}
