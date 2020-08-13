package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataPrimeFactorsTest {
	
	KataPrimeFactors myKataPrimeFactors = new KataPrimeFactors();
	
	@Test
	public void factorizeAcceptsNumber_1() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(1));
	}

	
	@Test
	public void factorizeAcceptsNumber_2() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(2);
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(2));
	}

	
	@Test
	public void factorizeAcceptsNumber_3() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(3);
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(3));
	}
	
	
	@Test
	public void factorizeAcceptsNumber_4() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(2);
		primeFactorList.add(2);
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(4));
	}

	@Test
	public void factorizeAcceptsNumber_6() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(2);
		primeFactorList.add(3);
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(6));
	}
	
	@Test
	public void factorizeAcceptsNumber_7() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(7);
	
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(7));
	}
	
	@Test
	public void factorizeAcceptsNumber_8() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(2);
		primeFactorList.add(2);
		primeFactorList.add(2);
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(8));
	}
	
	@Test
	public void factorizeAcceptsNumber_9() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(3);
		primeFactorList.add(3);
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(9));
	}

	@Test
	public void factorizeAcceptsNumber_10() {
		List<Integer> primeFactorList = new ArrayList<>();
		
		primeFactorList.add(2);
		primeFactorList.add(5);
		assertEquals(primeFactorList, myKataPrimeFactors.factorize(10));
	}
	
}
