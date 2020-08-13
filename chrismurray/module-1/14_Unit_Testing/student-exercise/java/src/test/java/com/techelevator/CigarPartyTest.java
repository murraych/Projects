package com.techelevator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CigarPartyTest {
	
	CigarParty cigarParty = new CigarParty();

	@Test
	public void notEnoughCigarsForParty() {
		assertFalse(cigarParty.haveParty(30,  false));
		assertFalse(cigarParty.haveParty(10, true));
		assertFalse(cigarParty.haveParty(75, false));
	}
	
	@Test
	public void cigarsInRangeNotWeekend() {
		assertTrue(cigarParty.haveParty(50, false));
		assertTrue(cigarParty.haveParty(48, false));
	}
	
	@Test
	public void cigardsInRangeIsWeekend() {
		assertTrue(cigarParty.haveParty(55, true));
		assertTrue(cigarParty.haveParty(90, true));
	}

}
