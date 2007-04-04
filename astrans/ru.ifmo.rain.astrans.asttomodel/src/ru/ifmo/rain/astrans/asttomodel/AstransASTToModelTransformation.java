package ru.ifmo.rain.astrans.asttomodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import ru.ifmo.rain.astrans.asttomodel.resolver.CreatedClasses;
import ru.ifmo.rain.astrans.asttomodel.resolver.Resolver;
import astrans.AstransFactory;
import astrans.Attribute;
import astrans.CreateClass;
import astrans.Reference;
import astrans.SkipClass;
import astrans.Transformation;
import astrans.TranslateReferences;
import astransast.AstransastPackage;
import astransast.AttributeAS;
import astransast.ChangeInheritanceAS;
import astransast.CreateClassAS;
import astransast.QualifiedName;
import astransast.ReferenceAS;
import astransast.SkipClassAS;
import astransast.TransformationAS;
import astransast.TranslateReferencesAS;
import astransast.util.AstransastSwitch;

public class AstransASTToModelTransformation {

	private final CreatedClasses createdClasses = new CreatedClasses();
	
	private final AstransastSwitch creator = new AstransastSwitch() {
		@Override
		public Transformation caseTransformationAS(TransformationAS transformationAS) {
			Transformation transformation = AstransFactory.eINSTANCE.createTransformation();
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
			return transformation;
		}
		
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
			addCommand(new Runnable() {
				public void run() {
					attribute.setType(resolver.resolveAttributeType(attributeAS
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
			addCommand(new Runnable() {
				public void run() {
					reference.setType(resolver.resolveReferenceType(referenceAS
							.getType()));
				}
			});			
			reference.setContainment(referenceAS.isContainment());
			return reference;
		}
		
		@Override
		public CreateClass caseCreateClassAS(CreateClassAS createClassAS) {
			final CreateClass createClass = AstransFactory.eINSTANCE.createCreateClass();
			createClass.setName(createClassAS.getName());
			createdClasses.add(createClass);
			createClass.setAbstract(createClassAS.isAbstract());
			
			EList superclasses = createClassAS.getSuperclasses();
			for (Iterator iter = superclasses.iterator(); iter.hasNext();) {
				final QualifiedName superClassQN = (QualifiedName) iter.next();
				addCommand(new Runnable() {
					public void run() {
						createClass.getSuperclasses().add(resolver.resolveCreateClassSuperclass(superClassQN));
					}
				});				
			}
			
			EList structuralFeatures = createClassAS.getStructuralFeatures();
			for (Iterator iter = structuralFeatures.iterator(); iter
					.hasNext();) {
				createClass.getStructuralFeatures().add(doSwitch((EObject) iter.next()));
			}
			
			return createClass;
		}
		
		@Override
		public SkipClass caseSkipClassAS(final SkipClassAS skipClassAS) {
			final SkipClass skipClass = AstransFactory.eINSTANCE.createSkipClass();
			skipClass.setIncludeDescendants(skipClassAS.isIncludeDescendants());
			addCommand(new Runnable() {
				public void run() {
					skipClass.setTargetProto(resolver
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
			addCommand(new Runnable() {
				public void run() {
					translateReferences
							.setModelReferenceTypeProto(resolver
									.resolveTranslateReferencesModelReferenceTypeProto(translateReferencesAS
											.getModelReferenceTypeProto()));
				}
			});			
			addCommand(new Runnable() {
				public void run() {
					translateReferences
							.setTextualReferenceType(resolver
									.resolveTranslateReferencesTextualReferenceType(translateReferencesAS
											.getTextualReferenceType()));
				}
			});			
			return translateReferences;
		}
		
		@Override
		public Object caseChangeInheritanceAS(ChangeInheritanceAS object) {
			return new UnsupportedOperationException();
		}
	};
	
	private final Resolver resolver = new Resolver(AstransastPackage.eINSTANCE, createdClasses);
	
	private final List<Runnable> commands = new ArrayList<Runnable>();
	
	private void addCommand(Runnable command) {
		commands.add(command);
	}
	
	private void performAllCommands() {
		for (Runnable command : commands) {
			command.run();			
		}
	}
	
	public Transformation run(TransformationAS transformationAS) {
		Transformation transformation = (Transformation) creator.doSwitch(transformationAS);
		performAllCommands();
		return transformation;
	}
	
}