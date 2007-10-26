package runtime.tree;

public abstract class StatementNode implements IStatementNode {
	
	private IVisitHandler myBeforeVisitHandler = IVisitHandler.NOTHING;
	private IVisitHandler myAfterVisitHandler = IVisitHandler.NOTHING;

	public <R> R accept(IRuntimeTreeNodeVisitor<R> visitor) {
		return visitor.visitStatementNode(this);
	}

	public IVisitHandler getBeforeVisitHandler() {
		return myBeforeVisitHandler;
	}
	
	public void setBeforeVisitHandler(IVisitHandler handler) {
		myBeforeVisitHandler = handler;
	}

	public IVisitHandler getAfterVisitHandler() {
		return myAfterVisitHandler;
	}
	
	public void setAfterVisitHandler(IVisitHandler handler) {
		myAfterVisitHandler = handler;
	}
}
