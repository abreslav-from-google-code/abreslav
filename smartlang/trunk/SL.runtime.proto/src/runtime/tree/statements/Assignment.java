package runtime.tree.statements;

import runtime.tree.IExpressionNode;
import runtime.tree.ILeftValueNode;
import runtime.tree.IStatementNodeVisitor;
import runtime.tree.StatementNode;


public class Assignment extends StatementNode {

	private final ILeftValueNode myLValue;
	private final IExpressionNode myRValue;
	
	public Assignment(ILeftValueNode lValue, IExpressionNode rValue) {
		myLValue = lValue;
		myRValue = rValue;
	}

	public ILeftValueNode getLValue() {
		return myLValue;
	}
	
	public IExpressionNode getRValue() {
		return myRValue;
	}

	public <R> R acceptStatementNodeVisitor(IStatementNodeVisitor<R> visitor) {
		return visitor.visitAssignmentNode(this);
	}

}
