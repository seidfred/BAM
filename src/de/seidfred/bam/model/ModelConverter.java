package de.seidfred.bam.model;

import java.util.ArrayList;
import java.util.List;

import de.seidfred.bam.model.entity.Account;
import de.seidfred.bam.model.entity.Transaction;

public class ModelConverter {

	public List<MainAccountTableModel> convertAccountsToMainAccountTableModels(List<Account> someAccounts) {
		List<MainAccountTableModel> tempAccountModels = new ArrayList<MainAccountTableModel>();

		for (Account tempAccount : someAccounts) {
			tempAccountModels.add(new MainAccountTableModel(tempAccount));
		}

		return tempAccountModels;
	}

	public List<ControlAccountModel> convertAccountsToSubAccountModels(List<Account> someAccounts) {
		List<ControlAccountModel> tempAccountModels = new ArrayList<ControlAccountModel>();

		for (Account tempAccount : someAccounts) {
			ControlAccountModel tempSubAccountModel = new ControlAccountModel(tempAccount);
			tempAccountModels.add(tempSubAccountModel);
		}

		return tempAccountModels;
	}

	public List<TransactionModel> convertAccountToTransactionModels(Account anAccount) {
		List<TransactionModel> tempTransactionModels = new ArrayList<TransactionModel>();

		if (!anAccount.isMainAccount()) {
			for (Account tempAccount : anAccount.getChildAccounts()) {
				for (Transaction tempTransaction : tempAccount.getTransactions()) {
					tempTransactionModels.add(new TransactionModel(tempAccount.getName(), tempTransaction));
				}
			}
		} else {
			for (Transaction tempTransaction : anAccount.getTransactions()) {
				tempTransactionModels.add(new TransactionModel(anAccount.getName(), tempTransaction));
			}
		}

		return tempTransactionModels;

	}
}
