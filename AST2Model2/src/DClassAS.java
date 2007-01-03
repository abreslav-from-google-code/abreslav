import org.eclipse.emf.common.util.EList;

import msjast.ClassAS;
import msjast.ClassReferenceAS;


public class DClassAS extends DelegatingEObject<ClassAS> implements ClassAS {

	public DClassAS(ClassAS s) {
		super(s);
	}

	public EList getMembers() {
		return subject.getMembers();
	}

	public String getName() {
		return subject.getName();
	}

	public ClassReferenceAS getSuperClass() {
		return subject.getSuperClass();
	}

	public void setName(String value) {
		subject.setName(value);
	}

	public void setSuperClass(ClassReferenceAS value) {
		subject.setSuperClass(value);
	}

}
