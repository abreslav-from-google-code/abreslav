package proxy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ProxyUtil {

	private static final class MyCopier extends EcoreUtil.Copier {
		private Map<EObject, EObject> copied = new HashMap<EObject, EObject>();

		@Override
		public EObject createCopy(EObject eObject) {
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
	}

	public static EObject copyFilteringProxies(EObject eObject, Collection<Proxy<? extends EObject>> uncontainedProxies) {
		@SuppressWarnings("serial")
		MyCopier copier = new MyCopier();
		for (Proxy<?> proxy : uncontainedProxies) {
			copier.put(proxy, copier.createCopy(proxy.pSubject()));
		}
		EObject object = copier.copy(eObject);
		copier.copyReferences();
		return object;
	}

}
