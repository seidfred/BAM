package de.seidfred.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class EntityObjectCreator<T> {

	EntityObjectAttributeValuesWrapper<?> valueWrapper;

	public EntityObjectCreator(EntityObjectAttributeValuesWrapper<?> aValueWrapper) {
		valueWrapper = aValueWrapper;
	}

	public T createObjectFor(Class<T> aClazz) {
		T tempReturn = null;
		try {
			tempReturn = aClazz.getConstructor().newInstance();

			// Field[] tempFields = aClazz.getDeclaredFields();

			Method[] tempDeclaredMethods = aClazz.getDeclaredMethods();

			for (Method tempMethod : tempDeclaredMethods) {
				if (tempMethod.getName().startsWith("set")) {
					if (tempMethod.getParameterCount() == 1) {
						for (Parameter tempParmeter : tempMethod.getParameters()) {
							tempMethod.invoke(tempReturn, valueWrapper.getAttributeValueFor(tempParmeter));
						}
					}
				}
			}
			return tempReturn;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempReturn;
	}
}
