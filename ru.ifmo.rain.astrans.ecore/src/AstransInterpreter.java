import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import astrans.Action;
import astrans.Attribute;
import astrans.CreateClass;
import astrans.CreatedEClass;
import astrans.EClassifierReference;
import astrans.ExistingEClass;
import astrans.ExistingEDataType;
import astrans.MapClass;
import astrans.MappedEClass;
import astrans.Reference;
import astrans.SkipClass;
import astrans.StructuralFeature;
import astrans.Transformation;
import astrans.TranslateReferences;
import astrans.util.AstransSwitch;


/*
 * Features to be supported:
 *   1. Translate types of containment references
 *   2. Change inheritance
 *   3. Test everything
 */
public class AstransInterpreter {

	private class TransformationSwitch extends AstransSwitch {
		
		@Override
		public Object caseTransformation(Transformation transformation) {
			assert transformation != null;

			EList actions = transformation.getActions();
			for (Iterator iter = actions.iterator(); iter.hasNext();) {
				Action action = (Action) iter.next();
				doSwitch(action);
			}
			return NULL;
		}
		
	}
	
	private final class Creator extends TransformationSwitch {
		
		public void run() {
			for (Action action : createActions) {
				doSwitch(action);
			}
		}
		
		@Override
		public EClass caseMapClass(MapClass action) {
			EClass proto = action.getProto();
			assert proto != null;
			
			EClass image = EcoreFactory.eINSTANCE.createEClass();
			mapTrace.put(proto, image);
			mapActionTrace.put(action, image);
			
			classes.add(image);
			return image;
		}

		@Override
		public EClass caseCreateClass(CreateClass action) {
			EClass result = EcoreFactory.eINSTANCE.createEClass();
			createActionTrace.put(action, result);
		
			classes.add(result);
			return result;
		}
	}

	private final class ReferenceTranslator extends TransformationSwitch {
		
		public void run() {
			for (TranslateReferences action : translateActions) {
				doSwitch(action);
			}
		}
		
		private EClassifier translateReferenceType(EClass eClass) {
			EClassifier result = mapTrace.get(eClass);
			for (TranslateReferences action : translateActions) {
				EClass modelReferenceTypeProto = action.getModelReferenceTypeProto();
				boolean applicable;
				if (action.isIncludeDescendants()) {
					applicable = modelReferenceTypeProto.isSuperTypeOf(eClass);
				} else {
					applicable = modelReferenceTypeProto == eClass;
				}
				if (applicable) {
					EClassifier textualReferenceType = (EClassifier) referenceResolver.doSwitch(action.getTextualReferenceType());
					result = textualReferenceType;
					break;
				}
			}
			
			if (result == null) {
				result = eClass;
			}
			
			System.out.println(eClass.getName() + " => " + result.getName());
			
			return result;
		}

		@Override
		public Object caseTranslateReferences(TranslateReferences action) {
			assert action != null;
			
			EClass modelReferenceTypeProto = action.getModelReferenceTypeProto();
			EClassifierReference textualReferenceType = action.getTextualReferenceType();
			
			referenceMap.put(modelReferenceTypeProto, (EClassifier) referenceResolver.doSwitch(textualReferenceType));
			
			return NULL;
		}
		
	}

	private final AstransSwitch referenceResolver = new AstransSwitch() {
		
		@Override
		public EClass caseExistingEClass(ExistingEClass reference) {
			assert reference != null;
		
			return reference.getEClass();
		}

		@Override
		public EClass caseMappedEClass(MappedEClass reference) {
			assert reference != null;
		
			EClass result = mapActionTrace.get(reference.getMapping());
			assert result != null;
			return result;
		}

		@Override
		public EClass caseCreatedEClass(CreatedEClass reference) {
			assert reference != null;
		
			EClass result = createActionTrace.get(reference.getCreate());
			assert result != null;
			return result;
		}

		@Override
		public EDataType caseExistingEDataType(ExistingEDataType reference) {
			return reference.getEDataType();
		}

	};
	
	private final class Composer extends TransformationSwitch {

		public void run() {
			for (Action action : createActions) {
				doSwitch(action);
			}
		}
		
		@Override
		public Object caseMapClass(MapClass action) {
			EClass image = mapActionTrace.get(action);
			assert image != null;
			
			EClass proto = action.getProto();
			assert proto != null;
			
			image.setName(proto.getName() + "AS");
			image.setAbstract(proto.isAbstract());
			image.getEStructuralFeatures().addAll(EcoreUtil.copyAll(proto.getEAttributes()));
			
			EList references = proto.getEReferences();
			for (Iterator iter = references.iterator(); iter.hasNext();) {
				EReference eReference = (EReference) iter.next();
				EStructuralFeature feature = createReferenceFeature(
												(EClass) eReference.getEType(), 
												eReference.isContainment());
				image.getEStructuralFeatures().add(feature);
				feature.setName(eReference.getName());
				feature.setLowerBound(eReference.getLowerBound());
				feature.setUpperBound(eReference.getUpperBound());
			}
			
			EList superTypes = proto.getESuperTypes();
			for (Iterator iter = superTypes.iterator(); iter.hasNext();) {
				EClass eClass = (EClass) iter.next();
				image.getESuperTypes().add(mapTrace.get(eClass));
			}
			
			return NULL;
		}

