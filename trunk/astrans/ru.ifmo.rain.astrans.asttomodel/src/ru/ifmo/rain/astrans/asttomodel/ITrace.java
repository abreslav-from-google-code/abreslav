package ru.ifmo.rain.astrans.asttomodel;

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

public interface ITrace {

	void transformationCreated(TransformationAS transformationAS, Transformation transformation);

	void attributeCreated(AttributeAS attributeAS, Attribute attribute);

	void referenceCreated(ReferenceAS referenceAS, Reference reference);

	void createClassCreated(CreateClassAS createClassAS, CreateClass createClass);

	void skipClassCreated(SkipClassAS skipClassAS, SkipClass skipClass);

	void translateReferencesCreated(TranslateReferencesAS translateReferencesAS, TranslateReferences translateReferences);

	void changeInheritanceCreated(ChangeInheritanceAS changeInheritanceAS, ChangeInheritance changeInheritance);

}
