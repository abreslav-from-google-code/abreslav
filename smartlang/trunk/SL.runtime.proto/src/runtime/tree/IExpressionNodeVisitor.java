package runtime.tree;

import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import runtime.tree.expressions.InstanceAccess;

public interface IExpressionNodeVisitor<R> {
	R visitFuctionCallNode(FunctionCall node);
	R visitFieldAccessNode(FieldAccess node);
	R visitInstanceAccess(InstanceAccess node);
	R visitUnknownClass(IExpressionNode node);
}
