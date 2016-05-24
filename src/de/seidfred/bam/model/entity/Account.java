package de.seidfred.bam.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.openjpa.persistence.FetchAttribute;
import org.apache.openjpa.persistence.FetchGroup;
import org.apache.openjpa.persistence.FetchGroups;

import de.seidfred.bam.model.attribute.AccountName;
import de.seidfred.bam.model.attribute.Description;
import de.seidfred.bam.model.attribute.Identity;

@Entity
@Table(name = "ACCOUNT")
@FetchGroups({
		@FetchGroup(name = "accountWithChilds", attributes = { @FetchAttribute(name = "childAccounts"),
				@FetchAttribute(name = "mainAccount") }),
		@FetchGroup(name = "accountWithTransactions", attributes = { @FetchAttribute(name = "transactions") }) })
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Identity id = new Identity();

	@Embedded
	private AccountName name;

	@Embedded
	private Description description;

	@Column(name = "main_account")
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Account mainAccount;

	@OneToMany(mappedBy = "mainAccount", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<Account> childAccounts;

	@OneToMany(mappedBy = "account", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<Transaction> transactions;

	@OneToMany(mappedBy = "account", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<FixValues> fixValues;

	public AccountName getName() {
		return name;
	}

	public void setName(AccountName aName) {
		name = aName;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description aDescription) {
		description = aDescription;
	}

	public Account getMainAccount() {
		return mainAccount;
	}

	public void setMainAccount(Account aMainAccount) {
		mainAccount = aMainAccount;
	}

	public List<Account> getChildAccounts() {
		if (childAccounts == null) {
			childAccounts = new ArrayList<Account>();
		}

		return childAccounts;
	}

	public void setChildAccounts(List<Account> aChildAccounts) {
		childAccounts = aChildAccounts;
	}

	public Identity getId() {
		return id;
	}

	public List<Transaction> getTransactions() {
		if (transactions == null) {
			transactions = new ArrayList<Transaction>();
		}

		return transactions;
	}

	public void setTransactions(List<Transaction> aTransactions) {
		transactions = aTransactions;
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
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account: " + getId() + " - " + getName();
	}

	public void addNewChild(Account aChildAccount) {
		aChildAccount.setMainAccount(this);
		getChildAccounts().add(aChildAccount);
	}

	public void addNewTransaction(Transaction aTransaction) {
		aTransaction.setAccount(this);
		getTransactions().add(aTransaction);
	}

	public boolean isMainAccount() {
		return mainAccount != null;
	}

	public BigDecimal calculateTotalMainAccountAmount() {
		BigDecimal tempTotalAmount = new BigDecimal(0);
		for (Account tempAccount : childAccounts) {
			tempTotalAmount = tempTotalAmount.add(tempAccount.calculateTotalTransactionAmount());
		}
		return tempTotalAmount;
	}

	public BigDecimal calculateTotalTransactionAmount() {
		BigDecimal tempTotalTransactionAmount = new BigDecimal(0);
		for (Transaction tempTransaction : getTransactions()) {
			tempTotalTransactionAmount = tempTotalTransactionAmount.add(tempTransaction.getAmount().getValue());
		}
		return tempTotalTransactionAmount;
	}
}
