package com.intuitiv.campus.test.common;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.intuitiv.campus.common.DateUtils;

public class DateUtilsTest {

	private static final String DATE_STRING_INFERIOR = "13/11/1988";
	private static final String DATE_STRING_SUPERIOR = "13/11/1989";
	private static final String WRONG_DATE = "1315648";

	private static final DateUtils dateUtils = new DateUtils();

	@Test
	public void testStringToDate() {
		Assert.assertTrue(DateUtils.castStringToDate(DATE_STRING_INFERIOR).before(DateUtils.castStringToDate(DATE_STRING_SUPERIOR)));
	}

	@Test
	public void testWrongStringToDate() {
		Assert.assertNull(DateUtils.castStringToDate(WRONG_DATE));
	}

	@Test
	public void testNow() {
		Assert.assertTrue(DateUtils.getCurrentDate().equals(new Date()));
	}

}
