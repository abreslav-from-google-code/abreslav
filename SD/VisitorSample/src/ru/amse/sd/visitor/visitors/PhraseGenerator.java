package ru.amse.sd.visitor.visitors;

import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;
import ru.amse.sd.visitor.model.ValueVisitor;


public class PhraseGenerator {

	private static final ValueVisitor<String, Boolean> PHRASER = new ValueVisitor<String, Boolean>() {

		public String visit(Sum value, Boolean first) {
			return (first ? "����� " : "����� ") 
				+ value.getX().accept(this, false) 
				+ " � " 
				+ value.getY().accept(this, false);
		}

		public String visit(Mult value, Boolean first) {
			return (first ? "������������ " : "������������ ")  
				+ value.getX().accept(this, false) 
				+ " �� " 
				+ value.getY().accept(this, false);
		}

		public String visit(Number value, Boolean data) {
			return value.getValue() + "";
		}
		
	};
	
	public static String getPhrase(Value value) {
		return value.accept(PHRASER, true);
	}
}
