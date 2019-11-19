package com.roytuts.java.prime.numbers;

public class PrimeNumbersUsingLoopsOnly {

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
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
