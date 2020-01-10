package com.roytuts.java.reverse.string.without.special.chars;

public class JavaReverseStringWithoutSpecialChar {

	public static void main(String[] args) {
		System.out.println(reverseStringWithoutSpecialChar("abcde"));
		System.out.println(reverseStringWithoutSpecialChar("a$bcd"));
	}

	public static String reverseStringWithoutSpecialChar(final String str) {
		int len = str.length() - 1;
		char[] chars = str.toCharArray();

		int i = 0;

		while (i < len) {
			char firstCh = str.charAt(i);
			char lastCh = str.charAt(len);

			if (!isAlphabet(firstCh) && !isDigit(firstCh)) {
				i++;
			} else if (!isAlphabet(lastCh) && !isDigit(lastCh)) {
				len--;
			} else {
				char temp = chars[i];
				chars[i] = chars[len];
				chars[len] = temp;
				i++;
				len--;
			}
		}

		return String.copyValueOf(chars);
	}

	private static boolean isAlphabet(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			return true;
		}

		return false;
	}

	private static boolean isDigit(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}

		return false;
	}

}
