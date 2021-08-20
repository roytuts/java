package com.roytuts.java.or.later.date.time.api;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeApi {

	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.now(); // The current date and time
		System.out.println("Current Local Date and Time : " + localDateTime);

		LocalDate localDateFromYearMonthDay = LocalDate.of(2012, Month.DECEMBER, 12); // from values
		System.out.println("localDateFromYearMonthDay : " + localDateFromYearMonthDay);

		LocalDate localDateFromEpocDayCount = LocalDate.ofEpochDay(182); // middle of 1970
		System.out.println("localDateFromEpocDayCount : " + localDateFromEpocDayCount);

		LocalTime localTimeFromHourMinute = LocalTime.of(19, 30); // from Hour and Minute
		System.out.println("localTimeFromHourMinute : " + localTimeFromHourMinute);

		LocalTime localTimeFromString = LocalTime.parse("10:15:30"); // From a String
		System.out.println("localTimeFromString : " + localTimeFromString);

		System.out.println("--------------------------------");

		LocalDate theDate = localDateTime.toLocalDate();
		System.out.println("Local date part of the time : " + theDate);

		Month month = localDateTime.getMonth();
		System.out.println("Moth of the year field : " + month);

		int day = localDateTime.getDayOfMonth();
		System.out.println("Day of month field : " + day);

		int second = localDateTime.getSecond();
		System.out.println("Second of minute field : " + second);

		System.out.println("--------------------------------");

		LocalDateTime dayOfMonthAltered = localDateTime.withDayOfMonth(10).withYear(2010);
		System.out.println("Local Date and Time with day-of-month altered : " + dayOfMonthAltered);

		LocalDateTime noOfWeeksAddeedToLocalDateTime = dayOfMonthAltered.plusWeeks(3).plus(3, ChronoUnit.WEEKS);
		System.out.println("Local date and time after adding no of weeks : " + noOfWeeksAddeedToLocalDateTime);

		System.out.println("--------------------------------");

		LocalDateTime adjustedLocalDateTime1 = localDateTime.with(lastDayOfMonth());
		System.out.println("Adjusted copy of local date and time :" + adjustedLocalDateTime1);

		LocalDateTime adjustedLocalDateTime2 = localDateTime.with(previousOrSame(DayOfWeek.WEDNESDAY));
		System.out.println(
				"Adjusted copy of previous or same day of week for local date and time :" + adjustedLocalDateTime2);

		// Using value classes as adjusters
		LocalDateTime adjustedLocalDateTime3 = localDateTime.with(LocalTime.now());
		System.out.println("Adjusted copy of local date and time :" + adjustedLocalDateTime3);

	}

}
