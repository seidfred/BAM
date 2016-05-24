package de.seidfred.bam.model.attribute;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import de.seidfred.bam.rdm.StringValueObject;

@Embeddable
@AttributeOverride(name = "value", column = @Column(name = "NAME"))
public class AccountName extends StringValueObject {
	private static final long serialVersionUID = 1L;

	public AccountName() {
		super();
	}

	public AccountName(String aValue) {
		super(aValue);
	}
}
