package com.roytuts.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalPerThread {

	// SimpleDateFormat is not thread-safe, so give one to each thread
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		}
	};

	private static final ThreadLocal<SimpleDateFormat> formatter2 = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

	public static String formatDateTime(Date date) {
		return formatter.get().format(date);
	}

	public static String formatDate(Date date) {
		return formatter2.get().format(date);
	}

}
