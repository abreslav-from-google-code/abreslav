package pascal.parser;

public class Variable {
	private final String myType;
	private final String myName;

	public Variable(String type, String name) {
		super();
		myType = type;
		myName = name;
	}

	public String getName() {
		return myName;
	}
	
	public String getType() {
		return myType;
	}
}
