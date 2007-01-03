package msg.proxies;

import proxy.Proxy;

public interface PackageProxy extends msg.Package, Proxy {

	PackageProxy lookupSubpackage(String name);
	ClassProxy lookupClass(String name);
}
