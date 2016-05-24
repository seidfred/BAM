package de.seidfred.bam.dao.transaction;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysema.query.jpa.impl.JPADeleteClause;

import de.seidfred.bam.dao.account.AccountDAO;
import de.seidfred.bam.model.attribute.AccountName;
import de.seidfred.bam.model.attribute.Description;
import de.seidfred.bam.model.attribute.Identity;
import de.seidfred.bam.model.attribute.TransactionAmount;
import de.seidfred.bam.model.attribute.TransactionDate;
import de.seidfred.bam.model.attribute.Usage;
import de.seidfred.bam.model.entity.Account;
import de.seidfred.bam.model.entity.QAccount;
import de.seidfred.bam.model.entity.Transaction;
import de.seidfred.bam.persistence.BamEntityManager;

public class TransactionDAOTest {

	AccountDAO accountDao;
	TransactionDAO transactionDao;
	AccountName accountName;
	Identity accountIdentity;

	@Before
	public void setup() {
		accountDao = new AccountDAO();
		transactionDao = new TransactionDAO();

		Account tempAccount = new Account();
		tempAccount.setName(new AccountName("transactionTestAccount"));
		tempAccount.setDescription(new Description("test"));

		accountName = tempAccount.getName();
		accountIdentity = tempAccount.getId();
		accountDao.createNewAccount(tempAccount);

		Transaction tempTransaction = new Transaction();
		tempTransaction.setAmount(new TransactionAmount(new BigDecimal("99.99")));
		tempTransaction.setDate(new TransactionDate(new Date()));
		tempTransaction.setUsage(new Usage("this is Usage"));
		tempTransaction.setAccount(tempAccount);

		transactionDao.saveNewTransaction(tempTransaction);
	}

	@Test
	public void testDeleteTransacation() {
		Account tempLoadedAccount = accountDao.getFullLoadedAccount(accountName);
		assertNotNull(tempLoadedAccount);
		assertNotNull(tempLoadedAccount.getTransactions().get(0));
		assertTrue(tempLoadedAccount.getTransactions().get(0).getAmount().getValue().compareTo(new BigDecimal("99.99")) == 0);

		transactionDao.deleteTransaction(tempLoadedAccount.getTransactions().get(0));

		tempLoadedAccount = accountDao.getFullLoadedAccount(accountName);
		assertNotNull(tempLoadedAccount);
		assertNull(tempLoadedAccount.getTransactions().get(0));

	}

	@After
	public void cleanupTestdata() {
		EntityManager em = BamEntityManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		long temp = new JPADeleteClause(em, QAccount.account).where(
				QAccount.account.id.value.eq(accountIdentity.getValue())).execute();
		em.getTransaction().commit();
		em.close();
		assertTrue(temp == 1);
	}
}
