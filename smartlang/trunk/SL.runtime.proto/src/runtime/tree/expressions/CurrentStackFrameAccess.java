package runtime.tree.expressions;

import runtime.tree.ExpressionNode;
import runtime.tree.IExpressionNodeVisitor;

public class CurrentStackFrameAccess extends ExpressionNode {

	public static final CurrentStackFrameAccess INSTANCE = new CurrentStackFrameAccess();
	
	private CurrentStackFrameAccess() {
	}
	
	@Override
	public <R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor) {
		return visitor.visitCurrentStackFrameAccessNode(this);
	}
	
}
