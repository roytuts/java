package com.roytuts.java.shuffle.arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JavaShuffleArrayList {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("gei", "jh", "hg", "iyu", "sffd");

		Collections.shuffle(list);

		list.stream().forEach(System.out::println);

		System.out.println("------------------");

		shuffleList(list);

		list.stream().forEach(System.out::println);
	}

	public static <T> void shuffleList(List<T> l) {
		int n = l.size();
		Random random = new Random();
		random.nextInt();

		for (int i = 0; i < n; i++) {
			int change = i + random.nextInt(n - i);
			swap(l, i, change);
		}
	}

	private static <T> void swap(List<T> l, int i, int change) {
		T helper = l.get(i);
		l.set(i, l.get(change));
		l.set(change, helper);
	}

}
