package ru.ifmo.rain.breslav.deferred;

public interface Deferred<T> {

	T resolve() throws ResolveFailedException;
	boolean isResolved();
	
}
