package core;

public class OverloadSupport {

	public static final OverloadSupport INSTANCE = new OverloadSupport();
	
	private OverloadSupport() {		
	}
	
	public boolean areTypesSuitable(IType[] formalArguments, IType[] actualArguments) {
		if (formalArguments.length != actualArguments.length) {
			return false;
		}
		
		for (int i = 0; i < actualArguments.length; i++) {
			if (!actualArguments[i].conformsTo(formalArguments[i])) {
				return false;
			}
		}
		
		return true;
	}
}
