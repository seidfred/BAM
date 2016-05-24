package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public abstract class TimestampValueObject extends
		AbstractSimpleValueObject<Date> {
	private static final long serialVersionUID = 1L;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Date value;

	public TimestampValueObject() {
		super();
	}

	public TimestampValueObject(Date aTimestamp) {
		super();
		setValue(aTimestamp);
	}

	@Override
	public Date getValue() {
		return value;
	}

	private void setValue(Date aTimestamp) {
		value = aTimestamp;
	}

	@Override
	public String toString() {
		if (isNullOrEmpty()) {
			return "";
		}
		return getDateFormat().format(getValue());
	}

	public static SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
}