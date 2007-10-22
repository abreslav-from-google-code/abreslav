package runtime.tree;

public abstract class ExpressionNode implements IExpressionNode {

	public <R> R accept(IRuntimeTreeNodeVisitor<R> visitor) {
		return visitor.visitExpressionNode(this);
	}

}
