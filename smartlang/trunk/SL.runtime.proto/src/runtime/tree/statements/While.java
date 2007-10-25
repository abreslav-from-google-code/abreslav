package runtime.tree.statements;

import runtime.tree.IExpressionNode;
import runtime.tree.IStatementNode;
import runtime.tree.IStatementNodeVisitor;

public class While extends OperatorWithCondition {

	private final IStatementNode myBody;
	
	public While(IExpressionNode condition, IStatementNode body) {
		super(condition);
		myBody = body;
	}

	public IStatementNode getBody() {
		return myBody;
	}
	
	public <R> R acceptStatementNodeVisitor(IStatementNodeVisitor<R> visitor) {
		return visitor.visitWhileNode(this);
	}

}
