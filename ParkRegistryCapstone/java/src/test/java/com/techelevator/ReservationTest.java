package com.techelevator;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class ReservationTest {

	private Reservation testReservation;
	
	@Before
	public void setUp() {
		testReservation = new Reservation((long)17210911, (long)12, "Daffy Duck", LocalDate.of(2020, 06, 19), LocalDate.parse("2020-07-01"), LocalDate.now());
//		System.out.println(testReservation);
	}
	
	@Test
	public void test_string_printout() {
		String expected = String.format("%-12s%-10s%-35s%-15s%-15s%-15s", 17210911, 12, "Daffy Duck",  
				"2020-06-19", "2020-07-01", LocalDate.now());
		
		String actual = testReservation.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void reservation_equals_reservation() {
		Reservation actual = new Reservation();
		actual.setReservationId(testReservation.getReservationId());
		actual.setSiteId(testReservation.getSiteId());
		actual.setName(testReservation.getName());
		actual.setStartDate(testReservation.getStartDate());
		actual.setReserveDate(testReservation.getReserveDate());
		
		assertEquals(testReservation.getReservationId(), actual.getReservationId());
		assertEquals(testReservation.getSiteId(), actual.getSiteId());
		assertEquals(testReservation.getName(), actual.getName());
		assertEquals(testReservation.getStartDate(), actual.getStartDate());
		assertEquals(testReservation.getReserveDate(), actual.getReserveDate());
	}
	
	@Test
	public void different_reservations_are_different() {
		Reservation actual = new Reservation();
		assertNotEquals(testReservation, actual);
	}

}
