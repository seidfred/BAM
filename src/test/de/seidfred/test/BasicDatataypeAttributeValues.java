package de.seidfred.test;

import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BasicDatataypeAttributeValues implements EntityObjectAttributeValuesWrapper<InterfaceDatataypeValues> {

	BasicDatataypeEnum basicDatataypeEnum;

	enum BasicDatataypeEnum implements InterfaceDatataypeValues {

		// @formatter:off
		INTEGER(new Integer(0)),
		SHORT(new Short((short)0)),
		DOUBLE(new Double(0.0)),
		STRING(new String("Test")),
		BOOLEAN(Boolean.TRUE),
		DATE(new Date()),
		BIG_DECIMAL(new BigDecimal(12345));
		// @formatter:on

		private Object objectValue;

		BasicDatataypeEnum(Object aObjectValue) {
			objectValue = aObjectValue;
		}

		public Object getObjectValue() {
			return objectValue;
		}

		public boolean isInteger() {
			return this.getObjectValue() instanceof Integer;
		}

		public boolean isShort() {
			return this.getObjectValue() instanceof Short;
		}

		public boolean isDouble() {
			return this.getObjectValue() instanceof Double;
		}

		public boolean isBoolean() {
			return this.getObjectValue() instanceof Boolean;
		}

		public boolean isString() {
			return this.getObjectValue() instanceof String;
		}

		public boolean isBigDecimal() {
			return this.getObjectValue() instanceof BigDecimal;
		}

		public boolean isDate() {
			return this.getObjectValue() instanceof Date;
		}

		public List<BasicDatataypeEnum> getValuesList() {
			return Arrays.asList(values());
		}
	}

	@Override
	public List<InterfaceDatataypeValues> getValuesList() {
		return Arrays.asList(BasicDatataypeEnum.values());
	}

	@Override
	public Object getAttributeValueFor(Parameter aParmeter) {
		if (Integer.class.isAssignableFrom(aParmeter.getType())) {
			return Integer.class.cast(BasicDatataypeEnum.INTEGER.getObjectValue());
		}
		if (Short.class.isAssignableFrom(aParmeter.getType())) {
			return Short.class.cast(BasicDatataypeEnum.SHORT.getObjectValue());
		}
		if (Double.class.isAssignableFrom(aParmeter.getType())) {
			return Double.class.cast(BasicDatataypeEnum.DOUBLE.getObjectValue());
		}
		if (String.class.isAssignableFrom(aParmeter.getType())) {
			return String.class.cast(BasicDatataypeEnum.STRING.getObjectValue());
		}
		if (Boolean.class.isAssignableFrom(aParmeter.getType())) {
			return Boolean.class.cast(BasicDatataypeEnum.BOOLEAN.getObjectValue());
		}
		if (Date.class.isAssignableFrom(aParmeter.getType())) {
			return Date.class.cast(BasicDatataypeEnum.DATE.getObjectValue());
		}
		if (BigDecimal.class.isAssignableFrom(aParmeter.getType())) {
			return BigDecimal.class.cast(BasicDatataypeEnum.BIG_DECIMAL.getObjectValue());
		}
		return null;
	}
}
