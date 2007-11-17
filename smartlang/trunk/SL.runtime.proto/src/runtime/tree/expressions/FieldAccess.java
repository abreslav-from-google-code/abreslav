package runtime.tree.expressions;

import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import runtime.tree.ILeftValueNode;
import core.IGenericField;

public class FieldAccess extends MemberAccess implements ILeftValueNode {

	private final IGenericField myField;
	
	public FieldAccess(IExpressionNode hostObject, IGenericField field) {
		super(hostObject);
		myField = field;
	}

	public IGenericField getField() {
		return myField;
	}

	public <R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor) {
		return visitor.visitFieldAccessNode(this);
	}

}