package com.roytuts.validation;

import java.util.regex.Pattern;

public class StringNumericValidator {

	public static void main(String[] args) {
		System.out.println("=====================================");
		System.out.println("Comma and currency are invalid");
		System.out.println("=====================================");
		System.out.println("20,00: " + isStringNumericWithComma("20,00"));
		System.out.println("30,000.01: " + isStringNumericWithComma("30,000.01"));
		System.out.println("abc: " + isStringNumeric("abc"));
		System.out.println("abc125: " + isStringNumeric("abc125"));
		System.out.println("abc125.25: " + isStringNumeric("abc125.25"));
		System.out.println("125.25d: " + isStringNumeric("125.25d"));
		System.out.println("125d: " + isStringNumeric("125d"));
		System.out.println("125f: " + isStringNumeric("125f"));
		System.out.println("125.00: " + isStringNumeric("125.00"));
		System.out.println("125: " + isStringNumeric("125"));
		System.out.println("20: " + isStringNumeric("20"));
		System.out.println("20,00: " + isStringNumeric("20,00"));
		System.out.println("30.01: " + isStringNumeric("30.01"));
		System.out.println("30,000.01: " + isStringNumeric("30,000.01"));
		System.out.println("-2980: " + isStringNumeric("-2980"));
		System.out.println("$20: " + isStringNumeric("$20"));
		System.out.println("jdl: " + isStringNumeric("jdl"));
		System.out.println("2lk0: " + isStringNumeric("2lk0"));
		
		System.out.println("=====================================");
		System.out.println("Comma is valid");
		System.out.println("=====================================");
		System.out.println("20,00: " + isStringNumericWithComma("20,00"));
		System.out.println("30,000.01: " + isStringNumericWithComma("30,000.01"));
		
		System.out.println("=====================================");
		System.out.println("Comma and currency are valid");
		System.out.println("=====================================");
		System.out.println("20,00: " + isStringNumericWithCommaCurrency("$20,00"));
		System.out.println("30,000.01: " + isStringNumericWithCommaCurrency("$30,000.01"));
		System.out.println("$20: " + isStringNumericWithCommaCurrency("$20"));
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
	
	public static boolean isStringNumericWithComma(String str) {
		final String Digits = "(\\p{Digit}+)";
		final String HexDigits = "(\\p{XDigit}+)";
		final String Expression = "[eE][+-]?" + Digits;

		final String numericRegex = "[\\x00-\\x20]*[+-]?[\\d\\.,]*(NaN|Infinity|(((" + Digits + "(\\.)?(" + Digits + "?)("
				+ Expression + ")?)|(\\.(" + Digits + ")(" + Expression + ")?)|(((0[xX]" + HexDigits + "(\\.)?)|(0[xX]"
				+ HexDigits + "?(\\.)" + HexDigits + ")" + ")[pP][+-]?" + Digits + "))[fFdD]?))[\\x00-\\x20]*";

		final Pattern NUMBER_PATTERN = Pattern.compile(numericRegex);

		return NUMBER_PATTERN.matcher(str).matches();
	}
	
	public static boolean isStringNumericWithCommaCurrency(String str) {
		final String Digits = "(\\p{Digit}+)";
		final String HexDigits = "(\\p{XDigit}+)";
		final String Expression = "[eE][+-]?" + Digits;

		final String numericRegex = "^[\\$]?[\\x00-\\x20]*[+-]?[\\d\\.,]*(NaN|Infinity|(((" + Digits + "(\\.)?(" + Digits + "?)("
				+ Expression + ")?)|(\\.(" + Digits + ")(" + Expression + ")?)|(((0[xX]" + HexDigits + "(\\.)?)|(0[xX]"
				+ HexDigits + "?(\\.)" + HexDigits + ")" + ")[pP][+-]?" + Digits + "))[fFdD]?))[\\x00-\\x20]*";

		final Pattern NUMBER_PATTERN = Pattern.compile(numericRegex);

		return NUMBER_PATTERN.matcher(str).matches();
	}

}
