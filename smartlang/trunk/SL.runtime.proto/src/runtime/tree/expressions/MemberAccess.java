package runtime.tree.expressions;

import runtime.tree.ExpressionNode;
import runtime.tree.IExpressionNode;

public abstract class MemberAccess extends ExpressionNode {

	protected final IExpressionNode myHostObject;

	public MemberAccess(IExpressionNode hostObject) {
		super();
		myHostObject = hostObject;
	}

	public IExpressionNode getHostObject() {
		return myHostObject;
	}

}