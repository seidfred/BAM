package de.seidfred.bam.model.attribute;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import de.seidfred.bam.rdm.StringValueObject;

@Embeddable
@AttributeOverride(name = "value", column = @Column(name = "DESCRIPTION"))
public class Description extends StringValueObject {
	private static final long serialVersionUID = 1L;

	public Description() {
		super();
	}

	public Description(String aValue) {
		super(aValue);
	}

}
