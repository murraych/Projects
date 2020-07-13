package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

	Transaction testTransaction = new Transaction();

//	@Test
//	public void testGetBalance() {
//		assertEquals(5.0, testTransaction.getBalance(5.0), .001);
//	}

	@Test
	public void isMoneyWholeDollarAmountTestable() {
		assertTrue(testTransaction.isMoneyWholeDollarAmount(1));
		assertTrue(testTransaction.isMoneyWholeDollarAmount(2));
		assertTrue(testTransaction.isMoneyWholeDollarAmount(5));
		assertTrue(testTransaction.isMoneyWholeDollarAmount(10));
		assertFalse(testTransaction.isMoneyWholeDollarAmount(3));
		assertFalse(testTransaction.isMoneyWholeDollarAmount(4));
	}
	
	@Test
	public void feedMoneyTest() {
		assertEquals(5.0, testTransaction.feedMoney(5.0), .001);
		assertEquals(15.0, testTransaction.feedMoney(10.0), .001);
		assertEquals(22.0, testTransaction.feedMoney(7.0), .001);	
	}

	@Test
	public void testPurcahseTransaction() {
		assertEquals(testTransaction.getBalance() - 5, testTransaction.purchaseTransaction(5.0), .001);
		
	}
	
	@Test
	public void getBalanceTest() {
		testTransaction.setBalance(10);
		assertEquals(10, testTransaction.getBalance(), .001);
	}
	
}
