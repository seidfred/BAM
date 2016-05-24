package de.seidfred.bam.model;

import java.math.BigDecimal;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.seidfred.bam.model.attribute.AccountName;
import de.seidfred.bam.model.entity.Transaction;

public class TransactionModel {

	private Transaction transaction;
	private StringProperty subAccountName = new SimpleStringProperty();
	private StringProperty transactionDate = new SimpleStringProperty();
	private StringProperty usage = new SimpleStringProperty();
	private ObjectProperty<BigDecimal> transactionAmount = new SimpleObjectProperty<BigDecimal>();

	TransactionModel(AccountName anAccountName, Transaction aTransaction) {
		transaction = aTransaction;
		subAccountName.set(anAccountName.getValue());
		transactionDate.set(aTransaction.getDate().toString());
		transactionAmount.set(aTransaction.getAmount().getValue());
		usage.set(aTransaction.getUsage().getValue());
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction aTransaction) {
		transaction = aTransaction;
	}

	public final StringProperty getUsageProperty() {
		return usage;
	}

	public final String getUsage() {
		return getUsageProperty().get();
	}

	public final void setUsage(final String anUsage) {
		getUsageProperty().set(anUsage);
	}

	public final ObjectProperty<BigDecimal> getTransactionAmountProperty() {
		return transactionAmount;
	}

	public final BigDecimal getTransactionAmount() {
		return getTransactionAmountProperty().get();
	}

	public final void setTransactionAmoiunt(final BigDecimal aTransactionAmount) {
		getTransactionAmountProperty().set(aTransactionAmount);
	}

	public final StringProperty getTransactionDateProperty() {
		return transactionDate;
	}

	public final String getTransactionDate() {
		return getTransactionDateProperty().get();
	}

	public final void setTransactionDate(final String transactionDate) {
		getTransactionDateProperty().set(transactionDate);
	}

	public final StringProperty getSubAccountNameProperty() {
		return subAccountName;
	}

	public final String getSubAccountName() {
		return getSubAccountNameProperty().get();
	}

	public final void setSubAccountName(String aSubAccountName) {
		getSubAccountNameProperty().set(aSubAccountName);
	}
}
