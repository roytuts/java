package com.roytuts.java.defaultstatic;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface InterfaceDefaultMethods {

	LocalDateTime getLocalDateTime();

	default ZonedDateTime getZonedDateTime(String zoneString) {
		return ZonedDateTime.of(getLocalDateTime(), ZoneId.of(zoneString));
	}

	default String getHello() {
		return "Hello";
	}

}
