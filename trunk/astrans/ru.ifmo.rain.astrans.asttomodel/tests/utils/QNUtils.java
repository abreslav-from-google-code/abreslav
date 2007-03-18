package utils;

import astransast.AstransastFactory;
import astransast.QualifiedName;

public class QNUtils {

	public static QualifiedName createQN(String qn) {
		String[] names = qn.split("\\.");
		QualifiedName result = null;
		for (int i = names.length - 1; i >= 0; i--) {
			QualifiedName t = AstransastFactory.eINSTANCE.createQualifiedName();
			t.setName(names[i]);
			t.setSubQN(result);
			result = t;
		}		
		return result;
	}
	
	public static String toString(QualifiedName qn) {
		return qn.getName() 
			+ (qn.getSubQN() != null 
					? ("." + toString(qn.getSubQN())) 
					: "");
	}
}
