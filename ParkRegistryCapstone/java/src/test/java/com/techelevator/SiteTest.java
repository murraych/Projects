package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SiteTest {

	private Site testSite;
	
	@Before
	public void setUp() throws Exception {
		testSite = new Site();
	}

	@Test
	public void testStringPrintout() {
		String expected = String.format("%-10s%-10s%-20s%-20s%-10s%s", 
				0, 1, "No", "N/A", "N/A", "XX");
		String actual = testSite.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void sameSitesAreSame() {
		Site actual = new Site();
		// Again ignoring Site Number
		assertEquals(testSite.getCampgroundId(), actual.getCampgroundId());
		assertEquals(testSite.getHasUtilities(), actual.getHasUtilities());
		assertEquals(testSite.getMaxOccupancy(), actual.getMaxOccupancy());
		assertEquals(testSite.getMaxRVLength(), actual.getMaxRVLength());
		assertEquals(testSite.getSiteId(), actual.getSiteId());
	}
	
	@Test
	public void diffSitesAreDiff() {
		Site actual = new Site();
		actual.setAccessible(true);
		assertNotEquals(testSite, actual);
	}

}
