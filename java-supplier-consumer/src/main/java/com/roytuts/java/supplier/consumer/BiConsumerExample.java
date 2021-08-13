package com.roytuts.java.supplier.consumer;

import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void main(String[] args) {
		BiConsumer<String, String> bc = (x, y) -> {
			System.out.println(x + y);
		};

		bc.accept("1", "2");

		System.out.println("=========================");

		// Using lambda expression
		BiConsumer<User, String> ubc = (user, age) -> {
			System.out.println(user.getName() + " -> " + age);
		};

		ubc.accept(new User("Rahul"), "35");

		// Using method reference
		BiConsumer<User, String> urbc = BiConsumerExample::showDetails;
		urbc.accept(new User("Liton"), "32");
	}

	private static void showDetails(User user, String age) {
		System.out.println(user.getName() + " -> " + age);
	}

}
