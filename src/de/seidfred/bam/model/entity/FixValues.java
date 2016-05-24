package de.seidfred.bam.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import de.seidfred.bam.model.attribute.FixValue;
import de.seidfred.bam.model.attribute.Identity;
import de.seidfred.bam.model.enums.PeriodType;

@Entity
@Table(name = "FIX_VALUES")
public class FixValues implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Identity id = new Identity();

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Account account;

	@Embedded
	private FixValue fixValue;

	@Column(name = "type")
	@NotNull
	@Enumerated(EnumType.STRING)
	private PeriodType type;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account aAccount) {
		account = aAccount;
	}

	public FixValue getFixValue() {
		return fixValue;
	}

	public void setFixValue(FixValue aFixValue) {
		fixValue = aFixValue;
	}

	public PeriodType getType() {
		return type;
	}

	public void setType(PeriodType aType) {
		type = aType;
	}

	public Identity getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FixValues other = (FixValues) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
