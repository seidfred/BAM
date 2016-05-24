package de.seidfred.bam.model;

import java.math.BigDecimal;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.seidfred.bam.model.entity.Account;

public class MainAccountTableModel {

	private Account account;

	private StringProperty mainAccountName = new SimpleStringProperty();
	private StringProperty mainAccountDescription = new SimpleStringProperty();
	private ObjectProperty<BigDecimal> mainAccountTotalAmount = new SimpleObjectProperty<BigDecimal>();

	public MainAccountTableModel(Account anAccount) {
		super();
		account = anAccount;
		mainAccountName.set(anAccount.getName().getValue());
		mainAccountDescription.set(anAccount.getDescription().getValue());
		mainAccountTotalAmount.set(anAccount.calculateTotalMainAccountAmount());
	}

	public final String getMainAccountName() {
		return mainAccountName.get();
	}

	public final void setMainAccountName(String aMainAccountName) {
		mainAccountName.set(aMainAccountName);
	}

	public StringProperty getMainAccountNameProperty() {
		return mainAccountName;
	}

	public final String getMainAccountDescription() {
		return mainAccountDescription.get();
	}

	public final void setMainAccountDescription(String aMainAccountName) {
		mainAccountName.set(aMainAccountName);
	}

	public StringProperty getMainAccountDescriptionProperty() {
		return mainAccountDescription;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account aAccount) {
		account = aAccount;
	}

	public ObjectProperty<BigDecimal> getMainAccountTotalAmount() {
		return mainAccountTotalAmount;
	}

	public void setMainAccountTotalAmount(SimpleObjectProperty<BigDecimal> aMainAccountTotalAmount) {
		mainAccountTotalAmount = aMainAccountTotalAmount;
	}
}
