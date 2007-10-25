package runtime.tree.statements;

import runtime.tree.IExpressionNode;
import runtime.tree.IStatementNode;
import runtime.tree.IStatementNodeVisitor;

public class If extends OperatorWithCondition {

	private final IStatementNode myThen;
	private final IStatementNode myElse;
	
	public If(IExpressionNode condition, IStatementNode then,
			IStatementNode elze) {
		super(condition);
		myThen = then;
		myElse = elze;
	}

	public IStatementNode getElse() {
		return myElse;
	}
	
	public IStatementNode getThen() {
		return myThen;
	}
	
	public <R> R acceptStatementNodeVisitor(IStatementNodeVisitor<R> visitor) {
		return visitor.visitIfNode(this);
	}

}
