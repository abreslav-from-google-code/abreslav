package runtime.pascal.interpreter;

import org.junit.Test;
import static org.junit.Assert.*;

import pascal.types.*;
import runtime.SimpleEvaluatorContext;
import runtime.tree.IVisitHandler;
import runtime.tree.expressions.*;
import runtime.tree.statements.*;
import core.*;

public class IntExprTest {

	private static final class Unit {
		Instance a;
		Instance b;
		
		@SuppressWarnings("static-access")
		public Integer get_a() {
			return IntegerType.INTEGER.F_THIS.readValue(a);
		}

		@SuppressWarnings("static-access")
		public Integer get_b() {
			return IntegerType.INTEGER.F_THIS.readValue(b);
		}
	}

	private static final class UnitType extends ObjectType<Unit> {
		Instance.DataField<Unit> field = new Instance.DataField<Unit>();
	
		@Override
		protected IField[] doGetFields() {
			return new IField[] {
				new FieldDescriptor(IntegerType.INTEGER, "a", this) {
				
					public Instance readValue(Instance host) {
						return field.readValue(host).a;
					}
				
					public void writeValue(Instance host, Instance value) {
						field.readValue(host).a = value;
					}
				},
				new FieldDescriptor(IntegerType.INTEGER, "b", this) {
				
					public Instance readValue(Instance host) {
						return field.readValue(host).b;
					}
				
					public void writeValue(Instance host, Instance value) {
						field.readValue(host).b = value;
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
	public void testIntExpr() throws Exception {
		final SimpleEvaluatorContext context = new SimpleEvaluatorContext();
		final PascalInterpreter interpreter = new PascalInterpreter(context);
	
		// Creates unit type
		final UnitType unitType = new UnitType();
		final Unit unit = new Unit();
		final Instance unitInstance = unitType.createInstance(unit);
		final int unitId = context.addInstance(unitInstance);
	
		// Puts constants to the context 
		int id_1 = context.addInstance(IntegerType.INTEGER.createInstance(1));
		int id_2 = context.addInstance(IntegerType.INTEGER.createInstance(2));
		
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
						RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
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
							unitType.lookupField("b")
						),
						RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 6: $b == 2", unit.get_b() == 2);
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
							unitType.lookupField("b")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 7: $b == 1", unit.get_b() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 7")
			)
		);
	
		// Executes the constructed tree
		interpreter.execute(body);
		
		// Asserts on counter values
		visitCounters.assertCounters();
	}
}