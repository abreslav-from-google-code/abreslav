package pascal.parser;

public class Constant {
	private final String myValue;
	private final String myType;

	public Constant(String type, String value) {
		super();
		myValue = value;
		myType = type;
	}

	public String getType() {
		return myType;
	}
	
	public String getValue() {
		return myValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myType == null) ? 0 : myType.hashCode());
		result = prime * result + ((myValue == null) ? 0 : myValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Constant other = (Constant) obj;
		if (myType == null) {
			if (other.myType != null)
				return false;
		} else if (!myType.equals(other.myType))
			return false;
		if (myValue == null) {
			if (other.myValue != null)
				return false;
		} else if (!myValue.equals(other.myValue))
			return false;
		return true;
	}
	
	
}
