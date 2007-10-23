package runtime.tree.expressions;

import runtime.tree.ExpressionNode;
import runtime.tree.IExpressionNodeVisitor;

public class InstanceAccess extends ExpressionNode {

	private final int myId;
	
	public InstanceAccess(int id) {
		myId = id;
	}

	public <R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor) {
		return visitor.visitInstanceAccess(this);
	}

	public int getId() {
		return myId;
	}
}
