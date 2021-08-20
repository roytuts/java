package com.roytuts.java.or.later.date.time.api;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Durations {

	public static void main(String[] args) {

		ZonedDateTime today = ZonedDateTime.now();
		ZonedDateTime yesterday = today.minusDays(1);

		// A duration of 3 seconds and 5 nanoseconds
		Duration duration = Duration.ofSeconds(3, 5);
		System.out.println("Duration representing a number of seconds and an adjustment in nanoseconds : " + duration);

		Duration oneDay = Duration.between(today, yesterday);
		System.out.println("duration between two temporal objects : " + oneDay);

	}

}
