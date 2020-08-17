package com.roytuts.java.compare.date.without.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CompareDateWithoutTime {

	public static void main(String[] args) {
		// Test 1
		String response = CompareDateWithoutTime.compareTwoDates(new Date(), new Date());
		System.out.println(response);

		// Test 2
		Date startDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		Date endDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime();
		response = CompareDateWithoutTime.compareTwoDates(startDate, endDate);
		System.out.println(response);

		// Test 3
		startDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 12).getTime();
		endDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		response = CompareDateWithoutTime.compareTwoDates(startDate, endDate);
		System.out.println(response);
	}

	public static String compareTwoDates(Date startDate, Date endDate) {
		Date sDate = getZeroTimeDate(startDate);
		Date eDate = getZeroTimeDate(endDate);

		if (sDate.before(eDate)) {
			return "Start date [" + startDate + "] is before end date [" + endDate + "]";
		}

		if (sDate.after(eDate)) {
			return "Start date [" + endDate + "] is after end date [" + endDate + "]";
		}

		return "Start date [" + startDate + "] and end date [" + endDate + "] are equal";
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
