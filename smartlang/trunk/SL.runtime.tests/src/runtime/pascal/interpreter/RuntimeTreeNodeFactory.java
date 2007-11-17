package runtime.pascal.interpreter;

import runtime.tree.IExpressionNode;
import runtime.tree.ILeftValueNode;
import runtime.tree.IStatementNode;
import runtime.tree.IVisitHandler;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.InstanceAccess;
import runtime.tree.expressions.NativeFunctionCall;
import runtime.tree.statements.Assignment;
import runtime.tree.statements.Block;
import runtime.tree.statements.If;
import runtime.tree.statements.While;
import core.IGenericField;
import core.IGenericFunction;

public class RuntimeTreeNodeFactory {
	public static final RuntimeTreeNodeFactory INSTANCE = new RuntimeTreeNodeFactory();
	
	private RuntimeTreeNodeFactory() {
	}
	
	public FieldAccess createFieldAccess(IExpressionNode hostObject, IGenericField field) {
		return new FieldAccess(hostObject, field);
	}
	
	public NativeFunctionCall createFunctionCall(IExpressionNode hostObject, IGenericFunction function,
			IExpressionNode... arguments) {
		return new NativeFunctionCall(hostObject, function, arguments);
	}
	
	public InstanceAccess createInstanceAccess(int id) {
		return new InstanceAccess(id);
	}
	
	public Block createBlock(IStatementNode... children) {
		return new Block(children);
	}
	
	public Assignment createAssignment(ILeftValueNode lValue, IExpressionNode rValue) {
		return new Assignment(lValue, rValue);
	}
	
	public If createIf(IExpressionNode condition, IStatementNode then,
			IStatementNode elze) {
		return new If(condition, then, elze);
	}
	
	public While createWhile(IExpressionNode condition, IStatementNode body) {
		return new While(condition, body);
	}
	
	public Block createBlock(IVisitHandler handler, IStatementNode[] arg0) {
		Block result = createBlock(arg0);
		result.setBeforeVisitHandler(handler);
		return result;
	}

	public Assignment createAssignment(IVisitHandler handler, ILeftValueNode arg0, IExpressionNode arg1) {
		Assignment result = createAssignment(arg0, arg1);
		result.setBeforeVisitHandler(handler);
		return result;
	}

	public If createIf(IVisitHandler handler, IExpressionNode arg0, IStatementNode arg1, IStatementNode arg2) {
		If result = createIf(arg0, arg1, arg2);
		result.setBeforeVisitHandler(handler);
		return result;
	}

	public While createWhile(IVisitHandler handler, IExpressionNode arg0, IStatementNode arg1) {
		While result = createWhile(arg0, arg1);
		result.setBeforeVisitHandler(handler);
		return result;
	}
	
	private static final class CompositeHandler implements IVisitHandler {

		private final IVisitHandler myFirst;
		private final IVisitHandler mySecond;
		
		public CompositeHandler(IVisitHandler first, IVisitHandler second) {
			super();
			myFirst = first;
			mySecond = second;
		}

		public void run() {
			myFirst.run();
			mySecond.run();
		}
		
	}
	
	public static <T extends IStatementNode> T addBeforeHandler(T node, IVisitHandler handler) {
		if (node.getBeforeVisitHandler() != IVisitHandler.NOTHING) {
			handler = new CompositeHandler(node.getBeforeVisitHandler(), handler);
		}
		node.setBeforeVisitHandler(handler);
		return node;
	}
	
	public static <T extends IStatementNode> T addAfterHandler(T node, IVisitHandler handler) {
		if (node.getAfterVisitHandler() != IVisitHandler.NOTHING) {
			handler = new CompositeHandler(node.getAfterVisitHandler(), handler);
		}
		node.setAfterVisitHandler(handler);
		return node;
	}
	
}
