package runtime.pascal.interpreter;

import runtime.tree.IVisitHandler;

public class VisitCounter implements IVisitHandler {

	private final int myCount;
	private final String myMessage;
	private int myVisits;
	
	public VisitCounter(int count, String message) {
		myCount = count;
		myMessage = message;
	}

	public void run() {
		myVisits++;
	}
	
	public int getVisits() {
		return myVisits;
	}
	
	public int getCount() {
		return myCount;
	}
	
	public String getMessage() {
		return myMessage;
	}
}
