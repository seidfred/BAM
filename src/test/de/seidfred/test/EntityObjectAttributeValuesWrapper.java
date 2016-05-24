package de.seidfred.test;

import java.lang.reflect.Parameter;
import java.util.List;

public interface EntityObjectAttributeValuesWrapper<T> {
	public List<T> getValuesList();

	public Object getAttributeValueFor(Parameter aParmeter);

}
