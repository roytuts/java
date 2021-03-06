package com.roytuts.java.supplier.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		List<String> greets = Arrays.asList("Hi", "Hey", "Hello");

		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};

		greets.forEach(consumer);
	}

}
