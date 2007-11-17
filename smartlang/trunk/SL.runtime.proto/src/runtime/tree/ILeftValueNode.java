package runtime.tree;

import core.IGenericField;

public interface ILeftValueNode extends IExpressionNode {
	IGenericField getField();
	IExpressionNode getHostObject();
}
