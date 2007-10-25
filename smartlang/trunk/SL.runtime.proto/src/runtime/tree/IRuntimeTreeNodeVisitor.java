package runtime.tree;


public interface IRuntimeTreeNodeVisitor<R> {

	R visitStatementNode(StatementNode node);

	R visitExpressionNode(ExpressionNode node);

}
