package listener;

public interface ListenerSubject {

	void addListener(Listener listener);
	void removeListener(Listener listener);
}
