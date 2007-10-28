package runtime.pascal.interpreter;

import org.junit.Test;
import static org.junit.Assert.*;

import pascal.types.*;
import runtime.contexts.SimpleEvaluatorContext;
import runtime.tree.IVisitHandler;
import runtime.tree.expressions.*;
import runtime.tree.statements.*;
import core.*;

public class ComparisonsTest {

	private static final class Unit {
		Instance a;
		
		@SuppressWarnings("static-access")
		public Integer get_a() {
			return BooleanType.BOOLEAN.F_THIS.readValue(a);
		}
	}

	private static final class UnitType extends ObjectType<Unit> {
		Instance.DataField<Unit> field = new Instance.DataField<Unit>();
	
		@Override
		protected IField[] doGetFields() {
			return new IField[] {
				new FieldDescriptor(BooleanType.BOOLEAN, "a", this) {
				
					public Instance readValue(Instance host) {
						return field.readValue(host).a;
					}
				
					public void writeValue(Instance host, Instance value) {
						field.readValue(host).a = value;
					}
				} 
			};
		}
	
		@Override
		protected IMethod[] doGetMethods() {
			return null;
		}
	
		public Instance getDefaultValue() {
			return null;
		}
	}
	
	@Test
	public void testComparisons() throws Exception {
		final SimpleEvaluatorContext context = new SimpleEvaluatorContext();
		final PascalInterpreter interpreter = new PascalInterpreter(context);
	
		// Creates unit type
		final UnitType unitType = new UnitType();
		final Unit unit = new Unit();
		final Instance unitInstance = unitType.createInstance(unit);
		final int unitId = context.addInstance(unitInstance);
	
		// Puts constants to the context 
		int id_0 = context.addInstance(IntegerType.INTEGER.createInstance(0));
		int id_1 = context.addInstance(IntegerType.INTEGER.createInstance(1));
		
		// Creates counters pool
		final VisitCounters visitCounters = new VisitCounters();
	
		// Constructs runtime tree
		Block body = RuntimeTreeNodeFactory.INSTANCE.createBlock(
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
							OrdinalType.GT,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 5: $a == 1", unit.get_a() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 5")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
							OrdinalType.GE,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 6: $a == 1", unit.get_a() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 6")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
							OrdinalType.NE,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 7: $a == 1", unit.get_a() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 7")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
							OrdinalType.EQ,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 8: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 8")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
							OrdinalType.LT,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 9: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 9")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
							OrdinalType.LE,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 10: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 10")
			)
		);
	
		// Executes the constructed tree
		interpreter.execute(body);
		
		// Asserts on counter values
		visitCounters.assertCounters();
	}
}