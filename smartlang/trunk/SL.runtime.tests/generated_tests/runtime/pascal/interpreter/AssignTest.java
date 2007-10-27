package runtime.pascal.interpreter;

import org.junit.Test;
import static org.junit.Assert.*;

import pascal.types.*;
import runtime.SimpleEvaluatorContext;
import runtime.tree.IVisitHandler;
import runtime.tree.expressions.*;
import runtime.tree.statements.*;
import core.*;

public class AssignTest {

	private static final class Unit {
		Instance a;
		
		@SuppressWarnings("static-access")
		public Integer get_a() {
			return IntegerType.INTEGER.F_THIS.readValue(a);
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
	public void testAssign() throws Exception {
		final SimpleEvaluatorContext context = new SimpleEvaluatorContext();
		final PascalInterpreter interpreter = new PascalInterpreter(context);
	
		// Creates unit type
		final UnitType unitType = new UnitType();
		final Unit unit = new Unit();
		final Instance unitInstance = unitType.createInstance(unit);
		final int unitId = context.addInstance(unitInstance);
	
		// Puts constants to the context 
		int id_3 = context.addInstance(IntegerType.INTEGER.createInstance(3));
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
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
							IntegerType.ADD,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 6: $a == 2", unit.get_a() == 2);
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
							IntegerType.SUB,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 7: $a == 0", unit.get_a() == 0);
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
							IntegerType.NEG
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 8: $a == -1", unit.get_a() == -1);
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
						RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 9: $a == 1", unit.get_a() == 1);
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
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2),
							IntegerType.MUL,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 10: $a == 4", unit.get_a() == 4);
						}
					}
				), 
				visitCounters.addCounter(1, "line 10")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2),
							IntegerType.DIV,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 11: $a == 1", unit.get_a() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 11")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3),
							IntegerType.DIV,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 12: $a == 1", unit.get_a() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 12")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2),
							IntegerType.DIV,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 13: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 13")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2),
							IntegerType.MOD,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 14: $a == 2", unit.get_a() == 2);
						}
					}
				), 
				visitCounters.addCounter(1, "line 14")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3),
							IntegerType.MOD,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 15: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 15")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3),
							IntegerType.MOD,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 16: $a == 1", unit.get_a() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 16")
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
							IntegerType.ADD,
							RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3),
								IntegerType.MOD,
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 17: $a == 2", unit.get_a() == 2);
						}
					}
				), 
				visitCounters.addCounter(1, "line 17")
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
							IntegerType.ADD,
							RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3),
								IntegerType.MUL,
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 18: $a == 7", unit.get_a() == 7);
						}
					}
				), 
				visitCounters.addCounter(1, "line 18")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
								IntegerType.ADD,
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_3)
							),
							IntegerType.MUL,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_2)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 19: $a == 8", unit.get_a() == 8);
						}
					}
				), 
				visitCounters.addCounter(1, "line 19")
			)
		);
	
		// Executes the constructed tree
		interpreter.execute(body);
		
		// Asserts on counter values
		visitCounters.assertCounters();
	}
}