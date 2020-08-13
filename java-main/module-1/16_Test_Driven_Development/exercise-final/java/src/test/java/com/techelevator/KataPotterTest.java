package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataPotterTest {

	KataPotter sut;

	@Before
	public void setUp() throws Exception {
		sut = new KataPotter();
	}

	@Test
	public void testBasicPurchaseScenarios() {

		// No Books
		assertEquals(0.0, sut.getCost(new int[] {}), 0.001);

		// Individual Books
		assertEquals(8.0, sut.getCost(new int[] { 0 }), 0.001);
		assertEquals(8.0, sut.getCost(new int[] { 1 }), 0.001);
		assertEquals(8.0, sut.getCost(new int[] { 2 }), 0.001);
		assertEquals(8.0, sut.getCost(new int[] { 3 }), 0.001);
		assertEquals(8.0, sut.getCost(new int[] { 4 }), 0.001);

		// Two or More of the Same
		assertEquals(8.0 * 2, sut.getCost(new int[] { 0, 0 }), 0.001);
		assertEquals(8.0 * 3, sut.getCost(new int[] { 0, 0, 0 }), 0.001);
	}

	@Test
	public void testSimpleDiscounts() {
		assertEquals(8.0 * 2 * 0.95, sut.getCost(new int[] { 0, 1 }), 0.001);
		assertEquals(8.0 * 3 * 0.90, sut.getCost(new int[] { 0, 1, 2 }), 0.001);
		assertEquals(8.0 * 4 * 0.80, sut.getCost(new int[] { 0, 1, 2, 3 }), 0.001);
		assertEquals(8.0 * 5 * 0.75, sut.getCost(new int[] { 0, 1, 2, 3, 4 }), 0.001);
	}

	@Test
	public void testSeveralDiscounts() {
		assertEquals(8.0 + 8.0 * 2 * 0.95, sut.getCost(new int[] { 0, 0, 1 }), 0.001);
		assertEquals(8.0 + 8.0 * 3 * 0.90, sut.getCost(new int[] { 0, 0, 1, 2 }), 0.001);
		assertEquals(8.0 * 2 * 0.95 + 8.0 * 3 * 0.90, sut.getCost(new int[] { 0, 0, 1, 1, 2 }), 0.001);
		assertEquals(8.0 * 4 * 0.80 + 8.0 * 2 * 0.95, sut.getCost(new int[] { 0, 0, 1, 2, 2, 3 }), 0.001);
	}

	@Test
	public void testComplexDiscounts() {
		assertEquals(2 * (8.0 * 4 * 0.80), sut.getCost(new int[] { 0, 0, 1, 1, 2, 2, 3, 4 }), 0.001);
		assertEquals((8.0 * 5 * 0.75) + (8.0 * 3), sut.getCost(new int[] { 0, 1, 2, 3, 4, 1, 1, 1 }), 0.001); //set of 5 + 3 sets of 1
		assertEquals(3 * (8.0 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
				sut.getCost(new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4 }), 0.001);
	}

}
