package core;

import java.util.HashMap;
import java.util.Map;

public abstract class ObjectType<D> extends TypeImpl<D> {

	private Map<String, IField> fields;

	protected final Map<String, IField> getFields() {
		if (fields == null) {
			fields = new HashMap<String, IField>();
			IField[] fieldDescriptors = doGetFields();
			for (IField fieldDescriptor : fieldDescriptors) {
				fields.put(fieldDescriptor.getName(), fieldDescriptor);
			}
		}
		return fields;
	}

	protected abstract IField[] doGetFields();
	
	public final IField lookupField(String name) {
		IField fieldDescriptor = getFields().get(name);
		return (fieldDescriptor != null) 
			? fieldDescriptor 
			: NoSuch.FIELD;
	}
}
