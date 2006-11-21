package contract;

public interface Stack {

	public static aspect StackContractAspect {
		protected pointcut pop(Stack stack) : execution(* pop()) && target(stack);
		protected pointcut push(Stack stack, Object value) : execution(* push(*)) && target(stack) && args(value);
		
		Object around(Stack stack) : pop(stack) {
			assert !stack.isEmpty();
			int s = stack.size();
			Object result = proceed(stack);
			assert stack.size() == s - 1;
			return result;
		}
		
		void around(Stack stack, Object value) : push(stack, value) {
			int s = stack.size();
			proceed(stack, value);
			assert !stack.isEmpty();
			assert stack.size() == s + 1 : stack.size() + "";
			assert stack.peek() == value;
		}
		
	}
	
	void push(Object value);
	Object pop();
	Object peek();
	boolean isEmpty();
	int size();
	
}
