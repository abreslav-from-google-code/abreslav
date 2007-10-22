package pascal.types;

import java.util.Arrays;

import core.FunctionWrapper;
import core.IField;
import core.IFunction;
import core.IGenericFunction;
import core.IMethod;
import core.IType;
import core.Instance;
import core.TypeImpl;

public class StringType extends TypeImpl<StringType.MutableString> {

	private static final class MutableString {
		private char[] data;
		
		public MutableString(String s) {
			data = s.toCharArray();
		}
		
		public MutableString(MutableString s1, MutableString s2) {
			int len = s1.data.length + s2.data.length;
			data = Arrays.copyOf(s1.data, len);
			int j = s1.data.length;
			for (int i = 0; i < s2.data.length; i++) {
				data[j] = s2.data[i];
				j++;
			}
		}
		
		public MutableString(MutableString s1, char c) {
			int len = s1.data.length + 1;
			data = Arrays.copyOf(s1.data, len);
			data[s1.data.length] = c;
		}
		
		public MutableString(char c, MutableString s1) {
			int len = s1.data.length + 1;
			data = new char[len];
			data[0] = c;
			for (int i = 0; i < s1.data.length; i++) {
				data[i + 1] = s1.data[i];
			}
		}
		
		public MutableString(char c1, char c2) {
			data = new char[2];
			data[0] = c1;
			data[1] = c2;
		}
		
		public int getLength() {
			return data.length;
		}
		
		public void setLength(int length) {
			data = Arrays.copyOf(data, length);
		}

		@Override
		public int hashCode() {
			return 31 + Arrays.hashCode(data);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final MutableString other = (MutableString) obj;
			return Arrays.equals(data, other.data);
		}
		
		
	}
	
	public static final Instance.DataField<MutableString> F_THIS = new Instance.DataField<MutableString>();
	
	public static final IGenericFunction.Binary CONCAT_WITH_STRING = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			MutableString s1 = F_THIS.readValue(thiz);
			MutableString s2 = F_THIS.readValue(arg);

			return STRING.createInstance(new MutableString(s1, s2));
		}
		
	};

	public static final IGenericFunction.Binary CONCAT_WITH_CHAR = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			MutableString s = F_THIS.readValue(thiz);
			Integer c = CharType.F_THIS.readValue(arg);

			return STRING.createInstance(new MutableString(s, (char) c.intValue()));
		}
		
	};

	public static final IGenericFunction.Binary CONCAT_CHAR_WITH = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			Integer c = CharType.F_THIS.readValue(thiz);
			MutableString s = F_THIS.readValue(arg);

			return STRING.createInstance(new MutableString((char) c.intValue(), s));
		}
		
	};

	public static final IGenericFunction.Binary CONCAT_TWO_CHARS = new IGenericFunction.Binary() {

		@Override
		public Instance run2(Instance thiz, Instance arg) {
			Integer c1 = CharType.F_THIS.readValue(thiz);
			Integer c2 = CharType.F_THIS.readValue(arg);

			return STRING.createInstance(new MutableString((char) c1.intValue(), (char) c2.intValue()));
		}
		
	};

	public static final IGenericFunction.Unary CAST_FROM_CHAR = new IGenericFunction.Unary() {

		@Override
		public Instance run1(Instance thiz) {
			return STRING.createString(
					Character.valueOf(
							(char) CharType.F_THIS.readValue(thiz).intValue()
					).toString());
		}
		
	};
	
	public static final StringType STRING = new StringType();
	private static final Instance EMPTY_STRING = STRING.createString("");
	private final IFunction CAST_FROM_CHAR_FN = new FunctionWrapper(CAST_FROM_CHAR, this, CharType.CHAR);
	
	@Override
	protected IMethod[] doGetMethods() {
		return null;
	}

	public Instance getDefaultValue() {
		return EMPTY_STRING;
	}

	public IField lookupField(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public IFunction getCastFrom(IType type) {
		if (type == CharType.CHAR || type.getSupertype() == CharType.CHAR) {
			return CAST_FROM_CHAR_FN;
		}
		return super.getCastFrom(type);
	}
	
	public Instance createString(String data) {
		return super.createInstance(new MutableString(data));
	}
}
