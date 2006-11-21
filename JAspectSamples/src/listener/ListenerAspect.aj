package listener;

import java.util.Collection;
import java.util.LinkedHashSet;

public aspect ListenerAspect {

	private Collection<Listener> ListenerSubject.listeners = new LinkedHashSet<Listener>();
	
	public void ListenerSubject.addListener(Listener listener) {
		listeners.add(listener);
	}

	public void ListenerSubject.removeListener(Listener listener) {
		listeners.remove(listener);
	}

	public void ListenerSubject.notifyListeners() {
		for (Listener listener : listeners) {
			listener.notifyListener();
		}		
	}
	
	pointcut notifiedMember(ListenerSubject subj) : @annotation(Notify) && target(subj);
	pointcut notifiedMethod(ListenerSubject subj) : call(* ListenerSubject+.*(..)) && notifiedMember(subj);
	pointcut notifiedField(ListenerSubject subj) : set(* ListenerSubject+.*) && notifiedMember(subj);
	
	after(ListenerSubject subj) : notifiedMethod(subj)  {
		subj.notifyListeners();
	}

	after(ListenerSubject subj) : notifiedField(subj)  {
		subj.notifyListeners();
	}
}
