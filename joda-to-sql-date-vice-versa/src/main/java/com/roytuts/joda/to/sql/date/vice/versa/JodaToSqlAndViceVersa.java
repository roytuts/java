package com.roytuts.joda.to.sql.date.vice.versa;

import java.sql.Date;
import java.sql.Timestamp;

import org.joda.time.LocalDateTime;

public class JodaToSqlAndViceVersa {

	public static void main(String[] args) {
		LocalDateTime localDateTime = new LocalDateTime();
		System.out.println("LocalDateTime : " + localDateTime);
		System.out.println("LocalDateTime to SQL Date : " + jodatToSQLDate(localDateTime));
		Timestamp timestamp = jodaToSQLTimestamp(localDateTime);
		System.out.println("LocalDateTime to SQL Timestamp : " + timestamp);
		System.out.println("SQL Timestamp to LocalDateTime : " + sqlTimestampToJodaLocalDateTime(timestamp));
	}

	public static Date jodatToSQLDate(LocalDateTime localDateTime) {
		return new Date(localDateTime.toDateTime().getMillis());
	}

	public static Timestamp jodaToSQLTimestamp(LocalDateTime localDateTime) {
		return new Timestamp(localDateTime.toDateTime().getMillis());
	}

	public static LocalDateTime sqlTimestampToJodaLocalDateTime(Timestamp timestamp) {
		return LocalDateTime.fromDateFields(timestamp);
	}

}
