package runtime.tree.expressions;

import runtime.tree.IExpressionNode;
import util.SafeArray;

public interface IFunctionCall {
	SafeArray<IExpressionNode> getArguments();
	
}
