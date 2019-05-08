package com.jeejava.json.sanitizer;

public class JsonSanitizerTest {

	public static void main(String[] args) {
		String jsonString = "{\"key1\":\"value1\",\"type\":\"Booking\",\"sid\":\"A43521\",\"region\":\"ASIA\","
				+ "\"fetchFromFile\":\"false\",\"service\":\"true\",\"isEom\":\"true\",*#@!}";

		String responseOne = JsonSanitizer.jsonSanitizeOne(jsonString);
		System.out.println(responseOne);

		String responseTwo = JsonSanitizer.jsonSanitizeTwo(jsonString);
		System.out.println(responseTwo);
	}
}
