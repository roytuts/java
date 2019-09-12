package com.roytuts.date;

import java.util.Calendar;
import java.util.Date;

public class CompareDateWithoutTime {

	public static String compareTwoDates(Date startDate, Date endDate) {
		Date sDate = getZeroTimeDate(startDate);
		Date eDate = getZeroTimeDate(endDate);
		if (sDate.before(eDate)) {
			return "Start date is before end date";
		}
		if (sDate.after(eDate)) {
			return "Start date is after end date";
		}
		return "Start date and end date are equal";
	}

	private static Date getZeroTimeDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}

}
