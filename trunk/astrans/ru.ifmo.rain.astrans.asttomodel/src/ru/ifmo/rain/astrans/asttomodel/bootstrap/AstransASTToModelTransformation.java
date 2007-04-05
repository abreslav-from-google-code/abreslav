package ru.ifmo.rain.astrans.asttomodel.bootstrap;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import ru.ifmo.rain.astrans.asttomodel.ASTToModelTransformation;
import ru.ifmo.rain.astrans.asttomodel.ITransformationContextFactory;

import astrans.AstransFactory;
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
import astransast.EClassifierReferenceAS;
import astransast.ReferenceAS;
import astransast.SkipClassAS;
import astransast.TransformationAS;
import astransast.TranslateReferencesAS;
import astransast.util.AstransastSwitch;

public class AstransASTToModelTransformation extends ASTToModelTransformation<IResolver, ITrace> {

	private final AstransastSwitch creator = new AstransastSwitch() {
		@Override
		public Transformation caseTransformationAS(final TransformationAS transformationAS) {
			final Transformation transformation = AstransFactory.eINSTANCE.createTransformation();
			transformation.setOutputName(transformationAS.getOutputName());
			transformation.setOutputNsURI(transformationAS.getOutputNsURI());
			
			addEListImageToAnotherEList(
					transformationAS.getCreateClassActions(), 
					transformation.getCreateClassActions());
			addEListImageToAnotherEList(
					transformationAS.getSkipClassActions(), 
					transformation.getSkipClassActions());
			addEListImageToAnotherEList(
					transformationAS.getTranslateReferencesActions(), 
					transformation.getTranslateReferencesActions());
			addEListImageToAnotherEList(
					transformationAS.getChangeInheritanceActions(), 
					transformation.getChangeInheritanceActions());

			getTrace().transformationCreated(transformationAS, transformation);
			
			addCommand(new Runnable() {
				public void run() {
					transformation.setInput(getResolver()
							.resolveTransformationInput(transformationAS
									.getInput()));
				}
			});
			return transformation;
		}
		
		@SuppressWarnings("unchecked")
		private void addEListImageToAnotherEList(EList source, EList dest) {
			for (Iterator iter = source.iterator(); iter.hasNext();) {
				EObject element = (EObject) iter.next();
				dest.add(doSwitch(element));
			}
		}
		
		@Override
		public Attribute caseAttributeAS(final AttributeAS attributeAS) {
			final Attribute attribute = AstransFactory.eINSTANCE.createAttribute();
			attribute.setLowerBound(attributeAS.getLowerBound());
			attribute.setUpperBound(attributeAS.getUpperBound());
			attribute.setName(attributeAS.getName());
			getTrace().attributeCreated(attributeAS, attribute);
			addCommand(new Runnable() {
				public void run() {
					attribute.setType(getResolver().resolveAttributeType(attributeAS
							.getType()));
				}
			});
			return attribute;
		}
		
		@Override
		public Reference caseReferenceAS(final ReferenceAS referenceAS) {
			final Reference reference = AstransFactory.eINSTANCE.createReference();
			reference.setLowerBound(referenceAS.getLowerBound());
			reference.setUpperBound(referenceAS.getUpperBound());
			reference.setName(referenceAS.getName());
			reference.setContainment(referenceAS.isContainment());

			getTrace().referenceCreated(referenceAS, reference);
			
			addCommand(new Runnable() {
				public void run() {
					reference.setType(getResolver().resolveReferenceType(referenceAS
							.getType()));
				}
			});			
			return reference;
		}
		
		@Override
		public CreateClass caseCreateClassAS(final CreateClassAS createClassAS) {
			final CreateClass createClass = AstransFactory.eINSTANCE.createCreateClass();
			createClass.setName(createClassAS.getName());
			createClass.setAbstract(createClassAS.isAbstract());
			
			EList structuralFeatures = createClassAS.getStructuralFeatures();
			for (Iterator iter = structuralFeatures.iterator(); iter
					.hasNext();) {
				createClass.getStructuralFeatures().add(doSwitch((EObject) iter.next()));
			}
			
			getTrace().createClassCreated(createClassAS, createClass);

			addCommand(new Runnable() {
				public void run() {
					EList superclasses = createClassAS.getSuperclasses();
					for (Iterator iter = superclasses.iterator(); iter.hasNext();) {
						EClassifierReferenceAS superClassQN = (EClassifierReferenceAS) iter.next();
						createClass.getSuperclasses().add(getResolver().resolveCreateClassSuperclass(superClassQN));
					}
				}
			});				
			return createClass;
		}
		
		@Override
		public SkipClass caseSkipClassAS(final SkipClassAS skipClassAS) {
			final SkipClass skipClass = AstransFactory.eINSTANCE.createSkipClass();
			skipClass.setIncludeDescendants(skipClassAS.isIncludeDescendants());
			getTrace().skipClassCreated(skipClassAS, skipClass);
			addCommand(new Runnable() {
				public void run() {
					skipClass.setTargetProto(getResolver()
							.resolveSkipClassTargetProto(skipClassAS
									.getTargetProto()));
				}
			});			
			return skipClass ;
		}
		
		@Override
		public TranslateReferences caseTranslateReferencesAS(final TranslateReferencesAS translateReferencesAS) {
			final TranslateReferences translateReferences = AstransFactory.eINSTANCE.createTranslateReferences();
			translateReferences.setIncludeDescendants(translateReferencesAS.isIncludeDescendants());
			
			getTrace().translateReferencesCreated(translateReferencesAS, translateReferences);
			
			addCommand(new Runnable() {
				public void run() {
					translateReferences
							.setModelReferenceTypeProto(getResolver()
									.resolveTranslateReferencesModelReferenceTypeProto(translateReferencesAS
											.getModelReferenceTypeProto()));
				}
			});			
			addCommand(new Runnable() {
				public void run() {
					translateReferences
							.setTextualReferenceType(getResolver()
									.resolveTranslateReferencesTextualReferenceType(translateReferencesAS
											.getTextualReferenceType()));
				}
			});			
			return translateReferences;
		}
		
		@Override
		public ChangeInheritance caseChangeInheritanceAS(final ChangeInheritanceAS changeInheritanceAS) {
			final ChangeInheritance changeInheritance = AstransFactory.eINSTANCE.createChangeInheritance();
			getTrace().changeInheritanceCreated(changeInheritanceAS, changeInheritance);			
			addCommand(new Runnable() {
				public void run() {
					changeInheritance.setTargetProto(
							getResolver().resolveChangeInheritanceTargetProto(
									changeInheritanceAS.getTargetProto()));
					EList superclasses = changeInheritanceAS.getSuperclasses();
					for (Iterator iter = superclasses.iterator(); iter.hasNext();) {
						EClassifierReferenceAS superclass = (EClassifierReferenceAS) iter.next();
						changeInheritance.getSuperclasses().add(getResolver().resolveChangeInheritanceSuperclass(superclass));
					}
				}
			});			
			return changeInheritance;
		}
	};
	
	public AstransASTToModelTransformation(ITransformationContextFactory<IResolver, ITrace> contextFactory) {
		super(contextFactory);
	}

	public Transformation run(TransformationAS transformationAS) {
		Transformation transformation = (Transformation) creator.doSwitch(transformationAS);
		performAllCommands();
		return transformation;
	}
}
