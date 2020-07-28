package com.techelevator;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class ParkTest {
	
	/*
	 * We will return if there's time and energy later to test getters and setters.
	 */
	
	private Park testPark;

	@Before
	public void setUp(){
		testPark = new Park((long)17, "Test Park", "Michigan", LocalDate.now(), 400, 14, "Lovely test park for family and friends.");
	}

	@Test
	public void test_simple_toString() {
		String expected = testPark.getName();
		assertEquals(expected, testPark.toString());
	}
	
	@Test
	public void detailed_printout() {
		String expected = String.format("%s\n%-20s%s\n%-20s%s\n%-20s%d sq km\n%-20s%d\n\n%s", 
				testPark.getName(), "Location:", testPark.getLocation(), "Established:", testPark.getEstablish_date().toString(),
				"Area:", testPark.getArea(), "Annual Visitors:", testPark.getVisitors(), testPark.getDescription());
		String actual = testPark.getParkDetails();
		assertEquals(expected, actual);
	}
	
	@Test
	public void identical_parks_are_identical() {
		Park actual = new Park(testPark.getName());
		actual.setArea(testPark.getArea());
		actual.setDescription(testPark.getDescription());
		actual.setEstablish_date(testPark.getEstablish_date());
		actual.setLocation(testPark.getLocation());
		actual.setPark_id(testPark.getPark_id());
		actual.setVisitors(testPark.getVisitors());
		
		assertEquals(testPark.getArea(), actual.getArea());
		assertEquals(testPark.getDescription(), actual.getDescription());
		assertEquals(testPark.getEstablish_date(), actual.getEstablish_date());
		assertEquals(testPark.getLocation(), actual.getLocation());
		assertEquals(testPark.getName(), actual.getName());
		assertEquals(testPark.getPark_id(), actual.getPark_id());
		assertEquals(testPark.getVisitors(), actual.getVisitors());
	}
	
	@Test
	public void different_parks_are_different() {
		Park actual = new Park(testPark.getName());
		actual.setArea(testPark.getArea());
		actual.setDescription(testPark.getDescription());
		actual.setEstablish_date(testPark.getEstablish_date());
		actual.setLocation(testPark.getLocation());
		actual.setPark_id((long)16);
		actual.setVisitors(testPark.getVisitors());
		
		assertNotEquals(testPark, actual);
	}

}
