package runtime.tree;

import runtime.tree.statements.Assignment;
import runtime.tree.statements.Block;
import runtime.tree.statements.If;
import runtime.tree.statements.While;

public interface IStatementNodeVisitor<R> {
	R visitCompoundNode(Block node);

	R visitIfNode(If node);

	R visitWhileNode(While node);

	R visitAssignmentNode(Assignment node);

}
