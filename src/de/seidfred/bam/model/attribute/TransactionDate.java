package de.seidfred.bam.model.attribute;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import de.seidfred.bam.rdm.DateValueObject;

@Embeddable
@AttributeOverride(name = "value", column = @Column(name = "DATE"))
public class TransactionDate extends DateValueObject {
	private static final long serialVersionUID = 1L;

	public TransactionDate() {
		super();
	}

	public TransactionDate(Date aValue) {
		super(aValue);
	}

}
