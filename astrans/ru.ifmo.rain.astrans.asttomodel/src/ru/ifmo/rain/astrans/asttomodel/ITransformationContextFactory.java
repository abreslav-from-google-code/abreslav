package ru.ifmo.rain.astrans.asttomodel;

public interface ITransformationContextFactory {
	IResolver createResolver();
	ITrace createTrace();
}
