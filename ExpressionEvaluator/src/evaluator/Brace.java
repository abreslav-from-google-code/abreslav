package evaluator;

enum Brace implements Token {	
	LEFT,
	RIGHT;

	public void accept(TokenVisitor visitor) {
		visitor.visit(this);		
	}	
}
