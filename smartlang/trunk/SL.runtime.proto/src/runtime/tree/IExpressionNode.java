package runtime.tree;

import core.IType;

public interface IExpressionNode extends IRuntimeTreeNode {
	IType getType();
	<R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor);
}
