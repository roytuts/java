package com.roytuts.java.or.later.date.time.api;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeZones {

	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.now();
		ZoneId id = ZoneId.of("America/New_York");

		ZonedDateTime zoned = ZonedDateTime.of(localDateTime, id);
		System.out.println("Zoned date-time from local date-time : " + zoned);

		System.out.println("-------------------------------------");

		ZoneOffset offset = ZoneOffset.of("+05:30");
		System.out.println("ZoneOffset using ID : " + offset);

		System.out.println("-------------------------------------");

		ZonedDateTime zoneddateTime = ZonedDateTime.parse("2016-09-09T08:30:42.546+05:30[America/New_York]");
		System.out.println("ZonedDateTime from a string : " + zoneddateTime);

		System.out.println("-------------------------------------");

		OffsetTime time = OffsetTime.now();

		System.out.println("Current time from the system clock for default time zone : " + time);
		OffsetTime sameTimeDifferentOffset = time.withOffsetSameInstant(ZoneOffset.UTC);
		System.out.println(
				"OffsetTime with the specified offset ensuring that the result is at the same instant on an implied day : "
						+ sameTimeDifferentOffset);

		OffsetTime changeTimeWithNewOffset = time.withOffsetSameLocal(ZoneOffset.UTC);
		System.out.println(
				"OffsetTime with the specified offset ensuring that the result has the same local time : " + time);

		OffsetTime hoursOfDayAltered = changeTimeWithNewOffset.withHour(3).plusSeconds(2);
		System.out.println("OffsetTime with the hour-of-day altered with no of seconds added : " + hoursOfDayAltered);
	}

}
