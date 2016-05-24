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
public abstract class ShortValueObject extends AbstractSimpleValueObject<Short> {
	private static final long serialVersionUID = 1L;

	@Column
	Short value;

	public ShortValueObject() {
		super();
	}

	public ShortValueObject(Short aValue) {
		super();
		setValue(aValue);
	}

	private void setValue(Short aValue) {
		value = aValue;
	}

	@Override
	public Short getValue() {
		return value;
	}

	public String getFormat() {
		return "";
	}

	@Override
	public String toString() {
		if (isNullOrEmpty()) {
			return "";
		}
		return new DecimalFormat(getFormat()).format(getValue());
	}
}