package runtime.tree;

public interface IVisitHandler {
	public static final IVisitHandler NOTHING = new IVisitHandler() {
		public void run() {
		}
	};
	
	void run();
}
