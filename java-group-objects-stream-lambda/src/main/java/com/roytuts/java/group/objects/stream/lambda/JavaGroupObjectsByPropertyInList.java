package com.roytuts.java.group.objects.stream.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaGroupObjectsByPropertyInList {

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();

		books.add(new Book("Java", "James Gosling"));
		books.add(new Book("C++", "Bjourn Stroustup"));
		books.add(new Book("C", "Denish Ritche"));
		books.add(new Book("Databse", "C J Date"));
		books.add(new Book("Java", "James Gosling"));
		books.add(new Book("C", "Yashavant Kanetkar"));

		Map<String, List<Book>> bookMap = books.stream().collect(Collectors.groupingBy(Book::getTitle));

		bookMap.forEach((k, v) -> System.out.println(k + " => " + v));
	}

}
