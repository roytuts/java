package com.roytuts.java.stream.filter.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamFilter {

	public static void main(String[] args) {
		// define a list of string values
		List<String> list = Arrays.asList("roytuts", "soumitra", "abc", "java", "bekar");

		// produce a result list which has only 'roytuts' or 'soumitra'
		// first filter the values
		// second collect again those values into a list
		List<String> resultList = list.stream().filter(s -> "roytuts".equals(s) || "soumitra".equals(s))
				.collect(Collectors.toList());

		resultList.forEach(s -> System.out.println(s));
		
		System.out.println("---");

		// find any value in the list of string using findAny() and if the desired value
		// is not found then return null
		String findAny = list.stream().filter(s -> "roytuts".equals(s)).findAny().orElse(null);

		System.out.println(findAny);
		System.out.println("---");

		// transform the found value into string if it is compatible
		String mapToString = list.stream().filter(s -> "roytuts".equals(s)).map(String::toString).findAny()
				.orElse(null);

		System.out.println(mapToString);
	}

}
