package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class KataPrimeFactors {

	public List<Integer> factorize(int n) {

		List<Integer> primeNumbers = new ArrayList<>();

//		if (n < 2) {
//			return primeNumbers;
//		} else {
//
//			for (int i = 2; i <= n; i++) {
//				if (n % i == 0) {
//					primeNumbers.add(i);
//					n /= 2;
//					i--;
//				}
//			}
//
//		}
		for (int i = 2; i < n; i++) {
			while (n % i == 0) {
				primeNumbers.add(i);
				n = n / i;
			}
		}

		if (n >= 2) {
			primeNumbers.add(n);
		}

		return primeNumbers;

	}
}
