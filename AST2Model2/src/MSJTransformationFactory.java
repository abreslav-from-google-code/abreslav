import java.util.Iterator;

import msg.AccessModifier;
import msg.Class;
import msg.Field;
import msg.Member;
import msg.MsgFactory;
import msg.Type;
import msg.proxies.ClassProxy;
import msg.proxies.PackageProxy;
import msg.proxies.impl.PackageProxyImpl;
import msjast.ClassAS;
import msjast.ClassReferenceAS;
import msjast.FQNameAS;
import msjast.FieldAS;
import msjast.MemberAS;
import msjast.MsjastPackage;
import msjast.TypeReferenceAS;

import org.eclipse.emf.common.util.EList;

public class MSJTransformationFactory {

	private final PackageProxy root = new PackageProxyImpl("");
	
	private PackageProxy lookupPackage(FQNameAS fqn, PackageProxy ns) {
		PackageProxy pp = ns.getSubpackageNS().getAnyway(fqn.getName());
		if (fqn.getSubFqn() == null) {
			return ns;
		}
		return lookupPackage(fqn.getSubFqn(), pp);
	}
	
	public PackageProxy getPackageReference(FQNameAS fqn) {
		if (fqn == null) {
			return null;
		}
		return lookupPackage(fqn, root);
	}
	
	public PackageProxy createPackage(FQNameAS fqn) {
		PackageProxy pr = getPackageReference(fqn);
		pr.pResolve();
		return pr;
	}
	
	private ClassProxy lookupClassProxy(ClassReferenceAS ast) {
		FQNameAS fqn = ast.getFqn();
		PackageProxy pns = root;
		while (fqn.getSubFqn() != null) {
			pns = pns.getSubpackageNS().getAnyway(fqn.getName());
			fqn = fqn.getSubFqn();
		}
		return pns.getClassNS().getAnyway(fqn.getName());
	}
	
	public Class getClassReference(ClassReferenceAS ast) {
		if (ast == null) {
			return null;
		}
		return lookupClassProxy(ast);
	}

	public Class createClass(ClassAS ast) {
		Class result = MsgFactory.eINSTANCE.createClass();
		result.setName(ast.getName());
		// package is a container reference so it is not set here
		EList members = ast.getMembers();
		for (Iterator iter = members.iterator(); iter.hasNext();) {
			MemberAS member = (MemberAS) iter.next();
			result.getMembers().add(createMember(member));			
		}
		result.setSuper(getClassReference(ast.getSuperClass()));
		return result;
	}

	public Member createMember(MemberAS ast) {
		switch (ast.eClass().getClassifierID()) {
		case MsjastPackage.METHOD_AS:
			return createMethod(ast);
		case MsjastPackage.FIELD_AS:
			return createField((FieldAS) ast);
		}
		throw new IllegalStateException();
	}

	private Field createField(FieldAS ast) {
		Field result = MsgFactory.eINSTANCE.createField();
		result.setName(ast.getName());
		result.setAccessModifier(convertAccessModifier(ast.getAccessModifier()));
		result.setFinal(ast.isFinal());
		result.setType(getTypeReference(ast.getType()));
		return result;
	}

	private Type getTypeReference(TypeReferenceAS ast) {
		return null;
	}

	private AccessModifier convertAccessModifier(msjast.AccessModifier accessModifier) {
		return null;
	}

	private Member createMethod(MemberAS ast) {
		return null;
	}

}
