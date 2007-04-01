package ru.ifmo.rain.astrans.interpreter;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

class Skipper {

	private Set<EClass> skipped = new HashSet<EClass>();	
	private Set<EClass> skippedWithChildren = new HashSet<EClass>();
	
	public boolean isSkipped(EClass eClass) {
		if (skipped.contains(eClass)) {
			return true; 
		}
		for (EClass parent : skippedWithChildren) {
			if (parent.isSuperTypeOf(eClass)) {
				skipped.add(eClass);
				return true;
			}
		}
		return false;
	}
	
	public void addSkippedEClass(EClass eClass, boolean skipChildren) {
		skipped.add(eClass);
		if (skipChildren) {
			skippedWithChildren.add(eClass);
		}
	}
}
