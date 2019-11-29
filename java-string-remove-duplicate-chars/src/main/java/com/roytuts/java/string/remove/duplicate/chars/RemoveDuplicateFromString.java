package com.roytuts.java.string.remove.duplicate.chars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateFromString {

	public static void main(String[] args) {
		System.out.println(removeDuplicateUsingHashSet("roytuts"));
		System.out.println(removeDuplicateUsingLinkedHashSet("roytuts"));
		System.out.println(removeDuplicateUsingDistinct("roytuts"));
		System.out.println(removeDuplicateUsingSorting("roytuts"));
		System.out.println(removeDuplicateUsingIndexOf("roytuts"));
		System.out.println(removeDuplicateUsingCharArray("roytuts"));
	}

	private static String removeDuplicateUsingHashSet(String str) {
		Set<String> finalStr = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			finalStr.add(String.valueOf(str.charAt(i)));
		}

		List<String> list = new ArrayList<>(finalStr);

		return String.join("", list);
	}

	private static String removeDuplicateUsingLinkedHashSet(String str) {
		Set<String> finalStr = new LinkedHashSet<>();

		for (int i = 0; i < str.length(); i++) {
			finalStr.add(String.valueOf(str.charAt(i)));
		}

		List<String> list = new ArrayList<>(finalStr);

		return String.join("", list);
	}

	private static String removeDuplicateUsingDistinct(String str) {
		StringBuilder sb = new StringBuilder();
		// StringBuffer sb = new StringBuffer();

		str.chars().distinct().forEach(c -> sb.append((char) c));

		return sb.toString();
	}

	private static String removeDuplicateUsingSorting(String str) {
		StringBuilder sb = new StringBuilder();
		// StringBuffer sb = new StringBuffer();

		char[] chars = str.toCharArray();

		Arrays.sort(chars);

		sb.append(chars[0]);

		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != chars[i - 1]) {
				sb.append(chars[i]);
			}
		}

		return sb.toString();
	}

	private static String removeDuplicateUsingIndexOf(String str) {
		StringBuilder sb = new StringBuilder();
		// StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int anotherIndexOfCh = str.indexOf(ch, i + 1);
			if (anotherIndexOfCh == -1) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	private static String removeDuplicateUsingCharArray(String str) {
		StringBuilder sb = new StringBuilder();
		// StringBuffer sb = new StringBuffer();

		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			boolean repeatedCharFound = false;

			for (int j = i + 1; j < chars.length; j++) {
				if (chars[i] == chars[j]) {
					repeatedCharFound = true;
					break;
				}
			}

			if (!repeatedCharFound) {
				sb.append(chars[i]);
			}
		}

		return sb.toString();
	}

}
