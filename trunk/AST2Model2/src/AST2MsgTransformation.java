import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import msg.ArrayType;
import msg.BasicType;
import msg.BasicTypes;
import msg.Class;
import msg.Field;
import msg.MsgFactory;
import msg.Type;
import msg.proxies.ClassProxy;
import msg.proxies.FieldProxy;
import msg.proxies.PackageProxy;
import msg.proxies.impl.PackageProxyImpl;
import msjast.AccessModifier;
import msjast.ArrayTypeAS;
import msjast.BasicTypeAS;
import msjast.ClassAS;
import msjast.ClassReferenceAS;
import msjast.CompilationUnitAS;
import msjast.FQNameAS;
import msjast.FieldAS;
import msjast.MemberAS;
import msjast.TypeReferenceAS;
import msjast.util.MsjastSwitch;

import org.eclipse.emf.common.util.EList;


public class AST2MsgTransformation extends MsjastSwitch {

	private final PackageProxy defaultPackage = new PackageProxyImpl("");
	private PackageProxy thisPackage;
	private final Map<String, ClassProxy> importedClasses = new HashMap<String, ClassProxy>();

	private ClassProxy internalLookupClass(FQNameAS fqn) {
		PackageProxy p = defaultPackage;
		while (fqn.getSubFqn() != null) {
			p = p.getSubpackageNS().getAnyway(fqn.getName());
			fqn = fqn.getSubFqn();
		}
		return p.getClassNS().getAnyway(fqn.getName());
	}
	
	private ClassProxy lookupClass(FQNameAS fqn) {
		if (fqn.getSubFqn() == null) {
			ClassProxy proxy = thisPackage.getClassNS().getExisting(fqn.getName());
			if (proxy != null) {
				return proxy;
			}
			proxy = importedClasses.get(fqn.getName());
			if (proxy != null) {
				return proxy;
			}
		}
		return internalLookupClass(fqn);
	}
	
	private PackageProxy lookupPackage(FQNameAS fqn) {
		PackageProxy result = defaultPackage;
		while (fqn != null) {
			result = result.getSubpackageNS().getAnyway(fqn.getName());
			fqn = fqn.getSubFqn();
		}
		return result;
	}
	
	@Override
	public Object caseCompilationUnitAS(CompilationUnitAS ast) {
		FQNameAS pack = ast.getPackage();
		thisPackage = lookupPackage(pack);
		
		EList imports = ast.getImports();
		for (Iterator iter = imports.iterator(); iter.hasNext();) {
			ClassReferenceAS imp = (ClassReferenceAS) iter.next();
			ClassProxy proxy = internalLookupClass(imp.getFqn());
			importedClasses.put(proxy.getName(), proxy);
		}
		
		EList classes = ast.getClasses();
		for (Iterator iter = classes.iterator(); iter.hasNext();) {
			ClassAS classAS = (ClassAS) iter.next();
			Class pClass = caseClassAS(classAS);
			thisPackage.getClassNS().add(pClass);
			thisPackage.getClasses().add(pClass);
		}
		return thisPackage;
	}
	
	@Override
	public msg.Class caseClassAS(ClassAS ast) {
		String name = ast.getName();
		ClassProxy pClass = thisPackage.getClassNS().getAnyway(name);
		
		ClassReferenceAS superClass = ast.getSuperClass();
		if (superClass != null) {
			pClass.setSuper(lookupClass(superClass.getFqn()));
		}
		
		EList members = ast.getMembers();
		for (Iterator iter = members.iterator(); iter.hasNext();) {
			MemberAS memberAS = (MemberAS) iter.next();
			Field member = (Field) doSwitch(memberAS);
			FieldProxy pField = pClass.getFieldNS().getAnyway(member.getName());
			pField.pResolve(member);
			pClass.getMembers().add(member);
		}
		
//		pClass.pResolve();
		return pClass;
	}
	
	@Override
	public ClassProxy caseClassReferenceAS(ClassReferenceAS ast) {
		return lookupClass(ast.getFqn());
	}
	
	@Override
	public msg.Field caseFieldAS(FieldAS ast) {
		Field field = MsgFactory.eINSTANCE.createField();

		String name = ast.getName();
		field.setName(name);

		AccessModifier accessModifier = ast.getAccessModifier();
		field.setAccessModifier(translateAccessModifier(accessModifier));
		
		TypeReferenceAS type = ast.getType();
		field.setType((Type) doSwitch(type));
		
		return field;
	}

	private msg.AccessModifier translateAccessModifier(msjast.AccessModifier accessModifier) {
		switch (accessModifier.getValue()) {
		case msjast.AccessModifier.PRIVATE:
			return msg.AccessModifier.PRIVATE_LITERAL;
		case msjast.AccessModifier.PROTECTED:
			return msg.AccessModifier.PROTECTED_LITERAL;
		case msjast.AccessModifier.PUBLIC:
			return msg.AccessModifier.PUBLIC_LITERAL;			
		}
		return null;
	}

	@Override
	public BasicType caseBasicTypeAS(BasicTypeAS ast) {
		BasicType type = MsgFactory.eINSTANCE.createBasicType();
		type.setType(translateBasicType(ast.getType()));
		return type;
	}

	private BasicTypes translateBasicType(msjast.BasicType type) {
		switch (type.getValue()) {
		case msjast.BasicType.BOOLEAN:
			return BasicTypes.BOOLEAN_LITERAL;
		case msjast.BasicType.INT:
			return BasicTypes.INT_LITERAL;
		case msjast.BasicType.VOID:
			return BasicTypes.VOID_LITERAL;
		}
		return null;
	}
	
	@Override
	public ArrayType caseArrayTypeAS(ArrayTypeAS ast) {
		ArrayType type = MsgFactory.eINSTANCE.createArrayType();
		
		TypeReferenceAS elementType = ast.getElementType();
		type.setElementType((Type) doSwitch(elementType));
		
		return type;
	}
}
