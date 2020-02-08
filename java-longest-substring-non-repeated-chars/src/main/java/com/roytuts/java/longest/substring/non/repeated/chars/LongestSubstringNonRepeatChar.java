package com.roytuts.java.longest.substring.non.repeated.chars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestSubstringNonRepeatChar {

	public static void main(String[] args) {
		System.out.println(longestSubstring("abcdef"));
		System.out.println(longestSubstring("pwwkew"));
		System.out.println(longestSubstring("abcabcbb"));
		System.out.println(longestSubstring("abcdabfg"));
		System.out.println(longestSubstring("This is a sample text file."));
	}

	public static String longestSubstring(final String str) {
		StringBuilder string = new StringBuilder();

		List<String> strings = new ArrayList<>();

		int len = str.length();

		for (int i = 0; i < len; i++) {
			if (!" ".equals(str.substring(i, i + 1)) && !string.toString().contains(str.substring(i, i + 1))) {
				string.append(str.substring(i, i + 1));
			} else {
				strings.add(string.toString());

				string.setLength(0);

				if (!" ".equals(str.substring(i, i + 1))) {
					string.append(str.substring(i, i + 1));
				}
			}

			if (i == len - 1) {
				strings.add(string.toString());
				string.setLength(0);
			}
		}

		return strings.stream().max(Comparator.comparingInt(String::length)).get();
	}

}
