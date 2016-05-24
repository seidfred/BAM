package de.seidfred.bam.dao.account;

import java.util.List;

import org.apache.openjpa.persistence.OpenJPAEntityManager;
import org.apache.openjpa.persistence.OpenJPAPersistence;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

import de.seidfred.bam.dao.BamDAO;
import de.seidfred.bam.model.attribute.AccountName;
import de.seidfred.bam.model.entity.Account;
import de.seidfred.bam.model.entity.QAccount;

public class AccountDAO extends BamDAO {

	private static final QAccount ACCOUNT = QAccount.account;
	private static AccountDAO instance;

	public static AccountDAO getInstance() {
		if (instance == null) {
			instance = new AccountDAO();
		}
		return instance;
	}

	public List<Account> findAllAccounts() {
		return new JPAQuery(em).from(ACCOUNT).list(ACCOUNT);
	}

	public boolean isAccountExisting(Account anAccount) {
		BooleanBuilder tempConditions = new BooleanBuilder();

		if (anAccount.getMainAccount() != null) {
			tempConditions.and(ACCOUNT.mainAccount.id.value.eq(anAccount.getMainAccount().getId().getValue()));
		}

		tempConditions.and(ACCOUNT.name.value.eq(anAccount.getName().getValue()));

		long tempResult = new JPAQuery(em).from(ACCOUNT).where(tempConditions).count();

		return tempResult >= (long) 1;
	}

	public void createNewAccount(Account anAccount) {
		if (isAccountExisting(anAccount)) {
			throw new RuntimeException("Account is existing!");
		}

		em.getTransaction().begin();
		em.persist(anAccount);
		em.getTransaction().commit();

	}

	public Account mergeAccount(Account anAccount) {
		em.getTransaction().begin();
		Account tempMergedAccount = em.merge(anAccount);
		em.getTransaction().commit();

		return tempMergedAccount;
	}

	public List<Account> getAllMainAccounts() {
		OpenJPAEntityManager tempCastedEm = OpenJPAPersistence.cast(em);
		tempCastedEm.getFetchPlan().addFetchGroup("accountWithChilds");
		tempCastedEm.getFetchPlan().addFetchGroup("accountWithTransactions");
		return new JPAQuery(em).from(ACCOUNT).where(ACCOUNT.mainAccount.isNull()).list(ACCOUNT);
	}

	public List<Account> getChildAccountsBy(Account aMainAccount) {
		BooleanBuilder tempConditions = new BooleanBuilder();

		tempConditions.and(ACCOUNT.mainAccount.id.value.eq(aMainAccount.getId().getValue()));

		return new JPAQuery(em).from(ACCOUNT).where(tempConditions).list(ACCOUNT);
	}

	public Account getAccountBy(AccountName aName) {
		Account foundAccount = null;

		BooleanBuilder tempConditions = new BooleanBuilder();
		JPAQuery tempQuery = new JPAQuery(em);

		tempConditions.and(ACCOUNT.name.value.eq(aName.getValue()));

		List<Account> tempResultList = tempQuery.from(ACCOUNT).where(tempConditions).list(ACCOUNT);

		if (!tempResultList.isEmpty()) {
			foundAccount = tempResultList.get(0);
		}

		return foundAccount;
	}

	public Account getFullLoadedAccount(AccountName aName) {
		Account foundAccount = null;

		OpenJPAEntityManager tempCastedEm = OpenJPAPersistence.cast(em);
		tempCastedEm.getFetchPlan().addFetchGroup("accountWithChilds");
		tempCastedEm.getFetchPlan().addFetchGroup("accountWithTransactions");

		BooleanBuilder tempConditions = new BooleanBuilder();
		JPAQuery tempQuery = new JPAQuery(tempCastedEm);

		tempConditions.and(ACCOUNT.name.value.eq(aName.getValue()));

		List<Account> tempResultList = tempQuery.from(ACCOUNT).where(tempConditions).list(ACCOUNT);

		if (!tempResultList.isEmpty()) {
			foundAccount = tempResultList.get(0);
		}

		tempCastedEm.detach(foundAccount);

		return foundAccount;
	}

}
