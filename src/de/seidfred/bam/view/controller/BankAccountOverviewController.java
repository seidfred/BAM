package de.seidfred.bam.view.controller;

import java.math.BigDecimal;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import de.seidfred.bam.MainApp;
import de.seidfred.bam.dao.account.AccountDAO;
import de.seidfred.bam.model.ControlAccountModel;
import de.seidfred.bam.model.MainAccountTableModel;
import de.seidfred.bam.model.ModelConverter;
import de.seidfred.bam.model.TransactionModel;
import de.seidfred.bam.model.entity.Account;
import de.seidfred.bam.view.general.Datastore;

public class BankAccountOverviewController {

	private MainApp mainApp;

	private ObservableList<MainAccountTableModel> mainAccountTableData = FXCollections.observableArrayList();
	private ObservableList<TransactionModel> transactionTableData = FXCollections.observableArrayList();

	@FXML
	private TableView<MainAccountTableModel> mainBankAccountsTable;
	@FXML
	private TableColumn<MainAccountTableModel, String> mainAccountNameColumn;
	@FXML
	private TableColumn<MainAccountTableModel, String> mainAccountDescriptionColumn;
	@FXML
	private TableColumn<MainAccountTableModel, BigDecimal> mainAccountTotalAmountColumn;
	@FXML
	private ComboBox<ControlAccountModel> subAccountFilterComboBox;
	@FXML
	private TableView<TransactionModel> transactionsTable;
	@FXML
	private TableColumn<TransactionModel, String> transactionAccountNameColumn;
	@FXML
	private TableColumn<TransactionModel, String> transactionDateColumn;
	@FXML
	private TableColumn<TransactionModel, String> transactionUsageColumn;
	@FXML
	private TableColumn<TransactionModel, BigDecimal> transactionAmountColumn;

	@FXML
	private void initialize() {
		initControls();
		initData();

		Platform.runLater(new Runnable() {
			public void run() {
				mainApp.getPrimaryStage().requestFocus();
			}
		});
	}

	private void initData() {
		initMainBankAccountsData();
	}

	private void initControls() {
		initMainBankAccountTableCells();
		initTransactionsTableCells();
		initSubAccountComobobox();
	}

	private void initSubAccountComobobox() {
		subAccountFilterComboBox.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<ControlAccountModel>() {
					@Override
					public void changed(ObservableValue<? extends ControlAccountModel> aObservable,
							ControlAccountModel aOldValue, ControlAccountModel aNewValue) {
						if (aNewValue != null) {
							initTransactionsTableData(aNewValue.getAccount());
						} else {

						}
					}
				});
	}

	private void initMainBankAccountTableCells() {
		mainAccountNameColumn.setCellValueFactory(cellData -> cellData.getValue().getMainAccountNameProperty());
		mainAccountDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getMainAccountDescriptionProperty());
		mainAccountTotalAmountColumn.setCellValueFactory(cellData -> cellData.getValue().getMainAccountTotalAmount());
		mainBankAccountsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> mainAccountTableAction(newValue.getAccount()));
	}

	private void initTransactionsTableCells() {
		transactionAccountNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSubAccountNameProperty());
		transactionDateColumn.setCellValueFactory(cellData -> cellData.getValue().getTransactionDateProperty());
		transactionUsageColumn.setCellValueFactory(cellData -> cellData.getValue().getUsageProperty());
		transactionAmountColumn.setCellValueFactory(cellData -> cellData.getValue().getTransactionAmountProperty());
	}

	public void setMainApp(MainApp aMainApp) {
		mainApp = aMainApp;
	}

	private void initMainBankAccountsData() {
		mainAccountTableData.clear();
		mainAccountTableData.addAll(new ModelConverter().convertAccountsToMainAccountTableModels(AccountDAO
				.getInstance().getAllMainAccounts()));

		mainBankAccountsTable.setItems(mainAccountTableData);
	}

	public void mainAccountTableAction(Account aAccount) {
		initSubAccountComboboxData(aAccount);
		initTransactionsTableData(aAccount);
	}

	private void initTransactionsTableData(Account anAccount) {
		transactionTableData.clear();
		transactionTableData.addAll(new ModelConverter().convertAccountToTransactionModels(anAccount));
		transactionsTable.setItems(transactionTableData);
	}

	private void initSubAccountComboboxData(Account anAccount) {
		subAccountFilterComboBox.getItems().clear();
		subAccountFilterComboBox.setPromptText("");
		subAccountFilterComboBox.getItems().addAll(Datastore.getInstance().getSubAccountComboboxData(anAccount));
	}

	@FXML
	private void mainAccountTableMouseClick(MouseEvent ME) {
		mainAccountTableAction(mainBankAccountsTable.getSelectionModel().selectedItemProperty().getValue().getAccount());
	}

	@FXML
	private void openCreateNewAccount() {
		if (mainApp.showCreateNewAccountDialog()) {
			initMainBankAccountsData();
		}
	}

}
