package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public abstract class UuidValueObject extends AbstractSimpleValueObject<String> {
	private static final long serialVersionUID = 1L;

	@Column(length = 36)
	String value;

	public UuidValueObject() {
		super();
		setValue(UUID.randomUUID().toString());
	}

	public UuidValueObject(String aValue) {
		super();
		setValue(aValue);
	}

	private void setValue(String aValue) {
		value = aValue;
	}

	@Override
	public String getValue() {
		return value;
	}
}