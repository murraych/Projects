package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataPrimeFactorsTest {

	@Test
	public void factorize_Negative_1_Returns_Empty_Array_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(-1)", new int[] {}, kpf.factorize(-1));
	}

	@Test
	public void factorize_1_Returns_Empty_Array_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(1)", new int[] {}, kpf.factorize(1));
	}

	@Test
	public void factorize_2_Returns_2_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(2)", new int[] { 2 }, kpf.factorize(2));
	}

	@Test
	public void factorize_3_Returns_3_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(3)", new int[] { 3 }, kpf.factorize(3));
	}

	@Test
	public void factorize_6_Returns_2_3_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(6)", new int[] { 2, 3 }, kpf.factorize(6));
	}

	@Test
	public void factorize_7_Returns_7_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(7)", new int[] { 7 }, kpf.factorize(7));
	}

	@Test
	public void factorize_8_Returns_2_2_2_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(8)", new int[] { 2, 2, 2 }, kpf.factorize(8));
	}

	@Test
	public void factorize_More_Prime_Numbers_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(11)", new int[] { 11 }, kpf.factorize(11));
		assertArrayEquals("KataPrimeFactors.factorize(11)", new int[] { 13 }, kpf.factorize(13));
		assertArrayEquals("KataPrimeFactors.factorize(11)", new int[] { 17 }, kpf.factorize(17));
		assertArrayEquals("KataPrimeFactors.factorize(193)", new int[] { 193 }, kpf.factorize(193));
		assertArrayEquals("KataPrimeFactors.factorize(5209)", new int[] { 5209 }, kpf.factorize(5209));
		assertArrayEquals("KataPrimeFactors.factorize(7919)", new int[] { 7919 }, kpf.factorize(7919));
	}

	@Test
	public void factorize_More_Non_Prime_Numbers_Test() {
		KataPrimeFactors kpf = new KataPrimeFactors();
		assertArrayEquals("KataPrimeFactors.factorize(21)", new int[] { 3, 7 }, kpf.factorize(21));
		assertArrayEquals("KataPrimeFactors.factorize(99)", new int[] { 3, 3, 11 }, kpf.factorize(99));
		assertArrayEquals("KataPrimeFactors.factorize(256)", new int[] { 2, 2, 2, 2, 2, 2, 2, 2 }, kpf.factorize(256));
		assertArrayEquals("KataPrimeFactors.factorize(2044)", new int[] { 2, 2, 7, 73 }, kpf.factorize(2044));
		assertArrayEquals("KataPrimeFactors.factorize(7777)", new int[] { 7, 11, 101 }, kpf.factorize(7777));
		assertArrayEquals("KataPrimeFactors.factorize(8192)", new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
				kpf.factorize(8192));
	}
}
