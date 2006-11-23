import ru.ifmo.rain.breslav.deferred.DComposite;
import ru.ifmo.rain.breslav.deferred.DObject;
import ru.ifmo.rain.breslav.deferred.ResolveFailedException;


public class DeferredBytes extends DComposite<Byte[]> {

	private final Byte[] values;
	private final DObject<Byte>[] deferredValues;
	private int count = 0;
	
	@SuppressWarnings("unchecked")
	public DeferredBytes(int size) {
		values = new Byte[size];
		deferredValues = new DObject[size];
	}
	
	public void add(byte b) {
		values[count] = b;
		int index = count;
		count++;
		if (deferredValues[index] != null) {
			resolveChild(deferredValues[index]);
		}		                                    
	}
	
	public DObject<Byte> get(final int i) {
		deferredValues[i] = new DObject<Byte>() {
			@Override
			protected Byte doResolve() throws ResolveFailedException {
				if (count <= i) {
					throw new ResolveFailedException();
				}
				return values[i];
			}
		};
		return deferredValues[i];		
	}

	public boolean isResolved() {
		return count == values.length;
	}

	@Override
	protected Byte[] doResolve() throws ResolveFailedException {
		throw new ResolveFailedException();
	}
	

}
