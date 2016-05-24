package de.seidfred.bam.view.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import de.seidfred.bam.dao.account.AccountDAO;
import de.seidfred.bam.model.ControlAccountModel;
import de.seidfred.bam.model.attribute.AccountName;
import de.seidfred.bam.model.attribute.Description;
import de.seidfred.bam.model.entity.Account;
import de.seidfred.bam.view.general.Datastore;

public class CreateBankAccountController {
	@FXML
	private TextField name;
	@FXML
	private ComboBox<ControlAccountModel> mainAccount;
	@FXML
	private TextArea description;

	private Stage dialogStage;
	private Account selectedMainAccount;
	private Boolean savedClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		initMainAccountComobobox();
		initMainAccountComboboxData();
	}

	private void initMainAccountComobobox() {
		mainAccount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ControlAccountModel>() {
			@Override
			public void changed(ObservableValue<? extends ControlAccountModel> aObservable,
					ControlAccountModel aOldValue, ControlAccountModel aNewValue) {
				if (aNewValue != null) {
					selectedMainAccount = aNewValue.getAccount();
				}
			}
		});
	}

	private void initMainAccountComboboxData() {
		mainAccount.getItems().clear();
		mainAccount.setPromptText("");
		mainAccount.getItems().addAll(Datastore.getInstance().getAllMainAccountComboboxData());
	}

	public void setDialogStage(Stage aDialogStage) {
		dialogStage = aDialogStage;
	}

	public Boolean isSavedClicked() {
		return savedClicked;
	}

	@FXML
	private void handleSave() {
		savedClicked = true;
		System.out.println(savedClicked);
		System.out.println(selectedMainAccount);

		Account tempAccountToSave = new Account();
		tempAccountToSave.setName(new AccountName(name.getText()));
		tempAccountToSave.setDescription(new Description(description.getText()));
		if (selectedMainAccount != null) {
			tempAccountToSave.setMainAccount(selectedMainAccount);
		}

		if (AccountDAO.getInstance().isAccountExisting(tempAccountToSave)) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Account existing");
			alert.setContentText("Account: " + tempAccountToSave.getName() + " is already existing.");
			alert.showAndWait();
		} else {
			AccountDAO.getInstance().createNewAccount(tempAccountToSave);
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancelDialog() {
		dialogStage.close();
	}
}
