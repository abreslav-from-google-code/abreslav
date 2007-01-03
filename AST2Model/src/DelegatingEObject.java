import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;


public class DelegatingEObject<T extends EObject> extends EObjectImpl {

	protected T subject;

	public DelegatingEObject(T s) {
		subject = s;
	}
	
	public EList eAdapters() {
		return subject.eAdapters();
	}

	public TreeIterator eAllContents() {
		return subject.eAllContents();
	}

	public EClass eClass() {
		return subject.eClass();
	}

	public EObject eContainer() {
		return subject.eContainer();
	}

	public EStructuralFeature eContainingFeature() {
		return subject.eContainingFeature();
	}

	public EReference eContainmentFeature() {
		return subject.eContainmentFeature();
	}

	public EList eContents() {
		return subject.eContents();
	}

	public EList eCrossReferences() {
		return subject.eCrossReferences();
	}

	public boolean eDeliver() {
		return subject.eDeliver();
	}

	public Object eGet(EStructuralFeature arg0, boolean arg1) {
		return subject.eGet(arg0, arg1);
	}

	public Object eGet(EStructuralFeature arg0) {
		return subject.eGet(arg0);
	}

	public boolean eIsProxy() {
		return subject.eIsProxy();
	}

	public boolean eIsSet(EStructuralFeature arg0) {
		return subject.eIsSet(arg0);
	}

	public void eNotify(Notification arg0) {
		subject.eNotify(arg0);
	}

	public Resource eResource() {
		return subject.eResource();
	}

	public void eSet(EStructuralFeature arg0, Object arg1) {
		subject.eSet(arg0, arg1);
	}

	public void eSetDeliver(boolean arg0) {
		subject.eSetDeliver(arg0);
	}

	public void eUnset(EStructuralFeature arg0) {
		subject.eUnset(arg0);
	}
	
}
