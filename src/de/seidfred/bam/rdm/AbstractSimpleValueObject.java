package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;

public abstract class AbstractSimpleValueObject<T extends Comparable<T>>
		implements Serializable, Comparable<AbstractSimpleValueObject<T>> {

	private static final long serialVersionUID = 1L;

	public abstract T getValue();

	public Boolean isNullOrEmpty() {
		if (getValue() == null || getValue().toString().isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public boolean isGreaterThan(
			AbstractSimpleValueObject<T> anOtherSimpleValueObject) {
		return this.compareTo(anOtherSimpleValueObject) > 0;
	}

	@Override
	public String toString() {
		if (getValue() == null) {
			return "";
		}
		return "" + getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getValue() == null) ? 0 : getValue().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		AbstractSimpleValueObject<T> other = (AbstractSimpleValueObject<T>) obj;
		if (getValue() == null) {
			if (other.getValue() != null) {
				return false;
			}
		} else if (!getValue().equals(other.getValue())) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(AbstractSimpleValueObject<T> aSimpleValueObject) {
		return ObjectUtils.compare(getValue(), aSimpleValueObject.getValue());
	}
}