package com.intuitiv.campus.test.common;

import junit.framework.Assert;

import org.junit.Test;

import com.intuitiv.campus.common.CampusException;

public class CampusExceptionTest {

	private final static CampusException campusEx = new CampusException();
	private final static CampusException campusExWithMessage = new CampusException("message");
	private final static CampusException campusExWithException = new CampusException(new Exception());
	private final static CampusException campusExWithMessageAndException= new CampusException("message", new Exception());

	@Test
	public void testCampusEx() {
		Assert.assertNotNull(campusEx);
	}

	@Test
	public void testCampusExWithMessage() {
		Assert.assertNotNull(campusExWithMessage);
	}

	@Test
	public void testCampusExWithException() {
		Assert.assertNotNull(campusExWithException);
	}

	@Test
	public void testCampusExWithExceptionAndMessage() {
		Assert.assertNotNull(campusExWithMessageAndException);
	}

}
