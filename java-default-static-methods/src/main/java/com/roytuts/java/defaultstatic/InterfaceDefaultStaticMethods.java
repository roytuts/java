package com.roytuts.java.defaultstatic;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface InterfaceDefaultStaticMethods {

	LocalDateTime getLocalDateTime();

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

	default ZonedDateTime getZonedDateTime(String zoneString) {
		return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
	}

	default String getHello() {
		return "Hello";
	}

}
