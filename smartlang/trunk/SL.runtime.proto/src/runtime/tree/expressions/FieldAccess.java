package runtime.tree.expressions;

import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import runtime.tree.ILeftValueNode;
import core.IField;
import core.IType;

public class FieldAccess extends MemberAccess implements ILeftValueNode {

	private final IField myField;
	
	public FieldAccess(IExpressionNode hostObject, IField field) {
		super(hostObject);
		myField = field;
	}

	public IField getField() {
		return myField;
	}

	public IType getType() {
		return myField.getFieldType();
	}

	public <R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor) {
		return visitor.visitFieldAccessNode(this);
	}

}