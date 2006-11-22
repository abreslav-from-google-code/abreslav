package evaluator;

import java.io.IOException;
import java.io.Reader;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Evaluator {

	private static class EvaluatorVisitor implements TokenVisitor {
		private final Stack<Integer> stack;
		
		public EvaluatorVisitor(Stack<Integer> stack) {
			this.stack = stack;
		}

		public void visit(NumberToken token) {
			stack.push(token.getValue());
		}

		public void visit(Brace token) {
			throw new IllegalStateException();
		}

		public void visit(Operation token) {
			Integer y = stack.pop();
			Integer x = stack.pop();
			stack.push(token.perform(x, y));
		}
		
	}
	
	public static int evaluate(Reader input) throws IOException {
		try {
			Stack<Integer> stack = new Stack<Integer>();
			EvaluatorVisitor ev = new EvaluatorVisitor(stack);
			List<Token> tokens = Tokenizer.tokenize(input);
			List<Token> ipn = Parser.parse(tokens);
			
			for (Token token : ipn) {
				token.accept(ev);
			}
			
			return stack.pop();
		} catch (EmptyStackException e) {
			throw new IllegalArgumentException(e);
		} catch (IllegalStateException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
