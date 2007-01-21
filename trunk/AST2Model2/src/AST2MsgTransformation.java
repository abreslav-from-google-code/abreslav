import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import msg.ArrayType;
import msg.BasicType;
import msg.Class;
import msg.Field;
import msg.MsgFactory;
import msg.Type;
import msg.proxies.ClassProxy;
import msg.proxies.MsgNamespaceFactory;
import msg.proxies.impl.ClassProxyImpl;
import msg.proxies.impl.PackageProxyImpl;
import msg.util.BasicTypeConstants;
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

import proxy.Proxy;

public class AST2MsgTransformation extends MsjastSwitch {

	private final MsgNamespaceFactory nsFactory = MsgNamespaceFactory.INSTANCE; 
	private final msg.Package defaultPackage = new PackageProxyImpl("");
	private msg.Package thisPackage;
	private final Map<String, msg.Class> importedClasses = new HashMap<String, msg.Class>();
	private final Map<String, ClassProxy> unqualifiedClasses = new HashMap<String, ClassProxy>();
	private final Collection<Proxy<?>> noncontainedProxies = new ArrayList<Proxy<?>>();	

	public msg.Package getDefaultPackage() {
		return defaultPackage;
	}
	
	public Collection<Proxy<?>> getNoncontainedProxies() {
		return noncontainedProxies;
	}
	
	private Class internalLookupClass(FQNameAS fqn) {
		msg.Package p = defaultPackage;
		while (fqn.getSubFqn() != null) {
			p = nsFactory.createSubpackageNS(p).getAnyway(fqn.getName());
			fqn = fqn.getSubFqn();
		}
		return nsFactory.createClassesNS(p).getAnyway(fqn.getName());
	}
	
	private msg.Class lookupClass(FQNameAS fqn) {
		if (fqn.getSubFqn() == null) {
			msg.Class proxy = nsFactory.createClassesNS(thisPackage).getExisting(fqn.getName());
			if (proxy != null) {
				return proxy;
			}
			proxy = importedClasses.get(fqn.getName());
			if (proxy != null) {
				return proxy;
			}
			ClassProxy ambiguousProxy = unqualifiedClasses.get(fqn.getName());
			if (ambiguousProxy == null) {
				ambiguousProxy = new ClassProxyImpl(fqn.getName());
				unqualifiedClasses.put(fqn.getName(), ambiguousProxy);
			}
			return ambiguousProxy;
		}		
		return internalLookupClass(fqn);
	}
	
	private msg.Package lookupPackage(FQNameAS fqn) {
		msg.Package result = defaultPackage;
		while (fqn != null) {
			result = nsFactory.createSubpackageNS(result).getAnyway(fqn.getName());
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
			msg.Class proxy = internalLookupClass(imp.getFqn());
			importedClasses.put(proxy.getName(), proxy);
			resolveUnqualifiedClass(proxy);
		}
		
		EList classes = ast.getClasses();
		for (Iterator iter = classes.iterator(); iter.hasNext();) {
			ClassAS classAS = (ClassAS) iter.next();
			Class pClass = caseClassAS(classAS);
			nsFactory.createClassesNS(thisPackage).add(pClass);
			resolveUnqualifiedClass(pClass);
		}
		
		Collection<ClassProxy> uc = unqualifiedClasses.values();
		for (ClassProxy proxy : uc) {
			if (proxy.eContainer() == null || !proxy.eContainer().eContents().contains(proxy)) {
				noncontainedProxies.add(proxy);
			}
		}
		return thisPackage;
	}

	private void resolveUnqualifiedClass(Class pClass) {
		ClassProxy proxy = unqualifiedClasses.get(pClass.getName());
		if (proxy != null) {
			proxy.pResolve(pClass);
		}
	}
	
	@Override
	public msg.Class caseClassAS(ClassAS ast) {
		Class pClass = MsgFactory.eINSTANCE.createClass();

		String name = ast.getName();
		pClass.setName(name);
		
		ClassReferenceAS superClass = ast.getSuperClass();
		if (superClass != null) {
			pClass.setSuper(lookupClass(superClass.getFqn()));
		}
		
		EList members = ast.getMembers();
		for (Iterator iter = members.iterator(); iter.hasNext();) {
			MemberAS memberAS = (MemberAS) iter.next();
			Field member = (Field) doSwitch(memberAS);
			@SuppressWarnings({"unchecked", "unused"})
			boolean b = pClass.getMembers().add(member);
		}
		
		return pClass;
	}
	
	@Override
	public msg.Class caseClassReferenceAS(ClassReferenceAS ast) {
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
		return translateBasicType(ast.getType());
	}

	private BasicType translateBasicType(msjast.BasicType type) {
		switch (type.getValue()) {
		case msjast.BasicType.BOOLEAN:
			return BasicTypeConstants.INSTANCE.BOOLEAN;
		case msjast.BasicType.INT:
			return BasicTypeConstants.INSTANCE.INT;
		case msjast.BasicType.VOID:
			return BasicTypeConstants.INSTANCE.VOID;
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
