package property;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.reflect.FieldSignature;

public aspect PropertiesAspect {

	declare warning : set(@ReadOnly * *.*) : "Assignment to a read-only property";
	
	Object around(Object obj) : get(@Property * *.*) && target(obj) {
		Field field = ((FieldSignature) thisJoinPoint.getSignature()).getField();
		Class withinType = thisJoinPointStaticPart.getSourceLocation().getWithinType();
		Method getter = findGetter(field);
		try {
			if (getter != null && withinType != field.getDeclaringClass()) {
				return getter.invoke(obj, new Object[] {});
			} else {
				return field.get(obj);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to read property" + field, e);
		}
	}

	void around(Object obj, Object value) : set(!@ReadOnly @Property * *.*) && args(value) && target(obj) {
		Field field = ((FieldSignature) thisJoinPoint.getSignature()).getField();
		Class withinType = thisJoinPointStaticPart.getSourceLocation().getWithinType();
		Method setter = findSetter(field);
		try {
			if (setter != null && withinType != field.getDeclaringClass()) {
				setter.invoke(obj, new Object[] {value});
			} else {
				field.set(obj, value);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to set property" + field, e);
		}
	}

	void around() : set(@ReadOnly @Property * *.*) {
		Field field = ((FieldSignature) thisJoinPoint.getSignature()).getField();
		throw new RuntimeException("Unable to set read only property " + field);
	}

	private Method findGetter(Field f) {
		return findMethod(f.getDeclaringClass(), "get" + methodSuffix(f), f.getType(), new Class[] {});
	}

	private Method findSetter(Field f) {
		return findMethod(f.getDeclaringClass(), "set" + methodSuffix(f), Void.TYPE, new Class[] {f.getType()});
	}

	private Method findMethod(Class container, String name, Class returnType, Class[] args) {
		try {
			Method method = container.getMethod(name, args);
			if (method.getReturnType() == returnType) {
				return method;
			}
		} catch (SecurityException e) {			
		} catch (NoSuchMethodException e) {
		}
		return null;
	}

	private String methodSuffix(Field f) {
		String name = f.getName();
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}
	
}
