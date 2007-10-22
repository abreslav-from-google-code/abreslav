package runtime.tree;

import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;

public interface IExpressionNodeVisitor<R> {
	R visitFuctionCallNode(FunctionCall node);
	R visitFieldAccessNode(FieldAccess node);
}
