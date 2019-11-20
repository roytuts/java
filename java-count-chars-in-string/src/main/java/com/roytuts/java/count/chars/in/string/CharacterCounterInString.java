package com.roytuts.java.count.chars.in.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCounterInString {

	public static void main(String[] args) {
		Map<String, Integer> cMap = countChars("Hello World");
		cMap.forEach((k, v) -> System.out.println(k + " => " + v));
	}

	public static Map<String, Integer> countChars(final String str) {
		// Map<String, Integer> cMap = new HashMap<>();
		Map<String, Integer> cMap = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			String s = str.substring(i, i + 1);
			if (s == null || " ".equals(s)) {
				continue;
			}
			if (cMap.get(s) != null) {
				cMap.put(s, cMap.get(s) + 1);
			} else {
				cMap.put(s, 1);
			}
		}
		return cMap;
	}

	public static Map<String, Integer> countCharsInString(final String str) {
		// Map<String, Integer> cMap = new HashMap<>();
		Map<String, Integer> cMap = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			String s = str.substring(i, i + 1);
			if (s == null || " ".equals(s)) {
				continue;
			}
			if (cMap.get(s) != null) {
				cMap.put(s, cMap.get(s) + 1);
			} else {
				cMap.put(s, 1);
			}
		}
		return cMap;
	}

}
