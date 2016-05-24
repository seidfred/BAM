package de.seidfred.bam;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import de.seidfred.bam.view.controller.BankAccountOverviewController;
import de.seidfred.bam.view.controller.CreateBankAccountController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	public MainApp() {

	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Bank Account Manager");

		initRootLayout();
		showBankAccountOverview();
		showApp();
	}

	private void showApp() {
		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showBankAccountOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BankAccountOverview.fxml"));
			AnchorPane bankAccountOverview = (AnchorPane) loader.load();

			rootLayout.setCenter(bankAccountOverview);

			BankAccountOverviewController bankAccountOverviewController = loader.getController();
			bankAccountOverviewController.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens a dialog
	 */
	public boolean showCreateNewAccountDialog() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/CreateBankAccount.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			CreateBankAccountController dialogController = loader.getController();
			dialogController.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return dialogController.isSavedClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}