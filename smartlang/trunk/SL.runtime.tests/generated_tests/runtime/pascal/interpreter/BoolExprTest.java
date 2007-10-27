package runtime.pascal.interpreter;

import org.junit.Test;
import static org.junit.Assert.*;

import pascal.types.*;
import runtime.SimpleEvaluatorContext;
import runtime.tree.IVisitHandler;
import runtime.tree.expressions.*;
import runtime.tree.statements.*;
import core.*;

public class BoolExprTest {

	private static final class Unit {
		Instance t;
		Instance f;
		Instance a;
		
		@SuppressWarnings("static-access")
		public Integer get_t() {
			return BooleanType.BOOLEAN.F_THIS.readValue(t);
		}

		@SuppressWarnings("static-access")
		public Integer get_f() {
			return BooleanType.BOOLEAN.F_THIS.readValue(f);
		}

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
				new FieldDescriptor(BooleanType.BOOLEAN, "t", this) {
				
					public Instance readValue(Instance host) {
						return field.readValue(host).t;
					}
				
					public void writeValue(Instance host, Instance value) {
						field.readValue(host).t = value;
					}
				},
				new FieldDescriptor(BooleanType.BOOLEAN, "f", this) {
				
					public Instance readValue(Instance host) {
						return field.readValue(host).f;
					}
				
					public void writeValue(Instance host, Instance value) {
						field.readValue(host).f = value;
					}
				},
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
	public void testBoolExpr() throws Exception {
		final SimpleEvaluatorContext context = new SimpleEvaluatorContext();
		final PascalInterpreter interpreter = new PascalInterpreter(context);
	
		// Creates unit type
		final UnitType unitType = new UnitType();
		final Unit unit = new Unit();
		final Instance unitInstance = unitType.createInstance(unit);
		final int unitId = context.addInstance(unitInstance);
	
		// Puts constants to the context 
		int id_false = context.addInstance(BooleanType.BOOLEAN.createInstance(0));
		int id_true = context.addInstance(BooleanType.BOOLEAN.createInstance(1));
		
		// Creates counters pool
		final VisitCounters visitCounters = new VisitCounters();
	
		// Constructs runtime tree
		Block body = RuntimeTreeNodeFactory.INSTANCE.createBlock(
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("t")
						),
						RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_true)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 5: $t == 1", unit.get_t() == 1);
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
							unitType.lookupField("f")
						),
						RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_false)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 6: $f == 0", unit.get_f() == 0);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.NOT
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							),
							BooleanType.NOT
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 8: $a == 1", unit.get_a() == 1);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.AND,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							)
						)
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.OR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 10: $a == 1", unit.get_a() == 1);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.OR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							)
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							),
							BooleanType.OR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							)
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.XOR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 13: $a == 1", unit.get_a() == 1);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							),
							BooleanType.XOR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 14: $a == 1", unit.get_a() == 1);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							),
							BooleanType.AND,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							)
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.AND,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 16: $a == 0", unit.get_a() == 0);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							),
							BooleanType.AND,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 17: $a == 0", unit.get_a() == 0);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							),
							BooleanType.OR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 18: $a == 0", unit.get_a() == 0);
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
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							),
							BooleanType.XOR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 19: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 19")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.XOR,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 20: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 20")
			),
			RuntimeTreeNodeFactory.addAfterHandler(
				RuntimeTreeNodeFactory.addAfterHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("t")
							),
							BooleanType.XOR,
							RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
								RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
									new InstanceAccess(unitId),
									unitType.lookupField("t")
								),
								BooleanType.AND,
								RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
									new InstanceAccess(unitId),
									unitType.lookupField("f")
								)
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 21: $a == 1", unit.get_a() == 1);
						}
					}
				), 
				visitCounters.addCounter(1, "line 21")
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
								RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
									new InstanceAccess(unitId),
									unitType.lookupField("t")
								),
								BooleanType.XOR,
								RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
									new InstanceAccess(unitId),
									unitType.lookupField("t")
								)
							),
							BooleanType.AND,
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("f")
							)
						)
					), 
					new IVisitHandler() {
						public void run() {
							assertTrue("line 22: $a == 0", unit.get_a() == 0);
						}
					}
				), 
				visitCounters.addCounter(1, "line 22")
			)
		);
	
		// Executes the constructed tree
		interpreter.execute(body);
		
		// Asserts on counter values
		visitCounters.assertCounters();
	}
}