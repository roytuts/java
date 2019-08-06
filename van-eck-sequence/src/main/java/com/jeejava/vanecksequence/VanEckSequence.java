package com.jeejava.vanecksequence;

import java.util.HashMap;
import java.util.Map;

public class VanEckSequence {

	public static void main(String[] args) {
		System.out.println("Van Eck Sequence upto 100: " + vanEckSequence(100));
		System.out.println();
		System.out.println("Van Eck Sequence upto 1000: " + vanEckSequence(1000));
	}

	public static String vanEckSequence(int range) {
		int distance = 0;
		int nextNumber = 0;
		String sequence = "";
		Map<Integer, Integer> numberMap = new HashMap<>();

		for (int i = 0; i < range; i++) {
			if (numberMap.containsKey(nextNumber)) {
				distance = i - numberMap.get(nextNumber);
			} else {
				distance = 0;
			}

			numberMap.put(nextNumber, i);
			sequence += nextNumber + ", ";
			nextNumber = distance;
		}

		return sequence;
	}

}
