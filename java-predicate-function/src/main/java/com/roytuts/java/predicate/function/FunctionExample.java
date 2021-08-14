package com.roytuts.java.predicate.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		Function<Integer, Integer> fint = i -> i * 4;
		System.out.println(fint.apply(5));

		Function<String, Integer> fstr = s -> s.length();
		System.out.println(fstr.apply("Soumitra"));

		// Using method reference
		List<String> names = Arrays.asList("Soumitra", "Liton", "Arup", "Debabrata", "Sumit");
		Map<String, Integer> listToMap = convertListToMap(names, FunctionExample::length);
		System.out.println(listToMap);
	}

	public static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {

		Map<T, R> result = new HashMap<>();

		for (T t : list) {
			result.put(t, func.apply(t));
		}

		return result;

	}

	private static Integer length(String str) {
		return str.length();
	}
}
