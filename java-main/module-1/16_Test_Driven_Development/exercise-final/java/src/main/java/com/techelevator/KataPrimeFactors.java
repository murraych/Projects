package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class KataPrimeFactors {

	public int[] factorize(int number) {
		List<Integer> primeFactors = new ArrayList<>();
		if (number > 1) {
			int i = 2;
			while (i <= number) {
				if (number % i == 0) {
					primeFactors.add(i);
					number /= i;
					i = 2;
				} else {
					i++;
				}
			}
		}
		return primeFactors.stream().mapToInt(j -> j).toArray();
	}

}
