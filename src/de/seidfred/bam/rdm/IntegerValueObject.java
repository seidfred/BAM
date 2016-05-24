package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public abstract class IntegerValueObject extends
		AbstractSimpleValueObject<Integer> {
	private static final long serialVersionUID = 1L;

	@Column
	Integer value;

	@Override
	public Integer getValue() {
		return value;
	}

	private void setValue(Integer aValue) {
		value = aValue;
	}

	public String getFormat() {
		return "";
	}

	public IntegerValueObject() {
		super();
	}

	public IntegerValueObject(Integer aValue) {
		super();
		setValue(aValue);
	}

	@Override
	public String toString() {
		if (isNullOrEmpty()) {
			return "";
		}
		return new DecimalFormat(getFormat()).format(getValue());
	}

}