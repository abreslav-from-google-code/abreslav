import java.util.Comparator;


public class BubbleSort {

	static <T> void sort(IArray<T> a, IIntIterator i, IIntIterator j, Comparator<T> c) {
		for (i.set(0); i.isLessThan(a.length()); i.inc()) {
			for (j.set(0); j.isLessThan(a.length() - i.get() - 1); j.inc()) {
				if (c.compare(a.get(j.get()), a.get(j.get() + 1)) > 0) {
					T t = a.get(j.get());
					a.set(j.get(), a.get(j.get()+1));
					a.set(j.get()+1, t);
				}
			}
		}
	}
}
