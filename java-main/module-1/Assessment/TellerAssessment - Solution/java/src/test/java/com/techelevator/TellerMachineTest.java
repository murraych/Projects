package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TellerMachineTest {

	@Test
	public void testBalanceWithDepositOf1400AndWithDrawalOf400Returns1000() {
		TellerMachine tellerMachine = new TellerMachine ("Your bank", 1400.00, 400.00);
		
		assertEquals(1000.00, tellerMachine.getBalance(), 0.00001);
	}

	
	@Test
	public void testBalanceWithDepositOf400AndWithDrawalOf1000ReturnsNegative600() {
		TellerMachine tellerMachine = new TellerMachine ("Your bank", 400.00, 1000.00);
		
		assertEquals(-600.00, tellerMachine.getBalance(), 0.00001);
	}
	
	@Test
	public void testIsValidCardNumberStartWith5AndLengthIs16() {
		TellerMachine tellerMachine = new TellerMachine ("Your bank", 1400.00, 400.00);
		
		assertTrue(tellerMachine.isValidCardNumber("5111111111111111"));
	}
	
	@Test
	public void testIsValidCardNumberStartWith5AndLengthIs14() {
		TellerMachine tellerMachine = new TellerMachine ("Your bank", 1400.00, 400.00);
		
		assertFalse(tellerMachine.isValidCardNumber("51111111111111"));
	}
}
