package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateFashionTest {

	DateFashion dateFashion = new DateFashion();
	
	@Test
	public void getTableStylish8OrMore() {
		assertEquals(2, dateFashion.getATable(5, 10));
		assertEquals(2, dateFashion.getATable(9, 4));
		assertEquals(2, dateFashion.getATable(8, 10));
	}

	@Test
	public void doesNotGetTable() {
		assertEquals(0, dateFashion.getATable(2, 5));
		assertEquals(0, dateFashion.getATable(2, 9));
		assertEquals(0, dateFashion.getATable(5, 1));
	}
	
	public void maybeGetTable() {
		assertEquals(1, dateFashion.getATable(5, 5));
	}
	
}
