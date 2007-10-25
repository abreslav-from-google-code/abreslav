package runtime.pascal.interpreter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pascal.types.IntegerType;
import pascal.types.OrdinalType;
import runtime.RuntimeTreeTraverser;
import runtime.SimpleEvaluatorContext;
import runtime.tree.IExpressionNode;
import runtime.tree.IStatementNode;
import runtime.tree.IVisitHandler;
import runtime.tree.expressions.FieldAccess;
import runtime.tree.expressions.FunctionCall;
import runtime.tree.expressions.InstanceAccess;
import runtime.tree.statements.Assignment;
import runtime.tree.statements.Block;
import runtime.tree.statements.If;
import runtime.tree.statements.While;
import core.FieldDescriptor;
import core.IField;
import core.IMethod;
import core.Instance;
import core.ObjectType;

public class PascalInterpreterTest {

	class Unit {
		Instance a;
	}

	private final class UnitType extends ObjectType<Unit> {
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
			} };
		}

		@Override
		protected IMethod[] doGetMethods() {
			return null;
		}

		public Instance getDefaultValue() {
			return null;
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSome() throws Exception {
		SimpleEvaluatorContext context = new SimpleEvaluatorContext();
		PascalInterpreter interpreter = new PascalInterpreter(context);
		/*
		 * a := 1; 
		 * if a > 0 then 
		 *   a := a + 1; 
		 * while a > 0 do 
		 *   a := a - 1;
		 */
		int oneId = context.addInstance(IntegerType.INTEGER.createInstance(1));
		int zeroId = context.addInstance(IntegerType.INTEGER.createInstance(0));
		UnitType unitType = new UnitType();
		Instance unit = unitType.createInstance(new Unit());
		int unitId = context.addInstance(unit);
		Block block = new Block(
				new Assignment(
						new FieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("a")
						),
						new InstanceAccess(oneId)
				),
				new If(
						new FunctionCall(
								new FieldAccess(
										new InstanceAccess(unitId),
										unitType.lookupField("a")
								),
								IntegerType.INTEGER.GT_FN,
								new InstanceAccess(zeroId)
						),
						new Assignment(
								new FieldAccess(
										new InstanceAccess(unitId),
										unitType.lookupField("a")
								),
								new FunctionCall(
										new FieldAccess(
												new InstanceAccess(unitId),
												unitType.lookupField("a")
										),
										IntegerType.INTEGER.lookupMethod(" + ").lookupFunction(IntegerType.INTEGER, IntegerType.INTEGER),
										new InstanceAccess(oneId)
								)
						),
						null
				),
				new While(
						new FunctionCall(
								new FieldAccess(
										new InstanceAccess(unitId),
										unitType.lookupField("a")
								),
								IntegerType.INTEGER.GT_FN,
								new InstanceAccess(zeroId)
						),
						new Assignment(
								new FieldAccess(
										new InstanceAccess(unitId),
										unitType.lookupField("a")
								),
								new FunctionCall(
										new FieldAccess(
												new InstanceAccess(unitId),
												unitType.lookupField("a")
										),
										IntegerType.INTEGER.lookupMethod(" - ").lookupFunction(IntegerType.INTEGER, IntegerType.INTEGER),
										new InstanceAccess(oneId)
								)
						)
				)
		);
		
		final int[] a = new int[1];
		final IVisitHandler handler = new IVisitHandler() {
			public void run() {
				a[0]++;
			}
		};

		new RuntimeTreeTraverser() {

			@Override
			protected boolean visitExpression(IExpressionNode node) {
				return false;
			}

			@Override
			protected boolean visitStatement(IStatementNode node) {
				node.setVisitHandler(handler);
				return false;
			}
			
		}.traverse(block);
		
		interpreter.execute(block);
		assertEquals(0, IntegerType.F_THIS.readValue(unitType.field.readValue(unit).a));
		assertEquals(7, a[0]);
	}
	
	@Test
	public void testGenerated() throws Exception {
		SimpleEvaluatorContext context = new SimpleEvaluatorContext();
		PascalInterpreter interpreter = new PascalInterpreter(context);
		UnitType unitType = new UnitType();
		Unit unit = new Unit();
		Instance unitInstance = unitType.createInstance(unit);
		int unitId = context.addInstance(unitInstance);
		int id_1 = context.addInstance(IntegerType.INTEGER.createInstance(1));
		int id_0 = context.addInstance(IntegerType.INTEGER.createInstance(0));

		VisitCounters visitCounters = new VisitCounters();
		
		Block body = RuntimeTreeNodeFactory.INSTANCE.createBlock(
				RuntimeTreeNodeFactory.INSTANCE.createAssignment(
					RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
						new InstanceAccess(unitId),
						unitType.lookupField("a")
					),
					RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
				),
				RuntimeTreeNodeFactory.addHandler(
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
					), 
					new IVisitHandler() {
						public void run() {
							{{
							  	assertEquals("HERE", 1, 0);
							  	if (1 > 2) {
							  	  assertEquals(1, 1);
							  	}
							  }}
						}
					}
				),
				RuntimeTreeNodeFactory.addHandler(
					RuntimeTreeNodeFactory.INSTANCE.createIf(
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("a")
							),
							OrdinalType.GT,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						),
						RuntimeTreeNodeFactory.addHandler(
							RuntimeTreeNodeFactory.INSTANCE.createAssignment(
								RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
									new InstanceAccess(unitId),
									unitType.lookupField("a")
								),
								RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
									RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
										new InstanceAccess(unitId),
										unitType.lookupField("a")
									),
									IntegerType.ADD,
									RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
								)
							), 
							visitCounters.addCounter(1, "some")
						),
						null
					), 
					visitCounters.addCounter(1, "if")
				),
				RuntimeTreeNodeFactory.addHandler(
					RuntimeTreeNodeFactory.INSTANCE.createWhile(
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("a")
							),
							OrdinalType.GT,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
						),
						RuntimeTreeNodeFactory.INSTANCE.createAssignment(
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("a")
							),
							RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
								RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
									new InstanceAccess(unitId),
									unitType.lookupField("a")
								),
								IntegerType.SUB,
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
							)
						)
					), 
					visitCounters.addCounter(1, null)
				),
				RuntimeTreeNodeFactory.INSTANCE.createIf(
					RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						OrdinalType.GT,
						RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_0)
					),
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("a")
							),
							IntegerType.ADD,
							RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1)
						)
					),
					RuntimeTreeNodeFactory.INSTANCE.createAssignment(
						RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
							new InstanceAccess(unitId),
							unitType.lookupField("a")
						),
						RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
							RuntimeTreeNodeFactory.INSTANCE.createFieldAccess(
								new InstanceAccess(unitId),
								unitType.lookupField("a")
							),
							IntegerType.ADD,
							RuntimeTreeNodeFactory.INSTANCE.createFunctionCall(
								RuntimeTreeNodeFactory.INSTANCE.createInstanceAccess(id_1),
								IntegerType.NEG
							)
						)
					)
				)
			);


		interpreter.execute(body);
		visitCounters.assertCounters();
	}
}