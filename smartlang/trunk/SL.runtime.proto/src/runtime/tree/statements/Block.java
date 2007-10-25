package runtime.tree.statements;

import runtime.tree.IStatementNode;
import runtime.tree.IStatementNodeVisitor;
import runtime.tree.StatementNode;
import util.IArray;
import util.SafeArray;


public class Block extends StatementNode {

	private final SafeArray<IStatementNode> myStatements;
	
	public Block(IStatementNode... children) {
		myStatements = new SafeArray<IStatementNode>(children.clone());
	}
	
	public <R> R acceptStatementNodeVisitor(IStatementNodeVisitor<R> visitor) {
		return visitor.visitCompoundNode(this);		
	}
	
	public IArray<IStatementNode> getStatements() {
		return myStatements;
	}

}
