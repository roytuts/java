package com.roytuts.java.comparator.in.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapComparator {

	public static void main(String[] args) {
		Map<Book, String> bookMap = new HashMap<>();

		bookMap.put(new Book("Java", "James Gosling"), "Java");
		bookMap.put(new Book("C++", "Bjourn Stroustup"), "C++");
		bookMap.put(new Book("C", "Denish Ritche"), "C");
		bookMap.put(new Book("Databse", "C J Date"), "Database");

		System.out.println("Unsorted HashMap Values");
		System.out.println("-----------------------");

		bookMap.forEach((k, v) -> System.out.println(k + " => " + v));

		System.out.println();

		Set<Entry<Book, String>> set = bookMap.entrySet();
		List<Entry<Book, String>> list = new ArrayList<Entry<Book, String>>(set);

		//Collections.sort(list, (b1, b2) -> (b1.getValue()).compareTo(b2.getValue()));

		Collections.sort(list, new Comparator<Map.Entry<Book, String>>() {
			@Override
			public int compare(Entry<Book, String> b1, Entry<Book, String> b2) {
				return (b1.getValue()).compareTo(b2.getValue());
			}
		});

		System.out.println("Sorted HashMap Values");
		System.out.println("---------------------");

		list.forEach(item -> System.out.println(item.getKey() + " => " + item.getValue()));
	}

}
