package runtime.tree;

public interface IRuntimeTreeNode {
	<R> R accept(IRuntimeTreeNodeVisitor<R> visitor);
}
