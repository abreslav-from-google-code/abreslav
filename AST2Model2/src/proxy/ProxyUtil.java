package proxy;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ProxyUtil {

	public static EObject copyFilteringProxies(EObject eObject) {
		@SuppressWarnings("serial")
		Copier copier = new EcoreUtil.Copier() {
			private Map<EObject, EObject> copied = new HashMap<EObject, EObject>();
			
			@Override
			protected EObject createCopy(EObject eObject) {
				if (eObject instanceof Proxy) {
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
		EObject object = copier.copy(eObject);
		copier.copyReferences();
		return object;
	}

}
