package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public abstract class BooleanValueObject extends
		AbstractSimpleValueObject<Boolean> {
	private static final long serialVersionUID = 1L;

	@Column
	Boolean value;

	public BooleanValueObject() {
		super();
	}

	public BooleanValueObject(Boolean aValue) {
		super();
		setValue(aValue);
	}

	private void setValue(Boolean aValue) {
		value = aValue;
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}