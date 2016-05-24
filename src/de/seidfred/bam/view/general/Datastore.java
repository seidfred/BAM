package de.seidfred.bam.view.general;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.seidfred.bam.dao.account.AccountDAO;
import de.seidfred.bam.model.ControlAccountModel;
import de.seidfred.bam.model.ModelConverter;
import de.seidfred.bam.model.entity.Account;

public class Datastore {

	private static Datastore instance;
	private Map<Account, ObservableList<ControlAccountModel>> cachedSubAccountModels = new HashMap<Account, ObservableList<ControlAccountModel>>();
	private ObservableList<ControlAccountModel> cachedMainAccountModels = FXCollections.observableArrayList();

	private Datastore() {
		// Exists only to defeat instantiation.
	}

	public static Datastore getInstance() {
		if (instance == null) {
			instance = new Datastore();
		}
		return instance;
	}

	public List<ControlAccountModel> getSubAccountComboboxData(Account aAccount) {
		ObservableList<ControlAccountModel> tempSubAccountModels;
		tempSubAccountModels = cachedSubAccountModels.get(aAccount);
		if (tempSubAccountModels == null) {
			tempSubAccountModels = FXCollections.observableArrayList();
			tempSubAccountModels.addAll(new ModelConverter().convertAccountsToSubAccountModels(AccountDAO.getInstance()
					.getChildAccountsBy(aAccount)));

			cachedSubAccountModels.put(aAccount, tempSubAccountModels);
		}

		return tempSubAccountModels;
	}

	public List<ControlAccountModel> getAllMainAccountComboboxData() {
		if (cachedMainAccountModels.isEmpty()) {
			cachedMainAccountModels.addAll(new ModelConverter().convertAccountsToSubAccountModels(AccountDAO
					.getInstance().getAllMainAccounts()));
		}

		return cachedMainAccountModels;
	}
}
