package runtime.tree.expressions;

import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import util.SafeArray;
import core.IFunction;
import core.IType;

public class FunctionCall extends MemberAccess {

	private final IFunction myFunction;
	private final SafeArray<IExpressionNode> myArguments;
	
	/**
	 * WARNING!!! Array of arguments is not cloned inside
	 */
	public FunctionCall(IExpressionNode hostObject, IFunction function,
			IExpressionNode... arguments) {
		super(hostObject);
		myFunction = function;
		myArguments = new SafeArray<IExpressionNode>(arguments.clone());
	}
	
	public SafeArray<IExpressionNode> getArguments() {
		return myArguments;
	}
	
	public IFunction getFunction() {
		return myFunction;
	}
	
	public IType getType() {
		return myFunction.getReturnType();
	}
	
	public <R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor) {
		return visitor.visitFuctionCallNode(this);
	}

}
