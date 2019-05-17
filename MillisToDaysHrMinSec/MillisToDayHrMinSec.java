package com.jeejava.time;

import java.util.concurrent.TimeUnit;

public class MillisToDayHrMinSec {

	public static void main(String[] args) {
		final long milliseconds = 5478965412358l;
		final long dy = TimeUnit.MILLISECONDS.toDays(milliseconds);
		final long hr = TimeUnit.MILLISECONDS.toHours(milliseconds)
				- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(milliseconds));
		final long min = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds));
		final long sec = TimeUnit.MILLISECONDS.toSeconds(milliseconds)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds));
		final long ms = TimeUnit.MILLISECONDS.toMillis(milliseconds)
				- TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(milliseconds));
		System.out
				.println(String.format("%d Days %d Hours %d Minutes %d Seconds %d Milliseconds", dy, hr, min, sec, ms));
	}

}