		@Override
		public Object caseCreateClass(CreateClass action) {
			EClass result = createActionTrace.get(action);
			assert result != null;			
			
			result.setName(action.getName());
			
			EList structuralFeatures = action.getStructuralFeatures();
			for (Iterator iter = structuralFeatures.iterator(); iter.hasNext();) {
				StructuralFeature feature = (StructuralFeature) iter.next();
				result.getEStructuralFeatures().add(doSwitch(feature));
			}
			
			EList superclasses = action.getSuperclasses();
			for (Iterator iter = superclasses.iterator(); iter.hasNext();) {
				EClassifierReference reference = (EClassifierReference) iter.next();
				result.getESuperTypes().add(referenceResolver.doSwitch(reference));
			}
			
			return NULL;
		}

		@Override
		public EAttribute caseAttribute(Attribute attribute) {
			assert attribute != null;
			
			EAttribute result = EcoreFactory.eINSTANCE.createEAttribute();
			result.setName(attribute.getName());
			result.setLowerBound(attribute.getLowerBound());
			result.setUpperBound(attribute.getUpperBound());
			result.setEType(attribute.getType());
			return result;
		}

		@Override
		public EStructuralFeature caseReference(Reference reference) {
			assert reference != null;
		
			EClass resolvedType = (EClass) referenceResolver.doSwitch(reference.getType());
			boolean containment = reference.isContainment();
			EStructuralFeature result = createReferenceFeature(resolvedType, containment);
			
			result.setName(reference.getName());
			result.setLowerBound(reference.getLowerBound());
			result.setUpperBound(reference.getUpperBound());
			
			return result;
		}

		private EStructuralFeature createReferenceFeature(EClass resolvedType, boolean containment) {
			EClassifier calculatedType = referenceTranslator.translateReferenceType(resolvedType);
			assert calculatedType != null;
			
			EStructuralFeature result;
			if (calculatedType instanceof EClass) {
				EReference ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setContainment(containment);
				result = ref;
			} else {
				result = EcoreFactory.eINSTANCE.createEAttribute();
			}
			assert result != null;
			result.setEType(calculatedType);
			return result;
		}

	}

	private final Collection<Action> createActions = new ArrayList<Action>(); 
	private final Collection<TranslateReferences> translateActions = new ArrayList<TranslateReferences>(); 
	private final Collection<SkipClass> skipActions = new ArrayList<SkipClass>();
	
	private final Map<EClass, EClass> mapTrace = new HashMap<EClass, EClass>();
	private final Map<MapClass, EClass> mapActionTrace = new HashMap<MapClass, EClass>();
	private final Map<CreateClass, EClass> createActionTrace = new HashMap<CreateClass, EClass>();
	private final Map<EClass, EClassifier> referenceMap = new HashMap<EClass, EClassifier>();

	private List<EClass> classes = new ArrayList<EClass>();
	
	private final AstransSwitch actionSorter = new TransformationSwitch() {
		@Override
		public Object caseCreateClass(CreateClass object) {
			createActions.add(object);
			return NULL;
		}
		
		@Override
		public Object caseMapClass(MapClass object) {
			createActions.add(object);
			return NULL;
		}
		
		@Override
		public Object caseSkipClass(SkipClass object) {
			skipActions.add(object);
			return NULL;
		}
		
		@Override
		public Object caseTranslateReferences(TranslateReferences object) {
			translateActions.add(object);
			return NULL;
		}
	};

	private final Creator creator = new Creator();
	
	private final ReferenceTranslator referenceTranslator = new ReferenceTranslator();
	
	private final Composer composer = new Composer();

	private static final Object NULL = new Object();
	
	private void removeSkipped() {
		Collection<EClass> superClasses = new HashSet<EClass>();
		for (SkipClass skipAction : skipActions) {
			classes.remove(mapTrace.get(skipAction.getTargetProto()));
			if (skipAction.isIncludeDescendants()) {
				superClasses.add(skipAction.getTargetProto());
			}
		}
		for (Iterator<EClass> iter = mapTrace.keySet().iterator(); iter.hasNext();) {
			EClass eClass = iter.next();
			for (EClass superClass : superClasses) {
				if (superClass.isSuperTypeOf(eClass)) {
					classes.remove(mapTrace.get(eClass));
					break;
				}
			}
		}
	}
	
	public Collection<EClass> run(Transformation transformation) {
		classes.clear();
		actionSorter.doSwitch(transformation);
		creator.run();
		referenceTranslator.run();
		composer.run();
		removeSkipped();
		ArrayList<EClass> arrayList = new ArrayList<EClass>(classes);
		classes.clear();
		return arrayList;
	}
}
