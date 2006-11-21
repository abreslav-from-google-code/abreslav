package delegation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.aspectj.lang.reflect.MethodSignature;

public class Demo<T> implements Collection<T> {

	private Collection<T> delegate = new ArrayList<T>();
	
	private static aspect Delegation {
				
		Object around(Demo obj) : (call(* Collection.*(..)) || execution(@Delegated * Demo.*(..))) && target(obj) {
			MethodSignature sig = (MethodSignature) thisJoinPoint.getSignature();
			Method method = sig.getMethod();
			
			try {
				method = obj.delegate.getClass().getMethod(method.getName(), method.getParameterTypes());
				return method.invoke(obj.delegate, thisJoinPoint.getArgs());
			} catch (Exception e) {
				System.out.println("fail");
				e.printStackTrace();
				return proceed(obj);
			}
		}
		
	}

		public boolean add(T o) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean addAll(Collection<? extends T> c) {
			// TODO Auto-generated method stub
			return false;
		}

		public void clear() {
			// TODO Auto-generated method stub
			
		}

		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		@Delegated
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
		
		public static void main(String[] args) {
			Demo<String> demo = new Demo<String>();
			demo.add("dszfsd");
			System.out.println(demo.size());
			demo.add("dszfsd");
			demo.add("dszfsd");
			demo.add("dszfsd");
			demo.add("dszfsd");
			System.out.println(demo);
		}

}
