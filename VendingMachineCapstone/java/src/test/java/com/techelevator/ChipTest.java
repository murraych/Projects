package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChipTest {

	@Test
	public void doesChipmakesound() {
		Chip testChip = new Chip("A1", "Test Chip", 0);
		assertEquals("Crunch Crunch, Yum!", testChip.getSound());
	}

}
