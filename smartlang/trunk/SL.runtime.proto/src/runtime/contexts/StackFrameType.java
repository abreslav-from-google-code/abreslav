package runtime.contexts;

import java.util.HashMap;
import java.util.Map;

import core.IField;
import core.IGenericField;
import core.IMethod;
import core.Instance;
import core.ObjectType;

public class StackFrameType extends ObjectType<StackFrame> {
	
	private static final class StackFrameField implements IGenericField {
		private final int myIndex;

		public StackFrameField(int index) {
			myIndex = index;
		}

		public Instance readValue(Instance host) {
			return F_THIS.readValue(host).getInstance(myIndex);
		}

		public void writeValue(Instance host, Instance value) {
			F_THIS.readValue(host).setInstance(myIndex, value);
		}

		public boolean isMutable() {
			return true;
		}
	}

	private static final Instance.DataField<StackFrame> F_THIS = new Instance.DataField<StackFrame>();
	private static final Map<Integer, IGenericField> ourFields = new HashMap<Integer, IGenericField>();

	public static IGenericField getField(int index) {
		IGenericField result = ourFields.get(index);
		if (result == null) {
			result = new StackFrameField(index);
			ourFields.put(index, result);
		}
		return result;
	}
	
	public static final StackFrameType STACK_FRAME = new StackFrameType(); 
	
	private StackFrameType() {
	}
	
	@Override
	protected IField[] doGetFields() {
		return new IField[0];
	}

	@Override
	protected IMethod[] doGetMethods() {
		return new IMethod[0];
	}

	@Deprecated
	public Instance getDefaultValue() {
		return createInstance(new StackFrame(0));
	}
}
