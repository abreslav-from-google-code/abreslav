package evaluator;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tokenizer {

	private enum State {
		START {
			
			private final Map<Character, Token> char2token = new HashMap<Character, Token>();
			{	
				char2token.put('+', Operation.PLUS);
				char2token.put('-', Operation.MINUS);
				char2token.put('*', Operation.TIMES);
				char2token.put('/', Operation.DIVIDE);
				char2token.put('(', Brace.LEFT);
				char2token.put(')', Brace.RIGHT);
			}

			public State performAction(int c, Tokenizer tokenizer)
					throws IOException {
				switch (c) {
				case -1:
					return END;
				case '-':
				case '+':
				case '*':
				case '/':
				case '(':
				case ')':
					tokenizer.addToken(char2token.get((char) c));
					tokenizer.next();
					return START;
				default:
					if (Character.isDigit(c)) {
						return NUMBER;
					}
					if (!Character.isWhitespace(c)) {
						return ERROR;
					}
					return START;
				}
			}
		},

		NUMBER {
			private int data;

			public State performAction(int c, Tokenizer tokenizer)
					throws IOException {
				if (!Character.isDigit(c)) {
					tokenizer.addToken(NumberToken.getToken(data));
					data = 0;
					return START;
				}
				data = data * 10 + (c - '0');
				tokenizer.next();
				return NUMBER;
			}
		},

		ERROR,
		END;
		
		public State performAction(int c, Tokenizer tokenizer)
				throws IOException {
			return this;
		}
	}
	
	public static List<Token> tokenize(Reader r) throws IOException {
		return new Tokenizer(r).getTokens();
	}

	private List<Token> tokens;

	private final Reader reader;

	private int cur;

	private Tokenizer(Reader r) {
		reader = r;
	}

	private void next() throws IOException {
		cur = reader.read();
	}	

	private void addToken(Token token) {
		tokens.add(token);
	}

	private List<Token> getTokens() throws IOException {
		if (tokens != null) {
			return tokens;
		}
		tokens = new ArrayList<Token>();

		State state = State.START;
		next();

		while (state != State.END && state != State.ERROR) {
			state = state.performAction(cur, this);
		}

		if (state == State.ERROR) {
			throw new IllegalArgumentException((char) cur + "");
		}

		return tokens;
	}

}
