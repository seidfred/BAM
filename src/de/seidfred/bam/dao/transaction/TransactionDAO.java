package de.seidfred.bam.dao.transaction;

import com.mysema.query.jpa.impl.JPADeleteClause;

import de.seidfred.bam.dao.BamDAO;
import de.seidfred.bam.model.entity.QTransaction;
import de.seidfred.bam.model.entity.Transaction;

public class TransactionDAO extends BamDAO {

	public void saveNewTransaction(Transaction aTransaction) {
		em.getTransaction().begin();
		em.persist(aTransaction);
		em.getTransaction().commit();
	}

	public Long deleteTransaction(Transaction aTransation) {
		em.getTransaction().begin();
		long tempNumberDeletedEntries = new JPADeleteClause(em, QTransaction.transaction).where(
				QTransaction.transaction.id.value.eq(aTransation.getId().getValue())).execute();
		em.getTransaction().commit();
		return tempNumberDeletedEntries;
		// em.getTransaction().commit();
	}
}
