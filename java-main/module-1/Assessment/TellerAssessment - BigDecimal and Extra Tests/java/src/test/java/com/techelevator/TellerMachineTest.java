package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TellerMachineTest {

	@Test
	public void testBalanceWhereDepositsAre1000AndWithdrawalsAre500() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertEquals(BigDecimal.valueOf(500.00), tellerMachine.getBalance());
	}
	
	@Test
	public void testBalanceWhereDepositsAre500AndWithdrawalsAre1000() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(500.00), BigDecimal.valueOf(1000));
		
		assertEquals(BigDecimal.valueOf(-500.00), tellerMachine.getBalance());
	}
	@Test
	public void testBalanceWhereDepositsAre0AndWithdrawalsAre0() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
		
		assertEquals(BigDecimal.valueOf(0), tellerMachine.getBalance());
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith5AndIs16Digits() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertTrue(tellerMachine.checkCardNumber("5111111111111111"));
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith5AndIs4Digits() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertFalse(tellerMachine.checkCardNumber("51111111111111"));
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith4AndIs13Digits() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertTrue(tellerMachine.checkCardNumber("4111111111111"));
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith4AndIs16Digits() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertTrue(tellerMachine.checkCardNumber("4111111111111111"));
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith4AndIs1Digit() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertFalse(tellerMachine.checkCardNumber("4"));
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith3AndIsFollowedBy4() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertTrue(tellerMachine.checkCardNumber("3411111111111"));
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith3AndIsFollowedBy7() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertTrue(tellerMachine.checkCardNumber("3711111111111"));
	}
	
	@Test
	public void testcarNumberWhereNumberStartsWith3AndIsNotFollowedBy4() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertFalse(tellerMachine.checkCardNumber("3111111111111"));
	}
	
	
	@Test
	public void testcarNumberWhereNumberStartsWith1AndIs16Digits() {

		TellerMachine tellerMachine = new TellerMachine("My Bank", BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500));
		
		assertFalse(tellerMachine.checkCardNumber("1111111111111111"));
	}

}
