package runtime.tree.expressions;

import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import util.SafeArray;
import core.IGenericFunction;

public class FunctionCall extends MemberAccess {

	private final IGenericFunction myFunction;
	private final SafeArray<IExpressionNode> myArguments;
	
	/**
	 * WARNING!!! Array of arguments is not cloned inside
	 */
	public FunctionCall(IExpressionNode hostObject, IGenericFunction function,
			IExpressionNode... arguments) {
		super(hostObject);
		myFunction = function;
		myArguments = new SafeArray<IExpressionNode>(arguments.clone());
	}
	
	public SafeArray<IExpressionNode> getArguments() {
		return myArguments;
	}
	
	public IGenericFunction getFunction() {
		return myFunction;
	}
	
	public <R> R acceptExpressionNodeVisitor(IExpressionNodeVisitor<R> visitor) {
		return visitor.visitFuctionCallNode(this);
	}

}
