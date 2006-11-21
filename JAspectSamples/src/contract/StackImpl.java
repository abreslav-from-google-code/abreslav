package contract;

public class StackImpl implements Stack {

	private final java.util.Stack<Object> stack = new java.util.Stack<Object>();
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public Object peek() {
		return stack.peek();
	}

	public Object pop() {
		return stack.pop();
	}

	public void push(Object value) {
		stack.push(value);
	}

	public int size() {
		return stack.size();
	}

}
