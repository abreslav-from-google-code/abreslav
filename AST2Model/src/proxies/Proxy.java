package proxies;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;


public class Proxy<T extends EObject> extends EObjectImpl {

	private T subject;
	
	public T pSubject() {
		return subject;
	}
	
	public final void pSetSubject(T subject) {
		this.subject = subject;
	}
	
	public boolean pResolved() {
		return subject != null;
	}
	
	protected void assertResolved() {
		if (!pResolved()) {
			throw new IllegalStateException();
		}
	}

	public EList eAdapters() {
		if (!pResolved()) {
			return super.eAdapters();
		}
		return subject.eAdapters();
	}

	public TreeIterator eAllContents() {
		if (!pResolved()) {
			return super.eAllContents();
		}
		return subject.eAllContents();
	}

	public EClass eClass() {
		if (!pResolved()) {
			return super.eClass();
		}
		return subject.eClass();
	}

	public EObject eContainer() {
		if (!pResolved()) {
			return super.eContainer();
		}
		return subject.eContainer();
	}

	public EStructuralFeature eContainingFeature() {
		if (!pResolved()) {
			return super.eContainingFeature();
		}
		return subject.eContainingFeature();
	}

	public EReference eContainmentFeature() {
		if (!pResolved()) {
			return super.eContainmentFeature();
		}
		return subject.eContainmentFeature();
	}

	public EList eContents() {
		if (!pResolved()) {
			return super.eContents();
		}
		return subject.eContents();
	}

	public EList eCrossReferences() {
		if (!pResolved()) {
			return super.eCrossReferences();
		}
		return subject.eCrossReferences();
	}

	public boolean eDeliver() {
		if (!pResolved()) {
			return super.eDeliver();
		}
		return subject.eDeliver();
	}

	public Object eGet(EStructuralFeature arg0, boolean arg1) {
		if (!pResolved()) {
			return super.eGet(arg0, arg1);
		}
		return subject.eGet(arg0, arg1);
	}

	public Object eGet(EStructuralFeature arg0) {
		if (!pResolved()) {
			return super.eGet(arg0);
		}
		return subject.eGet(arg0);
	}

	public boolean eIsProxy() {
		if (!pResolved()) {
			return super.eIsProxy();
		}
		return subject.eIsProxy();
	}

	public boolean eIsSet(EStructuralFeature arg0) {
		if (!pResolved()) {
			return super.eIsSet(arg0);
		}
		return subject.eIsSet(arg0);
	}

	public void eNotify(Notification arg0) {
		if (!pResolved()) {
			super.eNotify(arg0);
		}
		subject.eNotify(arg0);
	}

	public Resource eResource() {
		if (!pResolved()) {
			return super.eResource();
		}
		return subject.eResource();
	}

	public void eSet(EStructuralFeature arg0, Object arg1) {
		if (!pResolved()) {
			super.eSet(arg0, arg1);
		}
		subject.eSet(arg0, arg1);
	}

	public void eSetDeliver(boolean arg0) {
		if (!pResolved()) {
			super.eSetDeliver(arg0);
		}
		subject.eSetDeliver(arg0);
	}

	public void eUnset(EStructuralFeature arg0) {
		if (!pResolved()) {
			super.eUnset(arg0);
		}
		subject.eUnset(arg0);
	}
}
