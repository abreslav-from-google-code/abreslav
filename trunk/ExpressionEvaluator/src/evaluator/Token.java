package evaluator;

interface Token {
	String toString();
	void accept(TokenVisitor visitor);
}
