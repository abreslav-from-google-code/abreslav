package proxy;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Internal;


public class DelegatingEObject<T extends EObject> extends EObjectImpl {

	protected T subject;
	protected final T initialSubject;
	
	private InternalEObject internal;
	
	public DelegatingEObject(T subject) {
		this.initialSubject = subject;
		this.subject = subject;
		this.internal = (InternalEObject) subject;
	}

	public EList eAdapters() {
		return subject.eAdapters();
	}

	public TreeIterator eAllContents() {
		return subject.eAllContents();
	}

	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		return internal.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	public NotificationChain eBasicRemoveFromContainer(NotificationChain notifications) {
		return internal.eBasicRemoveFromContainer(notifications);
	}

	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain notifications) {
		return internal.eBasicSetContainer(newContainer, newContainerFeatureID, notifications);
	}

	public EClass eClass() {
		return subject.eClass();
	}

	public EObject eContainer() {
		return subject.eContainer();
	}

	public int eContainerFeatureID() {
		return internal.eContainerFeatureID();
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

	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		return internal.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	public Internal eDirectResource() {
		return internal.eDirectResource();
	}

	public Object eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
		return internal.eGet(eFeature, resolve, coreType);
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return subject.eGet(feature, resolve);
	}

	public Object eGet(EStructuralFeature feature) {
		return subject.eGet(feature);
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		return internal.eGet(featureID, resolve, coreType);
	}

	public InternalEObject eInternalContainer() {
		return internal.eInternalContainer();
	}

	public Internal eInternalResource() {
		return internal.eInternalResource();
	}

	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain notifications) {
		return internal.eInverseAdd(otherEnd, featureID, baseClass, notifications);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain notifications) {
		return internal.eInverseRemove(otherEnd, featureID, baseClass, notifications);
	}

	public boolean eIsProxy() {
		return subject.eIsProxy();
	}

	public boolean eIsSet(EStructuralFeature feature) {
		return subject.eIsSet(feature);
	}

	public boolean eIsSet(int featureID) {
		return internal.eIsSet(featureID);
	}

	public boolean eNotificationRequired() {
		return internal.eNotificationRequired();
	}

	public void eNotify(Notification notification) {
		subject.eNotify(notification);
	}

	public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
		return internal.eObjectForURIFragmentSegment(uriFragmentSegment);
	}

	public URI eProxyURI() {
		return internal.eProxyURI();
	}

	public EObject eResolveProxy(InternalEObject proxy) {
		return internal.eResolveProxy(proxy);
	}

	public Resource eResource() {
		return subject.eResource();
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		subject.eSet(feature, newValue);
	}

	public void eSet(int featureID, Object newValue) {
		internal.eSet(featureID, newValue);
	}

	public void eSetClass(EClass eClass) {
		internal.eSetClass(eClass);
	}

	public void eSetDeliver(boolean deliver) {
		subject.eSetDeliver(deliver);
	}

	public void eSetProxyURI(URI uri) {
		internal.eSetProxyURI(uri);
	}

	public NotificationChain eSetResource(Internal resource, NotificationChain notifications) {
		return internal.eSetResource(resource, notifications);
	}

	public void eSetStore(EStore store) {
		internal.eSetStore(store);
	}

	public Setting eSetting(EStructuralFeature feature) {
		return internal.eSetting(feature);
	}

	public EStore eStore() {
		return internal.eStore();
	}

	public void eUnset(EStructuralFeature feature) {
		subject.eUnset(feature);
	}

	public void eUnset(int featureID) {
		internal.eUnset(featureID);
	}

	public String eURIFragmentSegment(EStructuralFeature eFeature, EObject eObject) {
		return internal.eURIFragmentSegment(eFeature, eObject);
	}

}
