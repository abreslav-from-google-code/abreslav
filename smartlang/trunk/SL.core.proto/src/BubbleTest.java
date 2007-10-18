import java.util.Comparator;

import pascal.types.ArrayType;
import pascal.types.BooleanType;
import pascal.types.IntegerType;
import pascal.types.OrdinalSubrangeType;
import pascal.types.OrdinalType;
import core.Instance;


public class BubbleTest {
	private static final int _1024 = 1000*2;
	private static long time;
	
	static ArrayType ARRAY = new ArrayType(
			new OrdinalSubrangeType(IntegerType.INTEGER,
					IntegerType.INTEGER.createInstance(0),
					IntegerType.INTEGER.createInstance(_1024)
					),
			IntegerType.INTEGER);
	
	public static void main(String[] args) {

		Integer[] a = fillInts();
		Instance[] o = fillObjectImpls(a);
		Instance oi = fillMyArray(a);

		System.out.println(o.length);

		sortInts(a);
		sortObjectImpls(o);
		sortMyArr(oi);

	}

	private static void sortMyArr(final Instance oi) {
		class MYII implements IIntIterator {

			private Instance v = IntegerType.INTEGER.createInstance(0);
			
			public int get() {
				return OrdinalType.F_THIS.readValue(v);
			}

			public void inc() {
				v = IntegerType.SUCC.run1(v);				
			}

			public boolean isLessThan(int i) {
				return BooleanType.BOOLEAN.readBooleanValue(
						IntegerType.LT.run2(v, 
								IntegerType.INTEGER.createInstance(i)));
			}

			public void set(int value) {
				v = IntegerType.INTEGER.createInstance(value);
			}
			
		}
		System.out.print("sort my array: ");
		time = System.currentTimeMillis();
		BubbleSort.sort(new IArray<Instance>() {

			public Instance get(int i) {
				return ArrayType.READ_CELL.run2(oi, IntegerType.INTEGER.createInstance(i));
			}

			public int length() {
				return _1024;
			}

			public void set(int i, Instance value) {
				// TODO: overhead here!!!
				ARRAY.getElementField(i).writeValue(oi, value);
			}
			
		}, new MYII(), new MYII(), new Comparator<Instance>() {
			
			public int compare(Instance o1, Instance o2) {
				return IntegerType.F_THIS.readValue(IntegerType.SUB.run2(o1, o2));
			}
			
		});
		System.out.println(System.currentTimeMillis() - time);		
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

	private static void sortInts(Integer[] a) {
		System.out.print("sort ints: ");
		time = System.currentTimeMillis();
		BubbleSort.sort(new MyArray<Integer>(a), new IntIterator(), new IntIterator(), 
				new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		System.out.println(System.currentTimeMillis() - time);
	}

	private static void sortObjectImpls(Instance[] o) {
		System.out.print("sort ObjectImpls: ");
		time = System.currentTimeMillis();
		BubbleSort.sort(new MyArray<Instance>(o), new IntIterator(), new IntIterator(), new Comparator<Instance>() {
			
			public int compare(Instance o1, Instance o2) {
				return IntegerType.F_THIS.readValue(IntegerType.SUB.run2(o1, o2));
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
