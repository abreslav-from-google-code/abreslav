package profiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			new Demo().doit();
		}
		System.out.println(ProfilerAspect.getStatsTable());
	}

	private void doit() {
		ArrayList<Integer> l = do1();
		l.addAll(do3());
	}

	private List<Integer> do3() {
		return Arrays.asList(do4());
	}

	private Integer[] do4() {
		return new Integer[] {0, 1, 2, 3, 4};
	}

	private ArrayList<Integer> do1() {
		ArrayList<Integer> l = do2();
		return l;
	}

	private ArrayList<Integer> do2() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		return l;
	}
	
}
