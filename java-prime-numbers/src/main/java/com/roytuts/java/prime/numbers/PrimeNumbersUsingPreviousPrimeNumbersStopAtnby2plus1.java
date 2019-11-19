package com.roytuts.java.prime.numbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersUsingPreviousPrimeNumbersStopAtnby2plus1 {

	public static void main(String[] args) {
		printPrimeUpto(1000);
	}

	public static void printPrimeUpto(int num) {
		String sep = "";
		int i = 2;

		List<Integer> primeNumbers = new ArrayList<>();
		primeNumbers.add(2);

		while (i <= num) {
			if (isPrime(i, primeNumbers)) {
				if (i != 2)
					primeNumbers.add(i);
				System.out.print(sep);
				System.out.print(i);
				sep = ", ";
			}
			i++;
		}
	}

	public static boolean isPrime(int num, List<Integer> primeNumbers) {
		if (num == 2) {
			return true;
		}
		for (int i = 0; i < primeNumbers.size() / 2 + 1; i++) {
			if (num % primeNumbers.get(i) == 0) {
				return false;
			}
		}
		return true;
	}

}
