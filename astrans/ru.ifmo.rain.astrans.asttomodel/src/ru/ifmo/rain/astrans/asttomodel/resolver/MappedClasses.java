package ru.ifmo.rain.astrans.asttomodel.resolver;

import astrans.AstransFactory;
import astrans.MapClass;
import astrans.MappedEClass;

public class MappedClasses extends AbstractClassifierNamespace<MappedEClass, MapClass> {

	@Override
	protected MappedEClass createReference(MapClass value) {
		MappedEClass ref = AstransFactory.eINSTANCE.createMappedEClass();
		ref.setMapping(value);
		return ref;
	}

	@Override
	protected String getName(MapClass value) {
		return value.getProto().getName() + "AS";
	}

}
