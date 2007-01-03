package msg.proxies.impl;
import msg.impl.FieldImpl;
import msg.proxies.FieldProxy;

public class FieldProxyImpl extends FieldImpl implements FieldProxy {

	private boolean resolved;

	public boolean pIsResolved() {
		return resolved;
	}

	public void pResolve() {
		resolved = true;
	}
	
}
