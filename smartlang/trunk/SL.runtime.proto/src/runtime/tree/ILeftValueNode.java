package runtime.tree;

import core.IField;

public interface ILeftValueNode extends IExpressionNode {
	IField getField();
	IExpressionNode getHostObject();
}
