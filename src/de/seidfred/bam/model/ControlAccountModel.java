package de.seidfred.bam.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.seidfred.bam.model.entity.Account;

public class ControlAccountModel {

	private Account account;
	private StringProperty subAccountName = new SimpleStringProperty();

	public ControlAccountModel(Account anAccount) {
		account = anAccount;
		subAccountName.set(anAccount.getName().getValue());
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account aAccount) {
		account = aAccount;
	}

	public final StringProperty subAccountNameProperty() {
		return subAccountName;
	}

	public final String getSubAccountName() {
		return subAccountNameProperty().get();
	}

	public final void setSubAccountName(String aSubAccountName) {
		subAccountNameProperty().set(aSubAccountName);
	}

	@Override
	public String toString() {
		return subAccountName.get();
	}

}
