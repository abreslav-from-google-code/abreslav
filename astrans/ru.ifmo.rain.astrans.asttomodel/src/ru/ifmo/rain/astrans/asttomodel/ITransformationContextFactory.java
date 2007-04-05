package ru.ifmo.rain.astrans.asttomodel;

public interface ITransformationContextFactory<R, T> {
	R createResolver();
	T createTrace();
}
