import java.util.Arrays;
import java.util.Comparator;

import pascal.types.ArrayType;
import pascal.types.IntegerType;
import pascal.types.OrdinalSubrangeType;
import pascal.types.OrdinalType;
import core.Instance;


public class Test {
	private static final int _1024 = 100000;
	private static long time;
	
	static class creator {
		void init(X x, Integer i) {
			x.a = i;
		}
	}
	
	static ArrayType ARRAY = new ArrayType(
			new OrdinalSubrangeType(IntegerType.INTEGER,
					IntegerType.INTEGER.createInstance(0),
					IntegerType.INTEGER.createInstance(_1024)
					),
			IntegerType.INTEGER);

	
	static creator c = new creator();
	
	static class X {
		Integer a;
//		private Integer intField;
//		private Byte byteField;
//		private Short shortField;
//		private Long longField;
//		private Character charField;
//		private Boolean boolField;
//		private Double doubleField;
//		private Float floatField;
//		private String stringField;
//		
//		private ObjectImpl[] objectFields;
//		
//		private IObjectType type;

		
		public X(creator c, Integer a) {
			super();
			c.init(this, a);
		}


		Integer getA() {
			return a;
		}
		
		X run(Trans t, X... other) {
			return t.run(this, other[0]);
		}
	}
	
	static interface Trans {
		X run(X... a);
	}
	
	static Trans SUB = new Trans() {

		public X run(X... a) {
			return new X(c, y.read(a[0]) - y.read(a[1]));
		}
		
	};
	
	static class Y {
		Integer read(X x) {
			return x.getA();
		}
		
	}
	
	static Y y = new Y();

	public static void main(String[] args) {

		Integer[] a = fillInts();
		
		Instance[] o = fillObjectImpls(a);
		
		Instance oi = fillMyArray(a);

		System.out.println(o.length);


		sortInts(a);
		checkInts(a);

		sortObjectImpls(o);
		checkObjectImpls(o);
		
		sortMyArr(oi);

		X[] x = fillX();
		sortX(x);
	}

	private static void sortMyArr(Instance oi) {
		
	}

	private static Instance fillMyArray(Integer[] a) {
		System.out.print("Fill my arr: ");
		time = System.currentTimeMillis();
		Instance result = ARRAY.createInstance();
		for (int i = 0; i < a.length; i++) {
			ARRAY.getElementField(i).writeValue(result, IntegerType.INTEGER.createInstance(a[i]));
		}
		System.out.println(System.currentTimeMillis() - time);
		return result;
	}

	private static void sortX(X[] x) {
		System.out.print("sort Xs: ");
		time = System.currentTimeMillis();
		Arrays.sort(x, new Comparator<X>() {
			
			public int compare(X o1, X o2) {
				return y.read(o1.run(SUB, o2));
			}
			
		});
		System.out.println(System.currentTimeMillis() - time);
	}

	private static X[] fillX() {
		System.out.print("fill Xs: ");
		time = System.currentTimeMillis();
		X[] o = new X[_1024];
		for (int i = 0; i < o.length; i++) {
			o[i] = new X(c, (int) (Math.random() * _1024));
		}
		System.out.println(System.currentTimeMillis() - time);
		return o;
	}

	private static void checkInts(Integer[] a) {
		time = System.currentTimeMillis();
		boolean ff = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] - a[i + 1] > 0) {
				ff = false;
				break;
			}
		}
		System.out.print(System.currentTimeMillis() - time);
		System.out.println(" check ints: " + ff);
	}

	private static void checkObjectImpls(Instance[] o) {
		time = System.currentTimeMillis();
		boolean f = true;
		for (int i = 0; i < o.length - 1; i++) {
			if (OrdinalType.F_THIS.readValue(IntegerType.SUB.run2(o[i], o[i + 1])) > 0) {
				f = false;
				break;
			}
		}
		System.out.print(System.currentTimeMillis() - time);
		System.out.println(" check ObjectImpls: " + f);
	}

	private static void sortInts(Integer[] a) {
		System.out.print("sort ints: ");
		time = System.currentTimeMillis();
		Arrays.sort(a, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		System.out.println(System.currentTimeMillis() - time);
	}

	private static void sortObjectImpls(Instance[] o) {
		System.out.print("sort ObjectImpls: ");
		time = System.currentTimeMillis();
		Arrays.sort(o, new Comparator<Instance>() {
			
			public int compare(Instance o1, Instance o2) {
				return OrdinalType.F_THIS.readValue(IntegerType.SUB.run2(o1, o2));
			}
			
		});
		System.out.println(System.currentTimeMillis() - time);
	}

	private static Instance[] fillObjectImpls(Integer[] a) {
		System.out.print("fill ObjectImpls: ");
		time = System.currentTimeMillis();
		Instance[] o = new Instance[_1024];
		for (int i = 0; i < o.length; i++) {
			o[i] = IntegerType.INTEGER.createInstance(a[i]);
		}
		System.out.println(System.currentTimeMillis() - time);
		return o;
	}

	private static Integer[] fillInts() {
		System.out.print("fill ints: ");
		time = System.currentTimeMillis();
		Integer[] a = new Integer[_1024];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * _1024);
		}
		System.out.println(System.currentTimeMillis() - time);
		return a;
	}
}
