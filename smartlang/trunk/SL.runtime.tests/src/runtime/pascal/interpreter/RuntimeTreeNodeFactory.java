package runtime.pascal.interpreter;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import runtime.tree.IExpressionNode;
import runtime.tree.ILeftValueNode;
import runtime.tree.IStatementNode;
import runtime.tree.IVisitHandler;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import runtime.tree.expressions.InstanceAccess;
import runtime.tree.statements.Assignment;
import runtime.tree.statements.Block;
import runtime.tree.statements.If;
import runtime.tree.statements.While;
import core.IField;
import core.IGenericFunction;

public class RuntimeTreeNodeFactory {
	public static final RuntimeTreeNodeFactory INSTANCE = new RuntimeTreeNodeFactory();
	
	private RuntimeTreeNodeFactory() {
	}
	
	public FieldAccess createFieldAccess(IExpressionNode hostObject, IField field) {
		return new FieldAccess(hostObject, field);
	}
	
	public FunctionCall createFunctionCall(IExpressionNode hostObject, IGenericFunction function,
			IExpressionNode... arguments) {
		return new FunctionCall(hostObject, function, arguments);
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
		result.setVisitHandler(handler);
		return result;
	}

	public Assignment createAssignment(IVisitHandler handler, ILeftValueNode arg0, IExpressionNode arg1) {
		Assignment result = createAssignment(arg0, arg1);
		result.setVisitHandler(handler);
		return result;
	}

	public If createIf(IVisitHandler handler, IExpressionNode arg0, IStatementNode arg1, IStatementNode arg2) {
		If result = createIf(arg0, arg1, arg2);
		result.setVisitHandler(handler);
		return result;
	}

	public While createWhile(IVisitHandler handler, IExpressionNode arg0, IStatementNode arg1) {
		While result = createWhile(arg0, arg1);
		result.setVisitHandler(handler);
		return result;
	}
	
	public static <T extends IStatementNode> T addHandler(T node, IVisitHandler handler) {
		node.setVisitHandler(handler);
		return node;
	}
	
	public static void main(String[] args) {
		Class<RuntimeTreeNodeFactory> theClass = RuntimeTreeNodeFactory.class;
		StringTemplateGroup stg = new StringTemplateGroup("Some", ".");
		for (Method m : theClass.getDeclaredMethods()) {
			if (m.getName().startsWith("create")) {
				StringTemplate st = stg.getInstanceOf("method");
				st.setAttribute("m", m);
				int i = 0;
				ArrayList<String> params = new ArrayList<String>();
				ArrayList<String> argums = new ArrayList<String>();
				for (Class<?> type : m.getParameterTypes()) {
					params.add(type.getSimpleName() + " arg" + i);
					argums.add("arg" + i);
					i++;
				}
				st.setAttribute("parameters", params);
				st.setAttribute("arguments", argums);
				System.out.println(st);
			}
		}
		
	}
}
