package de.seidfred.bam.model.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import de.seidfred.bam.model.attribute.TransactionAmount;

public class AccountTest {

	@Test
	public void test() {
		Account serviceUnderTest = new Account();

		serviceUnderTest.addNewTransaction(createTransaction(10));
		serviceUnderTest.addNewTransaction(createTransaction(20));
		serviceUnderTest.addNewTransaction(createTransaction(30));
		serviceUnderTest.addNewTransaction(createTransaction(40));
		serviceUnderTest.addNewTransaction(createTransaction(50));

		assertEquals(new BigDecimal(150), serviceUnderTest.calculateTotalMainAccountAmount());
	}

	private Transaction createTransaction(Integer anAmount) {
		Transaction tempTransaction = new Transaction();
		tempTransaction.setAmount(new TransactionAmount(new BigDecimal(anAmount)));
		return tempTransaction;
	}
}
