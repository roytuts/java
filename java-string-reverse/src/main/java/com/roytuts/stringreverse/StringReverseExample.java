package com.roytuts.stringreverse;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringReverseExample {

	public static void main(String[] args) {
		StringReverseExample sr = new StringReverseExample();

		String word = "HelloWorld";

		// quick wasy to reverse String in Java - Use StringBuffer
		String reverse = sr.usingStringBufferReverse(word);
		System.out.printf(" original String : %s , reversed String : %s  %n", word, reverse);

		// another quick to reverse String in Java - use StringBuilder
		reverse = sr.usingStringBuilderReverse(word);
		System.out.printf(" original String : %s , reversed String : %s %n", word, reverse);

		// one way to reverse String using custom method
		reverse = sr.usingCustomReverse(word);
		System.out.printf(" original String : %s , reversed String : %s %n", word, reverse);

		// reverse String using recursion
		reverse = sr.usingRecursion(word);
		System.out.printf(" original String : %s , reversed String : %s %n", word, reverse);

		// reverse String using Java 8 IntStream
		reverse = sr.usingJava8LambdaStream(word);
		System.out.printf(" original String : %s , reversed String : %s %n", word, reverse);

		// reverse String using Java 8 Stream
		reverse = sr.usingAnotherJava8LambdaStream(word);
		System.out.printf(" original String : %s , reversed String : %s %n", word, reverse);
	}

	public String usingStringBufferReverse(final String string) {
		if (string == null || string.isEmpty()) {
			return string;
		}
		String reverseString = new StringBuffer(string).reverse().toString();
		return reverseString;
	}

	public String usingStringBuilderReverse(final String string) {
		if (string == null || string.isEmpty()) {
			return string;
		}
		String reverseString = new StringBuffer(string).reverse().toString();
		return reverseString;
	}

	public String usingCustomReverse(final String string) {
		if (string == null || string.isEmpty()) {
			return string;
		}
		String reverse = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			reverse = reverse + string.charAt(i);
		}
		return reverse;
	}

	public String usingRecursion(final String string) {
		if (string == null || string.isEmpty() || string.length() < 2) {
			return string;
		}
		return usingRecursion(string.substring(1)) + string.charAt(0);
	}

	public String usingJava8LambdaStream(final String string) {
		return IntStream.range(0, string.length()).map(i -> string.charAt(string.length() - i - 1))
				.collect(StringBuilder::new, (s, c) -> s.append((char) c), StringBuilder::append).toString();
	}

	public String usingAnotherJava8LambdaStream(final String string) {
		return Stream.of(string).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
	}

}
