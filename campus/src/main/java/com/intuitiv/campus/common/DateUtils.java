package com.intuitiv.campus.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtils {

	private static final Logger LOGGER = Logger.getLogger(DateUtils.class);

	private static DateFormat formatter;
	private static final String DEFAULT_CAMPUS_DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * Cast a String date to Date type
	 * @param dateString
	 * @return
	 */
	public static Date stringToDate(String dateString) {
		try{
			formatter = new SimpleDateFormat(DEFAULT_CAMPUS_DATE_FORMAT);
			return formatter.parse(dateString);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	/**
	 * Return the current Date
	 * @return
	 */
	public static Date now() {
		formatter = new SimpleDateFormat(DEFAULT_CAMPUS_DATE_FORMAT);
		return new Date();
	}
}
