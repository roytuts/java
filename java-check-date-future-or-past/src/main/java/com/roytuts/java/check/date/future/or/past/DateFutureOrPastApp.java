package com.roytuts.java.check.date.future.or.past;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFutureOrPastApp {

	public static void main(String[] args) {

		final String pastMsg = "The input date is a past date";
		final String todayMsg = "The input date is a today's date";
		final String futureMsg = "The input date is a future date";

		boolean isDatePast = isDatePast("2020-12-23", "yyyy-MM-dd");
		boolean isDateToday = isDateToday("2020-12-23", "yyyy-MM-dd");
		boolean isDateFuture = isDateFuture("2020-12-23", "yyyy-MM-dd");

		if (isDatePast) {
			System.out.println(pastMsg);
		}

		if (isDateToday) {
			System.out.println(todayMsg);
		}

		if (isDateFuture) {
			System.out.println(futureMsg);
		}

		isDatePast = isDatePast("2020-12-29", "yyyy-MM-dd");
		isDateToday = isDateToday("2020-12-29", "yyyy-MM-dd");
		isDateFuture = isDateFuture("2020-12-29", "yyyy-MM-dd");

		if (isDatePast) {
			System.out.println(pastMsg);
		}

		if (isDateToday) {
			System.out.println(todayMsg);
		}

		if (isDateFuture) {
			System.out.println(futureMsg);
		}

		isDatePast = isDatePast("2020-12-31", "yyyy-MM-dd");
		isDateToday = isDateToday("2020-12-31", "yyyy-MM-dd");
		isDateFuture = isDateFuture("2020-12-31", "yyyy-MM-dd");

		if (isDatePast) {
			System.out.println(pastMsg);
		}

		if (isDateToday) {
			System.out.println(todayMsg);
		}

		if (isDateFuture) {
			System.out.println(futureMsg);
		}

	}

	public static boolean isDatePast(final String date, final String dateFormat) {
		LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate inputDate = LocalDate.parse(date, dtf);

		return inputDate.isBefore(localDate);
	}

	public static boolean isDateToday(final String date, final String dateFormat) {
		LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate inputDate = LocalDate.parse(date, dtf);

		return inputDate.isEqual(localDate);
	}

	public static boolean isDateFuture(final String date, final String dateFormat) {
		LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate inputDate = LocalDate.parse(date, dtf);

		return inputDate.isAfter(localDate);
	}
}
