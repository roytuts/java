package com.jeejava.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class JodaDateUtilsTest {

	private final DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy");

	@Test
	public void testIsDateFirstDayOfTheMonth() {
		DateTime dt = new DateTime();
		System.out.println(JodaDateUtils.isDateFirstDayOfTheMonth(dt));
		dt = dtf.parseDateTime("01-02-2016");
		System.out.println(JodaDateUtils.isDateFirstDayOfTheMonth(dt));
		dt = dtf.parseDateTime("01-01-2016");
		System.out.println(JodaDateUtils.isDateFirstDayOfTheMonth(dt));
		dt = dtf.parseDateTime("05-02-2016");
		System.out.println(JodaDateUtils.isDateFirstDayOfTheMonth(dt));
	}

}
