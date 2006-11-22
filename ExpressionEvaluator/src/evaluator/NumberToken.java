package evaluator;

class NumberToken implements Token {

	public static NumberToken getToken(int v) {		
		return new NumberToken(v);
	}
	
	private final int value;
	
	private NumberToken(int v) {		
		value = v;		
	}
	
	public int getValue() {
		return value;
	}
	
	public void accept(TokenVisitor visitor) {
		visitor.visit(this);		
	}	

	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	
}
