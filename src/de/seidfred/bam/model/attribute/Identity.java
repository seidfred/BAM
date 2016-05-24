package de.seidfred.bam.model.attribute;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import de.seidfred.bam.rdm.UuidValueObject;

@Embeddable
@AttributeOverride(name = "value", column = @Column(name = "ID"))
public class Identity extends UuidValueObject {
	private static final long serialVersionUID = 1L;

	public Identity() {
		super();
	}

	public Identity(String aIdentity) {
		super(aIdentity);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object aObj) {
		return super.equals(aObj);
	}
}
