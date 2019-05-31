package com.jeejava.validation;

import java.util.regex.Pattern;

public class StringNumericValidator {

	public static void main(String[] args) {
		System.out.println("abc: " + isStringNumeric("abc"));
		System.out.println("abc125: " + isStringNumeric("abc125"));
		System.out.println("abc125.25: " + isStringNumeric("abc125.25"));
		System.out.println("125.25d: " + isStringNumeric("125.25d"));
		System.out.println("125d: " + isStringNumeric("125d"));
		System.out.println("125f: " + isStringNumeric("125f"));
		System.out.println("125.00: " + isStringNumeric("125.00"));
		System.out.println("125: " + isStringNumeric("125"));
	}

	public static boolean isStringNumeric(String str) {
		final String Digits = "(\\p{Digit}+)";
		final String HexDigits = "(\\p{XDigit}+)";
		final String Expression = "[eE][+-]?" + Digits;

		final String numericRegex = "[\\x00-\\x20]*[+-]?(NaN|Infinity|(((" + Digits + "(\\.)?(" + Digits + "?)("
				+ Expression + ")?)|(\\.(" + Digits + ")(" + Expression + ")?)|(((0[xX]" + HexDigits + "(\\.)?)|(0[xX]"
				+ HexDigits + "?(\\.)" + HexDigits + ")" + ")[pP][+-]?" + Digits + "))[fFdD]?))[\\x00-\\x20]*";

		final Pattern NUMBER_PATTERN = Pattern.compile(numericRegex);

		return NUMBER_PATTERN.matcher(str).matches();
	}
}
