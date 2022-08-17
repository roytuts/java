package com.roytuts.merge.two.arrays.unique.values;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayMergeUniqueValues {

	public static void main(String[] args) {
		String[] arr1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] arr2 = new String[] { "Olivia", "Sophia", "Emma" };

		String[] arr = mergeArraysUnique1(arr1, arr2);

		System.out.println(Arrays.toString(arr));

		arr = mergeArraysUnique2(arr1, arr2);
		System.out.println(Arrays.toString(arr));

		arr = mergeArraysUnique3(arr1, arr2);
		System.out.println(Arrays.toString(arr));
	}

	public static String[] mergeArraysUnique1(String[] names1, String[] names2) {
		List<String> strings = Stream.of(names1, names2).flatMap(Stream::of).collect(Collectors.toList());

		Set<String> uniqueNames = new HashSet<String>(strings);

		String[] arr = new String[uniqueNames.size()];

		uniqueNames.toArray(arr);

		return arr;
	}

	public static String[] mergeArraysUnique2(String[] arr1, String[] arr2) {
		List<String> list = new ArrayList<>(Arrays.asList(arr1));
		list.addAll(Arrays.asList(arr2));

		Set<String> set = new HashSet<String>();
		for (String x : list) {
			set.add(x);
		}

		String[] arr = new String[set.size()];
		set.toArray(arr);

		return arr;
	}

	public static String[] mergeArraysUnique3(String[] arr1, String[] arr2) {
		String[] arr = new String[arr1.length + arr2.length];
		int count = 0;

		for (int i = 0; i < arr1.length; i++) {
			arr[i] = arr1[i];
			count++;
		}

		for (int j = 0; j < arr2.length; j++) {
			arr[count++] = arr2[j];
		}

		List<String> list = Arrays.asList(arr);

		Set<String> set = new HashSet<String>();
		for (String x : list) {
			set.add(x);
		}

		arr = new String[set.size()];
		set.toArray(arr);

		return arr;
	}

}
