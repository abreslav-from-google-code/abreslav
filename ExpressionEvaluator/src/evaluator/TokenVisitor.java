/**
 * 
 */
package evaluator;

interface TokenVisitor {
	void visit(NumberToken token);
	void visit(Brace token);
	void visit(Operation token);
}