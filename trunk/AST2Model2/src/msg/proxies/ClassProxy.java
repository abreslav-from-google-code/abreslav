package msg.proxies;

import proxy.Proxy;

public interface ClassProxy extends msg.Class, Proxy {
	FieldProxy lookupField(String name);
}
