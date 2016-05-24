package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public abstract class StringValueObject extends
		AbstractSimpleValueObject<String> {
	private static final long serialVersionUID = 1L;

	@Column
	String value;

	public StringValueObject() {
		super();
	}

	public StringValueObject(String aValue) {
		super();
		setValue(aValue);
	}

	protected void setValue(String aValue) {
		value = aValue;
	}

	@Override
	public String getValue() {
		return value;
	}
}