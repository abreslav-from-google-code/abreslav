package runtime.tree.expressions;

import runtime.tree.ExpressionNode;
import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import runtime.tree.IStatementNode;
import util.SafeArray;

public class FunctionCall extends ExpressionNode implements IFunctionCall {

	private final IStatementNode myFunctionBody;
	private final SafeArray<IExpressionNode> myArguments;
	private final boolean myReturnsValue;

	public FunctionCall(IStatementNode functionBody, boolean returnsValue, IExpressionNode... arguments) {
		myFunctionBody = functionBody;
		myArguments = new SafeArray<IExpressionNode>(arguments.clone());
		myReturnsValue = returnsValue;
	}
	
	public IStatementNode getFunctionBody() {
		return myFunctionBody;
	}
	
	public SafeArray<IExpressionNode> getArguments() {
		return myArguments;
	}
	
	public boolean hasReturnValue() {
		return myReturnsValue;
	}
	
	@Override
	public <R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor) {
		return visitor.visitFunctionCallNode(this);
	}
}
