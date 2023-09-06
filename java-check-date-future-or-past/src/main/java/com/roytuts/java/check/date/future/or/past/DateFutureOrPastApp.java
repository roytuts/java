package com.roytuts.java.check.date.future.or.past;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DateFutureOrPastApp {

	public static void main(String[] args) {

		List<String> dates = Arrays.asList("2023-12-31", "2020-12-31", "2024-06-30", "2023-06-14", "2021-12-31",
				"2019-03-21", "2023-10-09", "2022-04-26", "2023-09-06");

		final String df = "yyyy-MM-dd";

		dates.forEach(d -> isDatePastTodayFuture(d, df));

	}

	public static void isDatePastTodayFuture(final String date, final String dateFormat) {
		LocalDate localDate = LocalDate.now(ZoneId.systemDefault());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate inputDate = LocalDate.parse(date, dtf);

		if (inputDate.isBefore(localDate)) {
			System.out.println("The input date '" + date + "' is a past date");
		} else if (inputDate.isEqual(localDate)) {
			System.out.println("The input date '" + date + "' is a today's date");
		} else if (inputDate.isAfter(localDate)) {
			System.out.println("The input date '" + date + "' is a future date");
		}
	}

}
