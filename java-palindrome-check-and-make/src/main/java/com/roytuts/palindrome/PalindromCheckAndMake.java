package com.roytuts.palindrome;

public class PalindromCheckAndMake {

	public static void main(String[] args) {
		// checkAndMake(9);
		System.out.println(checkAndMake(10));
		System.out.println(checkAndMake(20));
		System.out.println(checkAndMake(150));
	}

	public static int checkAndMake(int n) {
		if (String.valueOf(n).length() < 2) {
			throw new RuntimeException("Length must be at least two digits");
		}

		int rev = 0, itr = 0;

		rev = computeReverse(n);

		if (n == rev) {
			System.out.println("Iteration: " + itr);
			return rev;
		} else {
			while (true) {
				rev = computeReverse(n);

				int num = n + rev;

				n = num;

				rev = computeReverse(num);

				if (num == rev) {
					System.out.println("Iteration: " + itr);
					return rev;
				} else {
					++itr;
				}
			}
		}
	}

	private static int computeReverse(int n) {
		int reverse = 0;

		while (n != 0) {
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			n = n / 10;
		}

		return reverse;
	}
}
