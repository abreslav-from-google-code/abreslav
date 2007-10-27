package pascal.parser;

public class Constant {
	private final String myValue;
	private final String myType;
	private final String myName;

	public Constant(String type, String value, String name) {
		myValue = value;
		myType = type;
		myName = name;
	}

	public Constant(String type, String value) {
		this(type, value, value);
	}

	public String getType() {
		return myType;
	}
	
	public String getValue() {
		return myValue;
	}

	public String getName() {
		return myName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myName == null) ? 0 : myName.hashCode());
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
		if (myName == null) {
			if (other.myName != null)
				return false;
		} else if (!myName.equals(other.myName))
			return false;
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
