package profiler;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.aspectj.lang.reflect.MethodSignature;


public aspect ProfilerAspect {

	public static boolean profile = true;
	public static boolean consoleOutput = false;
	
	public static class ProfileRecord {
		public int invocationCount = 0;
		public long totalTime = 0;
		public long maxTime = Long.MIN_VALUE;
		public long minTime = Long.MAX_VALUE;
		
		public double averageTime() {
			if (invocationCount == 0) {
				return 0;
			}
			return (double) totalTime / (double) invocationCount;
		}
		
		@Override
		public String toString() {			
			return invocationCount + " " + totalTime + " " + minTime + " " + maxTime + " " + averageTime();
		}
	}
	
	private static final Map<Method, ProfileRecord> timeMap = new HashMap<Method, ProfileRecord>();
	
	public static Map<Method, ProfileRecord> getTimeMap() {
		return Collections.unmodifiableMap(timeMap);
	}
	
	public static String getStatsTable() {
		StringBuilder result = new StringBuilder();
		Set<Entry<Method, ProfileRecord>> entries = timeMap.entrySet();
		for (Entry<Method, ProfileRecord> entry : entries) {
			result.append(entry.getKey());
			result.append(": ");
			result.append(entry.getValue());
			result.append("\n");
		}
		return result.toString();
	}
	
	private String indent = "";
	
	private void pushIndent() {
		indent += "    ";
	}
	
	private void popIndent() {
		indent = indent.substring(4);
	}
	
	Object around(Object obj) : within(profiler..*) && !within(ProfilerAspect) && if(profile) && execution(* *.*(..)) && target(obj) {
		if (consoleOutput) {
			System.out.println(indent + "Started: " + thisJoinPoint.toShortString());
			pushIndent();
		}
		long start = System.currentTimeMillis();
		Object result = proceed(obj);
		long end = System.currentTimeMillis();
		
		Method method = ((MethodSignature) thisJoinPoint.getSignature()).getMethod();
		ProfileRecord record = timeMap.get(method);
		if (record == null) {
			record = new ProfileRecord(); 
			timeMap.put(method, record);
		}
		record.invocationCount++;
		long time = end - start;
		record.totalTime += time;
		record.maxTime = Math.max(record.maxTime, time);
		record.minTime = Math.min(record.minTime, time);
		if (consoleOutput) {
			popIndent();
			System.out.println(indent + "Finished: " + thisJoinPoint.toShortString() + " Returns: " + result);
		}
		return result;
	}
	
	after() : execution(public static void main(String[])) {
		System.out.println(getStatsTable());
	}
}
