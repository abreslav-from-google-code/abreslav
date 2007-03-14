/**
 * 
 */
package ru.ifmo.rain.astrans.asttomodel.resolver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import astrans.AstransPackage;
import astransast.AstransastPackage;
import astransast.QualifiedName;

class EPackageResolver {

	public static final EPackageResolver INSTANCE = new EPackageResolver();
	
	private final Map<String, IPackage> packageMap = new HashMap<String, IPackage>();
	
	private EPackageResolver() {
		packageMap.put("ecore", new MyEPackage(EcorePackage.eINSTANCE));
		packageMap.put("astrans", new MyEPackage(AstransPackage.eINSTANCE));
		packageMap.put("astransast", new MyEPackage(AstransastPackage.eINSTANCE));
	}
	
	private IPackage getEPackage(Iterator<String> qn) {
		IPackage ePackage = packageMap.get(qn.next());
		while (qn.hasNext() && ePackage != null) {
			ePackage = ePackage.getSubIPackage(qn.next());
		}
		if (ePackage == null) {
			return null;
		}
		return ePackage;       
	}
	
	public EPackage getEPackage(QualifiedName qn) {
		IterableQN iterableQN = new IterableQN(qn);
		Iterator<String> iterator = iterableQN.iterator();
		IPackage iPackage = getEPackage(iterator);
		return iPackage.getEPackage();
	}
	
	public EClassifier getEClassifier(QualifiedName qn) {
		IterableClassQN iterableClassQN = new IterableClassQN(qn);
		IPackage ePackage = getEPackage(iterableClassQN.iterator());
		return ePackage.getEClassifier(iterableClassQN.getClassName());
	}
}