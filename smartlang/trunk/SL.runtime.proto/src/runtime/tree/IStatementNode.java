package runtime.tree;

public interface IStatementNode extends IRuntimeTreeNode {
	<R> R acceptStatementNodeVisitor(IStatementNodeVisitor<R> visitor);
	
	void setVisitHandler(IVisitHandler handler);
	IVisitHandler getVisitHandler();
}
