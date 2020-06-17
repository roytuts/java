package com.roytuts.java.sanitize.json;

public class JsonSanitizer {

	public static String sanitizeJson(String jsonString) {
		String wellFormedJson = com.google.json.JsonSanitizer.sanitize(jsonString);
		return wellFormedJson;
	}

}
