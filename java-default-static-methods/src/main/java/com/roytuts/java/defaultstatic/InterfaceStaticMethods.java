package com.roytuts.java.defaultstatic;

import java.time.DateTimeException;
import java.time.ZoneId;

public interface InterfaceStaticMethods {

	static ZoneId getZoneId(String zoneString) {
		try {
			return ZoneId.of(zoneString);
		} catch (DateTimeException e) {
			System.err.println("Invalid time zone: " + zoneString + "; using default time zone instead.");
			return ZoneId.systemDefault();
		}
	}

	static String getMsg() {
		return "Hello, World!";
	}

}
