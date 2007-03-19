package ru.ifmo.rain.astrans.asttomodel.resolver;

import astrans.AstransFactory;
import astrans.CreateClass;
import astrans.CreatedEClass;

public class CreatedClasses extends SingleClassifierNamespace<CreatedEClass, CreateClass>{

	@Override
	protected CreatedEClass createReference(CreateClass value) {
		CreatedEClass result = AstransFactory.eINSTANCE.createCreatedEClass();
		result.setCreate(value);
		return result;
	}

	@Override
	protected String getName(CreateClass value) {
		return value.getName();
	}

}
