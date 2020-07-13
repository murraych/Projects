package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DrinkTest {

	
	
	@Test
	public void doesDrinkReturnSound() {
		Drink testDrink = new Drink("A1", "Test Drink", 0);
		assertEquals("Glug Glug, Yum!", testDrink.getSound());
	}

}
