package ru.ifmo.rain.astrans.asttomodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import astrans.EClassReference;
import astrans.EClassifierReference;
import astransast.EClassifierReferenceAS;
import astransast.EPackageReference;
import astransast.QualifiedName;

public interface IResolver {

	EClassifierReference resolveTranslateReferencesTextualReferenceType(
			EClassifierReferenceAS textualReferenceType);

	EClass resolveTranslateReferencesModelReferenceTypeProto(
			QualifiedName modelReferenceTypeProto);

	EClass resolveSkipClassTargetProto(QualifiedName targetProto);

	EClassReference resolveCreateClassSuperclass(
			EClassifierReferenceAS superClassQN);

	EClassReference resolveReferenceType(EClassifierReferenceAS type);

	EDataType resolveAttributeType(QualifiedName type);

	EClass resolveChangeInheritanceTargetProto(QualifiedName targetProto);

	EClassReference resolveChangeInheritanceSuperclass(
			EClassifierReferenceAS superclass);

	EPackage resolveTransformationInput(EPackageReference inputAS);

}