package msg.proxies.impl;
import java.util.Collection;

import msg.Field;
import msg.impl.ClassImpl;
import msg.proxies.ClassProxy;
import msg.proxies.FieldProxy;

import org.eclipse.emf.validation.util.FilteredCollection;

import proxy.Namespace;


public class ClassProxyImpl extends ClassImpl implements ClassProxy {

	private final Namespace<FieldProxy> fields = new Namespace<FieldProxy>() {
		@Override
		protected Collection getNamedElements() {
			return pIsResolved() ? getFC() : null;
		}				

		private Collection getFC() {
			FilteredCollection fc = new FilteredCollection(getMembers(), new FilteredCollection.Filter() {
				public boolean accept(Object obj) {
					return obj instanceof Field;
				}
			});
			return fc;
		}
		
		@Override
		protected FieldProxy createNSObjectWithKey(String key) {
			FieldProxyImpl result = new FieldProxyImpl();
			result.setName(key);
			return result;
		}
	};
	private boolean resolved;

	public FieldProxy lookupField(String name) {
		return fields.get(name);
	}

	public boolean pIsResolved() {
		return resolved;
	}

	public void pResolve() {
		resolved = true;
	} 
	
}
