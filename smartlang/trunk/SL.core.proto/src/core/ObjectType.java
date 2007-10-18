package core;

import java.util.HashMap;
import java.util.Map;

public abstract class ObjectType<D> extends TypeImpl<D> {

	private Map<String, FieldDescriptor> fields;

	protected final Map<String, FieldDescriptor> getFields() {
		if (fields == null) {
			fields = new HashMap<String, FieldDescriptor>();
			FieldDescriptor[] fieldDescriptors = doGetFields();
			for (FieldDescriptor fieldDescriptor : fieldDescriptors) {
				fields.put(fieldDescriptor.getName(), fieldDescriptor);
			}
		}
		return fields;
	}

	protected abstract FieldDescriptor[] doGetFields();
	
	public final FieldDescriptor lookupField(String name) {
		FieldDescriptor fieldDescriptor = getFields().get(name);
		return (fieldDescriptor != null) 
			? fieldDescriptor 
			: NoSuch.FIELD;
	}
}
