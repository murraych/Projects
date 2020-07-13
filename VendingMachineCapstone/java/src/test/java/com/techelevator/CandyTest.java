package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandyTest {

	@Test
	public void doesCandyReturnSound() {
		Candy testCandy = new Candy("A1", "Test Candy", 0);
		assertEquals("Munch Munch, Yum!", testCandy.getSound());
	}

}
