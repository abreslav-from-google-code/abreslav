package core;

public interface IField extends IGenericField {

	IType getFieldType();
	IType getDeclaringType();
	String getName();
	
	Instance readValue(Instance host);
	void writeValue(Instance host, Instance value);

}