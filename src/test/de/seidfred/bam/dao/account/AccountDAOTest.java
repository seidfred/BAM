package de.seidfred.bam.dao.account;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.seidfred.bam.model.attribute.AccountName;
import de.seidfred.bam.model.attribute.Description;
import de.seidfred.bam.model.attribute.TransactionAmount;
import de.seidfred.bam.model.attribute.TransactionDate;
import de.seidfred.bam.model.attribute.Usage;
import de.seidfred.bam.model.entity.Account;
import de.seidfred.bam.model.entity.Transaction;

public class AccountDAOTest {

	private AccountDAO accountDAO;

	@Before
	public void setup() {
		accountDAO = new AccountDAO();
	}

	// @Test
	public void testFindAllAccounts() {
		List<Account> tempAccounts = accountDAO.findAllAccounts();
		assertNotNull(tempAccounts);
	}

	// @Test
	public void testCreateNewAccount() {
		Account tempAccount = new Account();

		tempAccount.setName(new AccountName("Girokonto"));
		tempAccount.setDescription(new Description("Konto bei der Ing-Diba"));

		accountDAO.mergeAccount(tempAccount);

		assertTrue(accountDAO.findAllAccounts().size() > 0);
	}

	// @Test
	public void testMainAndChildAccounts() {
		Account tempMainAccount = new Account();
		Account tempChildAccount = new Account();
		Account tempSecondChildAccount = new Account();

		tempMainAccount.setName(new AccountName("giro"));
		tempChildAccount.setName(new AccountName("urlaub"));
		tempSecondChildAccount.setName(new AccountName("anschaffungen"));

		tempMainAccount.addNewChild(tempChildAccount);
		tempMainAccount.addNewChild(tempSecondChildAccount);

		accountDAO.mergeAccount(tempMainAccount);

		Account persistedParent = accountDAO.getAccountBy(tempMainAccount.getName());

		assertNotNull(accountDAO.getAccountBy(tempMainAccount.getName()));
		assertTrue(accountDAO.getChildAccountsBy(persistedParent).size() == 2);
	}

	// @Test
	public void testGetAllMainAccounts() {
		List<Account> tempMainAccounts = accountDAO.getAllMainAccounts();

		assertNotNull(tempMainAccounts);
		// Childrens not loaded because lazy

		for (Account tempAccount : tempMainAccounts) {
			// children loaded because of accessing them
			assertTrue(!tempAccount.getChildAccounts().isEmpty());
		}
	}

	@Test
	public void testCreateNewAccountWithTwoSubaccountsAndTransactions() {
		Account tempMainAccount = new Account();
		AccountName tempAccountName = new AccountName("MainAccount1");

		Account tempSubAccount1 = new Account();
		Account tempSubAccount2 = new Account();

		Transaction tempTransaction1 = new Transaction();
		Transaction tempTransaction2 = new Transaction();

		tempMainAccount.setName(tempAccountName);
		tempMainAccount.setDescription(new Description("Description_MainAccount1"));

		tempSubAccount1.setName(new AccountName("SubAccount1_MainAccount1"));
		tempSubAccount1.setDescription(new Description("Description_SubAccount1_MainAccount1"));

		tempTransaction1.setDate(new TransactionDate(new Date()));
		tempTransaction1.setUsage(new Usage("SubAccount1_Transaction1_Usage"));
		tempTransaction1.setAmount(new TransactionAmount(new BigDecimal("11.11")));

		tempSubAccount1.addNewTransaction(tempTransaction1);

		tempSubAccount2.setName(new AccountName("SubAccount2_MainAccount1"));
		tempSubAccount2.setDescription(new Description("Description_SubAccount2_MainAccount1"));

		tempTransaction2.setDate(new TransactionDate(new Date()));
		tempTransaction2.setUsage(new Usage("SubAccount2_Transaction2_Usage"));
		tempTransaction2.setAmount(new TransactionAmount(new BigDecimal("22.22")));

		tempSubAccount2.addNewTransaction(tempTransaction2);

		tempMainAccount.addNewChild(tempSubAccount1);
		tempMainAccount.addNewChild(tempSubAccount2);

		accountDAO.createNewAccount(tempMainAccount);

		Account tempResultAccount = accountDAO.getFullLoadedAccount(tempAccountName);

		assertNotNull("tempResultAccount should not be null", tempResultAccount);
		assertNotNull("tempResultAccount.getChildAccounts should not be null", tempResultAccount.getChildAccounts());
		assertTrue("tempResultAccount.getChildAccounts().size() should be 2", tempResultAccount.getChildAccounts()
				.size() == 2);
		assertNotNull("tempResultAccount.getChildAccounts().get(0).getTransactions should not be null",
				tempResultAccount.getChildAccounts().get(0).getTransactions());
		assertTrue("tempResultAccount.getChildAccounts().get(0).getTransactions().size() should be 1",
				tempResultAccount.getChildAccounts().get(0).getTransactions().size() == 1);
		assertNotNull("tempResultAccount.getChildAccounts().get(1).getTransactions should not be null",
				tempResultAccount.getChildAccounts().get(1).getTransactions());
		assertTrue("tempResultAccount.getChildAccounts().get(1).getTransactions().size() should be 1",
				tempResultAccount.getChildAccounts().get(1).getTransactions().size() == 1);
	}
}
