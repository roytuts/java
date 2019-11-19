package com.roytuts.java.prime.numbers;

import java.util.stream.IntStream;

public class PrimeNumbersUsingIntStream {

	public static void main(String[] args) {
		printPrimeUpto(1000);
	}

	public static void printPrimeUpto(int num) {
		String sep = "";
		int i = 2;
		while (i <= num) {
			if (isPrime(i)) {
				System.out.print(sep);
				System.out.print(i);
				sep = ", ";
			}
			i++;
		}
	}

	public static boolean isPrime(int num) {
		return IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
	}

}
