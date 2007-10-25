package runtime;

import runtime.tree.ExpressionNode;
import runtime.tree.IExpressionNode;
import runtime.tree.IExpressionNodeVisitor;
import runtime.tree.IRuntimeTreeNode;
import runtime.tree.IRuntimeTreeNodeVisitor;
import runtime.tree.IStatementNode;
import runtime.tree.IStatementNodeVisitor;
import runtime.tree.StatementNode;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import runtime.tree.expressions.InstanceAccess;
import runtime.tree.statements.Assignment;
import runtime.tree.statements.Block;
import runtime.tree.statements.If;
import runtime.tree.statements.While;

public abstract class RuntimeTreeTraverser {
	
	private final IRuntimeTreeNodeVisitor<Void> myNodeVisitor = new IRuntimeTreeNodeVisitor<Void>() {

		public Void visitExpressionNode(ExpressionNode node) {
			return node.acceptExpressionNodeVisitor(myExpressionNodeVisitor);
		}

		public Void visitStatementNode(StatementNode node) {
			return node.acceptStatementNodeVisitor(myStatementNodeVisitor);
		}
		
	};
	
	private final IExpressionNodeVisitor<Void> myExpressionNodeVisitor = new IExpressionNodeVisitor<Void>() {

		public Void visitFieldAccessNode(FieldAccess node) {
			if (visitExpression(node)) {
				return null;
			}
			node.getHostObject().acceptExpressionNodeVisitor(this);
			return null;
		}

		public Void visitFuctionCallNode(FunctionCall node) {
			if (visitExpression(node)) {
				return null;
			}
			node.getHostObject().acceptExpressionNodeVisitor(this);
			for (int i = 0; i < node.getArguments().size(); i++) {
				node.getArguments().get(i).acceptExpressionNodeVisitor(this);
			}
			return null;
		}

		public Void visitInstanceAccess(InstanceAccess node) {
			visitExpression(node);
			return null;
		}

		public Void visitUnknownClass(IExpressionNode node) {
			visitExpression(node);
			return null;
		}
		
	};
	
	private final IStatementNodeVisitor<Void> myStatementNodeVisitor = new IStatementNodeVisitor<Void>() {

		public Void visitAssignmentNode(Assignment node) {
			if (visitStatement(node)) {
				return null;
			}
			node.getLValue().acceptExpressionNodeVisitor(myExpressionNodeVisitor);
			node.getRValue().acceptExpressionNodeVisitor(myExpressionNodeVisitor);
			return null;
		}

		public Void visitCompoundNode(Block node) {
			if (visitStatement(node)) {
				return null;
			}
			for (int i = 0; i < node.getStatements().size(); i++) {
				node.getStatements().get(i).acceptStatementNodeVisitor(this);
			}
			return null;
		}

		public Void visitIfNode(If node) {
			if (visitStatement(node)) {
				return null;
			}
			node.getCondition().acceptExpressionNodeVisitor(myExpressionNodeVisitor);
			node.getThen().acceptStatementNodeVisitor(this);
			if (node.getElse() != null) {
				node.getElse().acceptStatementNodeVisitor(this);
			}
			return null;
		}

		public Void visitWhileNode(While node) {
			if (visitStatement(node)) {
				return null;
			}
			node.getCondition().acceptExpressionNodeVisitor(myExpressionNodeVisitor);
			node.getBody().acceptStatementNodeVisitor(this);
			return null;
		}
		
	};
	
	public void traverse(IRuntimeTreeNode node) {
		node.accept(myNodeVisitor);
	}
	
	protected abstract boolean visitStatement(IStatementNode node);
	protected abstract boolean visitExpression(IExpressionNode node);
}
