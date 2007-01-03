package msg.proxies.impl;

import java.util.Collection;

import proxy.Namespace;


import msg.impl.PackageImpl;
import msg.proxies.ClassProxy;
import msg.proxies.PackageProxy;

public class PackageProxyImpl extends PackageImpl implements PackageProxy {

	private final Namespace<PackageProxy> subpackages = new Namespace<PackageProxy>() {
		@Override
		protected Collection getNamedElements() {
			return pIsResolved() ? getSubpackages() : null;
		}
		
		@Override
		protected PackageProxy createNSObject(Object lookup) {
			assert lookup instanceof PackageProxyImpl;
			return (PackageProxy) lookup;				
		}
		
		@Override
		protected PackageProxy createNSObjectWithKey(String key) {
			PackageProxyImpl result = new PackageProxyImpl();
			result.setName(key);
			return result;
		}
	}; 
	
	private final Namespace<ClassProxy> classes = new Namespace<ClassProxy>() {
		@Override
		protected Collection getNamedElements() {
			return pIsResolved() ? getClasses() : null;
		}
		
		@Override
		protected ClassProxy createNSObject(Object lookup) {
			assert lookup instanceof ClassProxyImpl;
			return (ClassProxy) lookup;				
		}
		
		@Override
		protected ClassProxy createNSObjectWithKey(String key) {
			ClassProxyImpl result = new ClassProxyImpl();
			result.setName(key);
			return result;
		}
		
	};

	private boolean resolved;
	
	public boolean pIsResolved() {
		return resolved;
	}

	public ClassProxy lookupClass(String name) {
		return classes.get(name);
	}

	public PackageProxy lookupSubpackage(String name) {
		return subpackages.get(name);
	}

	public void pResolve() {
		resolved = true;		
	}
}
