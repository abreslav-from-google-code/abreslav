package runtime.tree;

public abstract class StatementNode implements IStatementNode {
	
	private IVisitHandler myVisitHandler;

	public <R> R accept(IRuntimeTreeNodeVisitor<R> visitor) {
		return visitor.visitStatementNode(this);
	}

	public IVisitHandler getVisitHandler() {
		return myVisitHandler;
	}
	
	public void setVisitHandler(IVisitHandler handler) {
		myVisitHandler = handler;
	}
}
