package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public abstract class BigDecimalValueObject extends
		AbstractSimpleValueObject<BigDecimal> {
	private static final long serialVersionUID = 1L;

	@Column
	BigDecimal value;

	public BigDecimalValueObject() {
		super();
	}

	public BigDecimalValueObject(BigDecimal aValue) {
		super();
		setValue(aValue);
	}

	private void setValue(BigDecimal aValue) {
		value = aValue;
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

	public String getFormat() {
		return "0.00";
	}

	@Override
	public String toString() {
		if (isNullOrEmpty()) {
			return "";
		}
		return new DecimalFormat(getFormat()).format(getValue());
	}

}