package com.roytuts.java.string.palindrom;

public class JavaPalindromCheck {

	public static void main(String[] args) {
		System.out.println(isPalindromUsingIndex("ehcache"));
		System.out.println(isPalindromUsingCharAt("ehcache"));
		System.out.println(isPalindromUsingLength("ehcache"));
		System.out.println(isPalindromUsingReverse("ehcache"));
		System.out.println(isPalindromUsingHalfLength("ehcache"));
	}

	public static boolean isPalindromUsingIndex(final String str) {
		int firstIndex = 0;
		int lastIndex = str.length() - 1;

		boolean result = true;

		while (true) {

			if (firstIndex >= lastIndex) {
				break;
			}

			char first = str.charAt(firstIndex);
			char last = str.charAt(lastIndex);

			if (first != last) {
				result = false;
				break;
			}

			firstIndex++;
			lastIndex--;

		}

		return result;
	}

	public static boolean isPalindromUsingCharAt(final String str) {
		int right = 0;
		int left = 1;

		int len = str.length();

		while (str.charAt(right) == str.charAt(len - left) && left < (len / 2)) {
			left++;
			right++;
		}

		if (str.charAt(right) == str.charAt(len - left)) {
			return true;
		}

		return false;
	}

	public static boolean isPalindromUsingLength(final String str) {
		int l = str.length();
		char[] chars = new char[l];

		for (int j = l - 1; j > -1; j--) {
			chars[l - j - 1] = (str.charAt(j));
		}

		if (str.equals(String.valueOf(chars))) {
			return true;
		}

		return false;
	}

	public static boolean isPalindromUsingHalfLength(final String str) {
		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isPalindromUsingReverse(final String str) {
		StringBuilder sb = new StringBuilder(str);
		// StringBuffer sb = new StringBuffer(str);

		if (str.equals(sb.reverse().toString())) {
			return true;
		}

		return false;
	}
}
