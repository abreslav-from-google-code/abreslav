package proxy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ProxyUtil {

	public static EObject copyFilteringProxies(EObject eObject, Collection<Proxy<? extends EObject>> uncontainedProxies) {
		@SuppressWarnings("serial")
		EcoreUtil.Copier copier = new EcoreUtil.Copier() {
			private Map<EObject, EObject> copied = new HashMap<EObject, EObject>();

			@Override
			protected EObject createCopy(EObject eObject) {
				while (eObject instanceof Proxy) {
					Proxy proxy = (Proxy) eObject;
					eObject = proxy.pSubject();
				}
				EObject object = copied.get(eObject);
				if (object != null) {
					return object;
				}
				EObject result = super.createCopy(eObject);
				copied.put(eObject, result);
				return result;
			}
		};
		
		// Just to cache copies for those elements which won't be copied
		// during containment walkdown
		copier.copyAll(uncontainedProxies);
		
		EObject object = copier.copy(eObject);
		copier.copyReferences();
		return object;
	}

}
