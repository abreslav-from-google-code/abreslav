package ru.ifmo.rain.astrans.asttomodel.bootstrap.impl;

import ru.ifmo.rain.astrans.asttomodel.ITrace;
import astrans.Attribute;
import astrans.ChangeInheritance;
import astrans.CreateClass;
import astrans.Reference;
import astrans.SkipClass;
import astrans.Transformation;
import astrans.TranslateReferences;
import astransast.AttributeAS;
import astransast.ChangeInheritanceAS;
import astransast.CreateClassAS;
import astransast.ReferenceAS;
import astransast.SkipClassAS;
import astransast.TransformationAS;
import astransast.TranslateReferencesAS;

public class TraceImpl implements ITrace {

	private final CreatedClasses createdClasses = new CreatedClasses();
	
	public void attributeCreated(AttributeAS attributeAS, Attribute attribute) {
		// TODO Auto-generated method stub

	}

	public void changeInheritanceCreated(
			ChangeInheritanceAS changeInheritanceAS,
			ChangeInheritance changeInheritance) {
		// TODO Auto-generated method stub

	}

	public void createClassCreated(CreateClassAS createClassAS,
			CreateClass createClass) {
		createdClasses.add(createClass);
	}

	public void referenceCreated(ReferenceAS referenceAS, Reference reference) {
		// TODO Auto-generated method stub

	}

	public void skipClassCreated(SkipClassAS skipClassAS, SkipClass skipClass) {
		// TODO Auto-generated method stub

	}

	public void transformationCreated(TransformationAS transformationAS,
			Transformation transformation) {
		// TODO Auto-generated method stub

	}

	public void translateReferencesCreated(
			TranslateReferencesAS translateReferencesAS,
			TranslateReferences translateReferences) {
		// TODO Auto-generated method stub

	}

	public CreatedClasses getCreatedClasses() {
		return createdClasses;
	}
	
}
