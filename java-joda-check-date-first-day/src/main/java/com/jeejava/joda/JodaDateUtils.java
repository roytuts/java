package com.jeejava.joda;

import org.joda.time.DateTime;

public final class JodaDateUtils {

	public static boolean isDateFirstDayOfTheMonth(final DateTime dateTime) {
		return dateTime.getDayOfMonth() == 1;
	}

}
