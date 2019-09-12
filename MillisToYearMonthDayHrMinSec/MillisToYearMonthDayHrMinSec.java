package com.roytuts.time;

import java.util.concurrent.TimeUnit;

public class MillisToYearMonthDayHrMinSec {

	public static void main(String[] args) {
		final long milliseconds = 547896541576l;
		long dy = TimeUnit.MILLISECONDS.toDays(milliseconds);
		final long yr = dy / 365;
		dy %= 365;
		final long mn = dy / 30;
		dy %= 30;
		final long wk = dy / 7;
		dy %= 7;
		final long hr = TimeUnit.MILLISECONDS.toHours(milliseconds)
				- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(milliseconds));
		final long min = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds));
		final long sec = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds));
		final long ms = TimeUnit.MILLISECONDS.toMillis(milliseconds)
				- TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(milliseconds));
		System.out.println(
				String.format("%d Years %d Months %d Weeks %d Days %d Hours %d Minutes %d Seconds %d Milliseconds", yr,
						mn, wk, dy, hr, min, sec, ms));
	}

}
