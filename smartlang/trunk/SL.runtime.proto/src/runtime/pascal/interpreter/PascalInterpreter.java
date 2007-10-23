package runtime.pascal.interpreter;

import pascal.types.BooleanType;
import runtime.IEvaluatorContext;
import runtime.tree.IStatementNode;
import runtime.tree.IStatementNodeVisitor;
import runtime.tree.statements.Assignment;
import runtime.tree.statements.Block;
import runtime.tree.statements.If;
import runtime.tree.statements.While;
import util.IArray;
import core.Instance;

public class PascalInterpreter implements IStatementNodeVisitor<Void> {

	private final PascalExpressionEvaluator myExpressionEvaluator;
	
	public PascalInterpreter(IEvaluatorContext evaluatorContext) {
		myExpressionEvaluator = new PascalExpressionEvaluator(evaluatorContext);
	}

	public Void visitCompoundNode(Block node) {
		IArray<IStatementNode> statements = node.getStatements();
		for (int i = 0; i < statements.size(); i++) {
			execute(statements.get(i));
		}
		return null;
	}

	public Void visitIfNode(If node) {
		Instance condition = myExpressionEvaluator.evaluate(node.getCondition());
		if (BooleanType.BOOLEAN.readBooleanValue(condition)) {
			execute(node.getThen());
		} else { 
			if (node.getElse() != null ) {
				execute(node.getElse());
			}
		}
		return null;
	}

	public Void visitAssignmentNode(Assignment node) {
		Instance rValue = myExpressionEvaluator.evaluate(node.getRValue());
		Instance lValueHost = myExpressionEvaluator.evaluate(node.getLValue().getHostObject());
		node.getLValue().getField().writeValue(lValueHost, rValue);
		return null;
	}

	public Void visitWhileNode(While node) {
		while (true) {
			Instance condition = myExpressionEvaluator.evaluate(node.getCondition());
			if (!BooleanType.BOOLEAN.readBooleanValue(condition)) {
				break;
			} 
			execute(node.getBody());
		}
		return null;
	}

	public void execute(IStatementNode node) {
		if (node.getVisitHandler() != null) {
			node.getVisitHandler().run();
		}
		node.acceptStatementNodeVisitor(this);
	}
}
