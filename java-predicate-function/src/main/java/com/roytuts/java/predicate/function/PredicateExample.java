package com.roytuts.java.predicate.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<String> sp = s -> s.length() > 3;

		System.out.println(sp.test("Soumitra"));
		System.out.println(sp.test("Hi"));

		List<String> names = Arrays.asList("Soumitra", "Liton", "Arup", "Debabrata", "Sumit");
		List<String> filtered = names.stream().filter(s -> s.length() > 4).collect(Collectors.toList());
		System.out.println(filtered);

		// Using method reference
		Predicate<String> str = PredicateExample::length;
		System.out.println(str.test("Soumitra"));
		System.out.println(str.test("Arup"));
	}

	private static boolean length(String str) {
		return str.length() > 4;
	}

}
