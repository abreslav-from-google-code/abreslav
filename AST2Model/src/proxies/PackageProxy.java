package proxies;

import java.util.Collection;

import msg.Class;
import msg.Package;

import org.eclipse.emf.common.util.EList;

public class PackageProxy extends Proxy<msg.Package> implements msg.Package {

	private final String name;
	private final Namespace<PackageProxy> packages = new Namespace<PackageProxy>() {
		@Override
		protected Collection getNamedElements() {
			return pResolved() ? getSubpackages() : null;
		}
		
		@Override
		protected PackageProxy createNSObject(Object lookup) {
			if (lookup instanceof PackageProxy) {
				return (PackageProxy) lookup;				
			}
			return new PackageProxy((Package) lookup);
		}
		
		@Override
		protected PackageProxy createNSObjectWithKey(String key) {
			return new PackageProxy(key);
		}
	}; 
	
	private final Namespace<ClassProxy> classes = new Namespace<ClassProxy>() {
		@Override
		protected Collection getNamedElements() {
			return pResolved() ? getClasses() : null;
		}
		
		@Override
		protected ClassProxy createNSObject(Object lookup) {
			if (lookup instanceof ClassProxy) {
				return (ClassProxy) lookup;				
			}
			return new ClassProxy((Class) lookup);
		}
		
		@Override
		protected ClassProxy createNSObjectWithKey(String key) {
			return new ClassProxy(key);
		}
		
	};
	
	public PackageProxy(String name) {
		this.name = name;
	}
	
	public PackageProxy(msg.Package subject) {
		this(subject.getName());
		pSetSubject(subject);
	}
	
	public String getName() {
		return pResolved() ? pSubject().getName() : name;
	}

	public EList getClasses() {
		assertResolved();
		return pSubject().getClasses();
	}
	
	public void setName(String value) {
		assertResolved();
		pSubject().setName(value);
	}

	public EList getSubpackages() {
		assertResolved();
		return pSubject().getSubpackages();
	}

	public PackageProxy lookupSubpackage(String name) {
		return packages.get(name);
	}

	public ClassProxy lookupClass(String name) {
		return classes.get(name);
	}
}
