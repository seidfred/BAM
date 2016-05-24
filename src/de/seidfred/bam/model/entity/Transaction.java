package de.seidfred.bam.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.seidfred.bam.model.attribute.Identity;
import de.seidfred.bam.model.attribute.TransactionAmount;
import de.seidfred.bam.model.attribute.TransactionDate;
import de.seidfred.bam.model.attribute.Usage;

@Entity
@Table(name = "ACCOUNT_TRANSACTION")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Identity id = new Identity();

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Account account;

	@Embedded
	private TransactionDate date;

	@Embedded
	private TransactionAmount amount;

	@Embedded
	private Usage usage;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account aAccount) {
		account = aAccount;
	}

	public TransactionDate getDate() {
		return date;
	}

	public void setDate(TransactionDate aDate) {
		date = aDate;
	}

	public TransactionAmount getAmount() {
		return amount;
	}

	public void setAmount(TransactionAmount anAmount) {
		amount = anAmount;
	}

	public Usage getUsage() {
		return usage;
	}

	public void setUsage(Usage aUsage) {
		usage = aUsage;
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
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getId().toString() + " - " + getAccount().toString();
	}

}
