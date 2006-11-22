package evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Parser {

	/*
	 * Unused. Bad style
	 */
	protected static int getPriority(Token t) {
		if (t instanceof Brace) {
			switch ((Brace) t) {
			case LEFT:
				return 0;
			case RIGHT:
				return 10;
			}
		} else if (t instanceof Operation) {
			switch ((Operation) t) {
			case DIVIDE:
			case TIMES:
				return 1;
			case MINUS:
			case PLUS:
				return 2;
			}
		} else if (t instanceof NumberToken) {
			return 3;
		}
		throw new IllegalArgumentException();
	}
	
	private static class ParserVisitor implements TokenVisitor {
		private final Stack<Token> stack;
		private final List<Token> out;
		
		public ParserVisitor(Stack<Token> stack, List<Token> out) {
			this.stack = stack;
			this.out = out;
		}
		
		public void visit(NumberToken token) {
			out.add(token);
		}

		public void visit(Brace token) {
			if (token == Brace.LEFT) {
				stack.push(token);
			} else {
				while (stack.peek() != Brace.LEFT) {
					out.add(stack.pop());
				}
				stack.pop();
			}
		}

		public void visit(Operation token) {
			while (!stack.isEmpty() 
					// stack.peek().getClass() == Operation.class   -- is possible too 
					&& stack.peek() instanceof Operation 
					&& ((Operation) stack.peek()).getPriority() >= token.getPriority()) {
				out.add(stack.pop());				
			}
			stack.push(token);
		}
		
	}
	
	public static List<Token> parse(List<Token> in) {
		List<Token> out = new ArrayList<Token>();
		Stack<Token> stack = new Stack<Token>();
		ParserVisitor pv = new ParserVisitor(stack, out);
		for (Token token : in) {
			token.accept(pv);
		}
		while (!stack.isEmpty()) {
			out.add(stack.pop());
		}
		return out;
	}
}
