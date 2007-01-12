package ru.ifmo.rain.breslav.deferred;

@SuppressWarnings("serial")
public class ResolveFailedException extends Exception {

	public ResolveFailedException() {
	}
	
	public ResolveFailedException(String message) {
		super(message);
	}
	
}
