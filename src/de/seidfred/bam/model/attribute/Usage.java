package de.seidfred.bam.model.attribute;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import de.seidfred.bam.rdm.StringValueObject;

@Embeddable
@AttributeOverride(name = "value", column = @Column(name = "USAGE"))
public class Usage extends StringValueObject {
	private static final long serialVersionUID = 1L;

	public Usage() {
		super();
	}

	public Usage(String aValue) {
		super(aValue);
	}

}
