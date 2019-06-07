package com.jeejava.excel.utils;

public final class ExcelUtil {

	private ExcelUtil() {
	}

	// capitalize the first letter of the field name for retrieving value of the
	// field later
	public static String capitalizeInitialLetter(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

}
