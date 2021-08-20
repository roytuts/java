package com.roytuts.java.or.later.date.time.api;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeTruncation {

	public static void main(String[] args) {

		LocalTime localTime = LocalTime.now();

		LocalTime truncatedTime = localTime.truncatedTo(ChronoUnit.SECONDS);
		System.out.println("Local time with truncated : " + truncatedTime);

	}

}
