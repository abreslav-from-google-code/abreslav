package ru.ifmo.rain.astrans.asttomodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;

import ru.ifmo.rain.astrans.asttomodel.resolver.CreatedClasses;
import ru.ifmo.rain.astrans.asttomodel.resolver.Resolver;
import ru.ifmo.rain.astrans.utils.EMFHelper;
import astrans.AstransFactory;
import astrans.AstransPackage;
import astrans.Attribute;
import astrans.CreateClass;
import astrans.Reference;
import astrans.SkipClass;
import astrans.Transformation;
import astrans.TranslateReferences;
import astransast.AttributeAS;
import astransast.ChangeInheritanceAS;
import astransast.CreateClassAS;
import astransast.EPackagePath;
import astransast.EPackageUri;
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
			transformation.setOutputName(transformationAS.getOutputName());
			transformation.setOutputNsURI(transformationAS.getOutputNsURI());
			
			AstransastSwitch ePackageResolver = new AstransastSwitch() {
				@Override
				public Object caseEPackageUri(EPackageUri object) {
					return EPackage.Registry.INSTANCE.getEPackage(object.getUri());
				}
				
				@Override
				public Object caseEPackagePath(EPackagePath object) {
					Resource resource = EMFHelper.getXMIResource(EcorePackage.eINSTANCE, object.getPath());
					try {
						EMFHelper.loadResourceFromFile(resource, fileResolver.getFile(object.getPath()));
					} catch (IOException e) {
						throw new IllegalArgumentException(e);
					}
					return resource.getContents().get(0);
				}
			};			
			transformation.setInput((EPackage) ePackageResolver.doSwitch(transformationAS.getInput()));
			
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
	
	private final Resolver resolver = new Resolver(AstransPackage.eINSTANCE, createdClasses);
	
	private final List<Runnable> commands = new ArrayList<Runnable>();
	
	private final FileResolver fileResolver; 
	
	public AstransASTToModelTransformation(final FileResolver fileResolver) {
		this.fileResolver = fileResolver;
	}

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
