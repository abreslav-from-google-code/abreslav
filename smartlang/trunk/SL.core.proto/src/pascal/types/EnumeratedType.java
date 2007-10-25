package pascal.types;

import core.Instance;

public class EnumeratedType extends OrdinalType {

	private final Instance[] literals;
	private final String[] literalNames;

	public EnumeratedType(String... literalNames) {
		this.literalNames = literalNames.clone();
		this.literals = new Instance[literalNames.length];
		for (int i = 0; i < literals.length; i++) {
			literals[i] = super.createInstance(i);
		}
	}
	
	public String getLiteralName(Instance literal) {
		assert literal.getType().conformsTo(this);
		
		return literalNames[F_THIS.readValue(literal)];
	}
	
	@Override
	public Instance createInstance(Integer value) {
		assert value >= 0;
		assert value < literals.length;
		
		return literals[value];
	}

	public Instance getHigh() {
		return literals[literals.length - 1];
	}

	public Instance getLow() {
		return literals[0];
	}

}
