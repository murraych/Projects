package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonStartTest {

	NonStart nonStart = new NonStart();
	
	@Test
	public void getPartialStringLengthIs5() {
		assertEquals("ellohere", nonStart.getPartialString("Hello", "There"));
		assertEquals("avaode", nonStart.getPartialString("Java", "Code"));
		assertEquals("hotlava", nonStart.getPartialString("shotl", "java"));
	}
	
	@Test
	public void getPartialStringALength0() {
		assertEquals("here", nonStart.getPartialString("", "There"));
	}
	
	@Test
	public void getPartialStringBLength0() {
		assertEquals("here", nonStart.getPartialString("There", ""));
	}

}
