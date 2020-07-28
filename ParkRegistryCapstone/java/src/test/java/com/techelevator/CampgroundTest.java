package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CampgroundTest {
	
	private Campground testCamp;
	private static final long CAMPGROUND_ID = (long)17;
	private static final long PARK_ID = (long)21;
	private static final String NAME = "Four Bears";
	private static final String START_MONTH = "05";
	private static final String END_MONTH = "09";
	private static final BigDecimal DAILY_FEE = new BigDecimal("50");

	@Before
	public void setUp() {
		testCamp = new Campground(CAMPGROUND_ID, PARK_ID, NAME, START_MONTH, END_MONTH, DAILY_FEE);
	}

	@Test
	public void testStringPrintout() {
		String expected = String.format("%-30s%-15s%-15s$%.2f", NAME, "May", "September", DAILY_FEE);
		String actual = testCamp.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void sameCampgroundsAreSame() {
		Campground actual = new Campground(testCamp.getcampgroundId(),
				testCamp.getparkId(), testCamp.getName(), testCamp.getopenFromMm(),
				testCamp.getopenToMm(), testCamp.getdailyFee());
		assertEquals(testCamp.getcampgroundId(), actual.getcampgroundId());
		assertEquals(testCamp.getparkId(), actual.getparkId());
		assertEquals(testCamp.getName(), actual.getName());
		assertEquals(testCamp.getopenFromMm(), actual.getopenFromMm());
		assertEquals(testCamp.getopenToMm(), actual.getopenToMm());
		assertEquals(testCamp.getdailyFee(), actual.getdailyFee());
	}
	
	@Test
	public void diffCampgroundsAreDiff() {
		Campground actual = new Campground(testCamp.getcampgroundId(),
				testCamp.getparkId(), "Five Bears", testCamp.getopenFromMm(),
				testCamp.getopenToMm(), testCamp.getdailyFee());
		assertNotEquals(testCamp, actual);
	}

}
