package com.intuitiv.campus.test.common;

import junit.framework.Assert;

import org.junit.Test;

import com.intuitiv.campus.common.CampusTechnicalException;

public class CampusTechnicalExceptionTest {

	private final static CampusTechnicalException campusTechEx = new CampusTechnicalException();
	private final static CampusTechnicalException campusTechExCode = new CampusTechnicalException(-1);
	private final static CampusTechnicalException campusTechExMessage = new CampusTechnicalException("message");
	private final static CampusTechnicalException campusTechExException = new CampusTechnicalException(new Exception());
	private final static CampusTechnicalException campusTechExMessageAndException = new CampusTechnicalException("message", new Exception());

	@Test
	public void testCampusTechEx() {
		Assert.assertNotNull(campusTechEx);
	}

	@Test
	public void testCampusTechExCode() {
		Assert.assertNotNull(campusTechExCode);
	}

	@Test
	public void testCampusTechExMessage() {
		Assert.assertNotNull(campusTechExMessage);
	}

	@Test
	public void testCampusTechExException() {
		Assert.assertNotNull(campusTechExException);
	}

	@Test
	public void testCampusTechExMessageAndException() {
		Assert.assertNotNull(campusTechExMessageAndException);
	}

	@Test
	public void testGetCampusTechnicalExceptionCode() {
		Assert.assertEquals(campusTechExCode.getCode(), -1);
	}

}
