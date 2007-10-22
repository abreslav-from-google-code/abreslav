package pascal.types;

import core.IField;
import core.IGenericField;
import core.IGenericFunction;
import core.IMethod;
import core.IType;
import core.Instance;
import core.NoSuch;
import core.TypeImpl;

public class ArrayType extends TypeImpl<ArrayType.ShiftedArray> {

	private static final class ShiftedArray {
		private final Instance[] data;
		private final int low;
		private final IType elementType;
		
		public ShiftedArray(Instance[] data, int low, IType elementType) {
			this.data = data;
			this.low = low;
			this.elementType = elementType;
		}
		
		public Instance get(int index) {
			int i = index - low;
			if (data[i] == null) {
				data[i] = elementType.getDefaultValue();
			}
			return data[i];
		}
		
		public void set(int index, Instance value) {
			data[index - low] = value;
		}
		
	}
	
	private static final class ArrayField implements IGenericField {

		private final int index;
		private final IType fieldType;

		public ArrayField(int index, IType fieldType) {
			super();
			this.index = index;
			this.fieldType = fieldType;
		}

		public IType getFieldType() {
			return fieldType;
		}

		public boolean isMutable() {
			return true;
		}

		public Instance readValue(Instance thiz) {
			ShiftedArray array = F_THIS.readValue(thiz);
			return array.get(index);
		}

		public void writeValue(Instance thiz, Instance value) {
			assert value.getType() == fieldType;
			
			ShiftedArray array = F_THIS.readValue(thiz);
			array.set(index, value);
		}

	}

	private static final Instance.DataField<ShiftedArray> F_THIS = new Instance.DataField<ShiftedArray>();
	
	public static final IGenericFunction.Binary READ_CELL = new IGenericFunction.Binary() {
		
		@Override
		public Instance run2(Instance thiz, Instance arg) {
			ShiftedArray array = F_THIS.readValue(thiz);
			Integer index = OrdinalType.F_THIS.readValue(arg);
			return array.get(index);
		}
		
	};
	
	private final IOrdinalType indexType;
	private final IType elementType;
	private final ArrayField[] elementFields;
	private final int length;
	private final int lowInt;
	private final int highInt;
	
	public ArrayType(IOrdinalType indexType, IType elementType) {
		this.indexType = indexType;
		
		this.lowInt = OrdinalType.F_THIS.readValue(indexType.getLow());
		this.highInt = OrdinalType.F_THIS.readValue(indexType.getHigh());
		this.length = highInt - lowInt + 1;
		
		this.elementType = elementType;
		this.elementFields = new ArrayField[length];		
	}

	@Override
	protected IMethod[] doGetMethods() {
		return new IMethod[] {};
	}

	public IField lookupField(String name) {
		return NoSuch.FIELD;
	}
	
	public IGenericField getElementField(int index) {
		assert index >= lowInt;
		assert index <= highInt;
		
		int zindex = index - lowInt;
		if (elementFields[zindex] == null) {
			elementFields[zindex] = new ArrayField(index, elementType);
		}
		return elementFields[zindex];
	}
	
	@Override
	public Instance createInstance(ShiftedArray data) {
		assert data.elementType == elementType;
		assert data.low == lowInt;
		assert data.data.length == length;
		
		return super.createInstance(data);
	}
	
	public Instance getDefaultValue() {
		return createInstance();
	}
	
	public Instance createInstance() {
		return createInstance(new ShiftedArray(new Instance[length], lowInt, elementType));
	}
	
	public IType getElementType() {
		return elementType;
	}
	
	public IOrdinalType getIndexType() {
		return indexType;
	}
}
