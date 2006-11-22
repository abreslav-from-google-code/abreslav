package evaluator;

enum Operation implements Token {

	PLUS(0) {
		public int perform(int x, int y) {
			return x + y;
		}
	},
	
	MINUS(0) {
		public int perform(int x, int y) {
			return x - y;
		}
	},
	
	TIMES(1) {
		public int perform(int x, int y) {
			return x * y;
		}
	},
	
	DIVIDE(1) {
		public int perform(int x, int y) {
			return x / y;
		}
	};
	
	private final int priority;
	
	private Operation(int p) {
		priority = p;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public abstract int perform(int x, int y);

	public void accept(TokenVisitor visitor) {
		visitor.visit(this);		
	}	
}
