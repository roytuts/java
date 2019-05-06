package com.jeejava.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestComparDateWithoutTime {

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

}
