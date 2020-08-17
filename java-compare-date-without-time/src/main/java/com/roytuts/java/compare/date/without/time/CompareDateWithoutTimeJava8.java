package com.roytuts.java.compare.date.without.time;

import java.time.LocalDate;
import java.time.Month;

public class CompareDateWithoutTimeJava8 {

	public static void main(String[] args) {
		// Test 1
		String response = CompareDateWithoutTimeJava8.compareTwoDates(LocalDate.now(), LocalDate.now());
		System.out.println(response);

		// Test 2
		LocalDate startDate = LocalDate.of(2014, Month.FEBRUARY, 11);
		LocalDate endDate = LocalDate.of(2014, Month.FEBRUARY, 12);
		response = CompareDateWithoutTimeJava8.compareTwoDates(startDate, endDate);
		System.out.println(response);

		// Test 3
		startDate = LocalDate.of(2014, Month.FEBRUARY, 12);
		endDate = LocalDate.of(2014, Month.FEBRUARY, 11);
		response = CompareDateWithoutTimeJava8.compareTwoDates(startDate, endDate);
		System.out.println(response);
	}

	public static String compareTwoDates(LocalDate startDate, LocalDate endDate) {

		if (startDate.isBefore(endDate)) {
			return "Start date [" + startDate + "] is before end date [" + endDate + "]";
		}

		if (startDate.isAfter(endDate)) {
			return "Start date [" + endDate + "] is after end date [" + endDate + "]";
		}

		return "Start date [" + startDate + "] and end date [" + endDate + "] are equal";
	}

}
