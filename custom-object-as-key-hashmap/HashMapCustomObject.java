package com.roytuts.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapCustomObject {

	public static void main(String[] args) {
		Map<Book, String> bookMap = new HashMap<>();
		bookMap.put(new Book("Java", "James Gosling"), "Java");
		bookMap.put(new Book("C++", "Bjourn Stroustup"), "C++");
		bookMap.put(new Book("C", "Denish Ritche"), "C");
		bookMap.put(new Book("Databse", "C J Date"), "Database");
		System.out.println();
		bookMap.forEach((k, v) -> System.out.println(k + " => " + v));
		System.out.println();
		Book key = new Book("Java", "James Gosling");
		System.out.println("Is key: " + key + " available? " + bookMap.containsKey(key));
	}

}
