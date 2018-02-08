package com.btasdemir.dmall.commons.core.util;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	
	private static String PATTERN = "MM/dd/yyyy HH:mm:ss";
	private DateTimeFormatter dateTimeFormat;
	
	@PostConstruct
	public void init() {
		dateTimeFormat = DateTimeFormat.forPattern(PATTERN);
	}
	
	public Date toDate(DateTime dateTime) {
		if (dateTime == null) {
			return null;
		}
		return new Date(dateTime.getMillis());
	}
	
	public DateTime toDateTime(Date date) {
		if (date == null) {
			return null;
		}
		return new DateTime(date.getTime());
	}

	public DateTime toDateTime(Timestamp timestamp) {
		if (timestamp == null) {
			return null;
		}
		return new DateTime(timestamp.getTime());
	}
	
	public String toString(DateTime dateTime) {
		if (dateTime == null) {
			return new String();
		}
		return dateTimeFormat.print(dateTime);
	}
	
	public String toString(Timestamp timestamp) {
		if (timestamp == null) {
			return new String();
		}
		return toString(toDateTime(timestamp));
	}
	
}
