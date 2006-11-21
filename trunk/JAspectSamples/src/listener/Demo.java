package listener;

import java.util.ArrayList;

public class Demo {
	
	static class MySubject extends ArrayList<String> implements ListenerSubject {

		private static final long serialVersionUID = 1L;

		@Notify
		int x;
		
		@Override
		@Notify
		public void add(int index, String element) {
			super.add(index, element);
		}
		
	}
	
	static class MyListener implements Listener {

		public void notifyListener() {
			System.out.println("asdf");
		}
		
	}

	public static void main(String[] args) {
		MySubject subj = new MySubject();
		subj.addListener(new MyListener());
		subj.x = 10;
		subj.add(0, null);
	}
}
