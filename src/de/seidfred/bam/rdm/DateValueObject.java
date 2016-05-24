package de.seidfred.bam.rdm;

//
// Copyright:
// RSC Commercial Services GmbH & Co. OHG, Duesseldorf (Germany)
// All rights reserved.
//

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public abstract class DateValueObject extends AbstractSimpleValueObject<Date> {
	private static final long serialVersionUID = 1L;

	@Column
	@Temporal(TemporalType.DATE)
	Date value;

	public DateValueObject() {
		super();
	}

	public DateValueObject(Date aDate) {
		super();
		setValue(aDate);
	}

	@Override
	public Date getValue() {
		if (value != null) {
			return (Date) value.clone();
		}
		return null;
	}

	private void setValue(Date aDate) {
		if (aDate == null) {
			value = null;
		} else {
			value = fixDate(aDate);
		}
	}

	@Override
	public String toString() {
		if (isNullOrEmpty()) {
			return "";
		}
		return getDateFormat().format(getValue());
	}

	public static SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat("dd-MM-yyyy");
	}

	Date fixDate(Date aDate) {
		Calendar tempCalendar = new GregorianCalendar();
		tempCalendar.setTime(aDate);
		tempCalendar.set(Calendar.HOUR_OF_DAY, 0);
		tempCalendar.set(Calendar.MINUTE, 0);
		tempCalendar.set(Calendar.SECOND, 0);
		tempCalendar.set(Calendar.MILLISECOND, 0);
		return tempCalendar.getTime();
	}
}