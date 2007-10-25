package runtime.tree;


public interface IExpressionNode extends IRuntimeTreeNode {
	<R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor);
}
