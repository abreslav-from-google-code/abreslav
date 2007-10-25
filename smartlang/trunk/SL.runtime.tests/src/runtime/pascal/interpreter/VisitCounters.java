package runtime.pascal.interpreter;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

public class VisitCounters {
	private final Collection<VisitCounter> myCounters = new ArrayList<VisitCounter>();
	
	public VisitCounter addCounter(int count, String message) {
		VisitCounter counter = new VisitCounter(count, message);
		myCounters.add(counter);
		return counter;
	}
	
	public void assertCounters() {
		for (VisitCounter counter : myCounters) {
			if (counter.getMessage() == null) {
				Assert.assertEquals(counter.getCount(), counter.getVisits());
			} else {
				Assert.assertEquals(counter.getMessage() + ": ", counter.getCount(), counter.getVisits());
			}
		}
	}
}
