package de.seidfred.bam.model.attribute;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import de.seidfred.bam.rdm.BigDecimalValueObject;

@Embeddable
@AttributeOverride(name = "value", column = @Column(name = "VALUE"))
public class TransactionAmount extends BigDecimalValueObject {
	private static final long serialVersionUID = 1L;

	public TransactionAmount() {
		super();
	}

	public TransactionAmount(BigDecimal aValue) {
		super(aValue);
	}

}
