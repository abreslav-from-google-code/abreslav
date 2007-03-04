package ru.amse.sd.visitor.visitors;

import ru.amse.sd.visitor.model.Mult;
import ru.amse.sd.visitor.model.Number;
import ru.amse.sd.visitor.model.Sum;
import ru.amse.sd.visitor.model.Value;
import ru.amse.sd.visitor.model.ValueVisitor;


public class PhraseGenerator {

	private static ValueVisitor<String, Boolean> phraser = new ValueVisitor<String, Boolean>() {

		public String visit(Sum value, Boolean data) {
			return (data ? "Сумма " : "суммы ") 
				+ value.getX().accept(this, false) 
				+ " и " 
				+ value.getY().accept(this, false);
		}

		public String visit(Mult value, Boolean data) {
			return (data ? "Произведение " : "произведения ")  
				+ value.getX().accept(this, false) 
				+ " на " 
				+ value.getY().accept(this, false);
		}

		public String visit(Number value, Boolean data) {
			return value.getValue() + "";
		}
		
	};
	
	public static String getPhrase(Value value) {
		return value.accept(phraser, true);
	}
}
