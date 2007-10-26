package runtime.tree;

public interface IStatementNode extends IRuntimeTreeNode {
	<R> R acceptStatementNodeVisitor(IStatementNodeVisitor<R> visitor);
	
	void setBeforeVisitHandler(IVisitHandler handler);
	IVisitHandler getBeforeVisitHandler();
	
	void setAfterVisitHandler(IVisitHandler handler);
	IVisitHandler getAfterVisitHandler();
}
