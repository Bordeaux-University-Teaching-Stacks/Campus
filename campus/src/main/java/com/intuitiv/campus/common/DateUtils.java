package com.intuitiv.campus.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <b>DateUtils</b> is used for Date.class repeatable manipulations
 * @author Meidi
 *
 */
public class DateUtils {

	/**
	 * The log output
	 */
	private static final Logger LOGGER = Logger.getLogger(DateUtils.class);

	/**
	 * Able to change the date format any times
	 */
	private static DateFormat formatter;

	/**
	 * Default standard date format in the app
	 */
	private static final String DEFAULT_CAMPUS_DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * Cast a String date to Date type
	 * @param dateString : a date in a String format
	 * @return a date in a Date format
	 * @exception Exception If the format action fails because of the string format itself
	 */
	public static Date castStringToDate(String dateString) {
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
	 * @return the current date in Date format
	 */
	public static Date getCurrentDate() {
		return new Date();
	}
}
