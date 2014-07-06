package com.intuitiv.campus.test.service;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.service.CampusService;

public class CampusServiceTest extends AbstractServiceTest {

	private static final String CAMPUS_NAME = "Grenoble";
	private static final int CAMPUS_ID = 1;


	@Autowired
	CampusService campusService;

	@Test
	public void testListCampus() {
		Assert.assertTrue(CollectionUtils.isNotEmpty(campusService.list()));
	}

	@Test
	public void testFindCampus() {
		Assert.assertTrue(campusService.find(CAMPUS_ID).getName().equals(CAMPUS_NAME));
	}

}
