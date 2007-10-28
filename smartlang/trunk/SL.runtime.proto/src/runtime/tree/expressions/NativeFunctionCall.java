package runtime.tree.expressions;

import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import util.SafeArray;
import core.IGenericFunction;

public class NativeFunctionCall extends MemberAccess implements IFunctionCall {

	private final IGenericFunction myFunction;
	private final SafeArray<IExpressionNode> myArguments;
	
	public NativeFunctionCall(IExpressionNode hostObject, IGenericFunction function,
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
		return visitor.visitNativeFuctionCallNode(this);
	}

}
