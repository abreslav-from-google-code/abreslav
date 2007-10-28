package runtime.tree;

import runtime.tree.expressions.CurrentStackFrameAccess;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import runtime.tree.expressions.NativeFunctionCall;
import runtime.tree.expressions.InstanceAccess;

public interface IExpressionNodeVisitor<R> {
	R visitNativeFuctionCallNode(NativeFunctionCall node);
	R visitFunctionCallNode(FunctionCall node);
	R visitFieldAccessNode(FieldAccess node);
	R visitInstanceAccess(InstanceAccess node);
	R visitCurrentStackFrameAccessNode(CurrentStackFrameAccess node);
	R visitUnknownClass(IExpressionNode node);
}
