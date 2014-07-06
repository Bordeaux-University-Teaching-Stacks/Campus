package com.intuitiv.campus.test.dao;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.dao.CampusDao;
import com.intuitiv.campus.entity.Campus;

public class CampusDaoTest extends AbstractDaoTest {

	private final static int CAMPUS_TEST_ID = 1;
	private final static String CAMPUS_TEST_NAME = "Grenoble";

	@Autowired
	CampusDao campusDao;

	@Test
	public void testListCampus(){
		Assert.assertTrue(CollectionUtils.isNotEmpty(campusDao.list(Campus.class)));
	}

	@Test
	public void testFind() {
		Assert.assertTrue(campusDao.find(CAMPUS_TEST_ID).getName().equals(CAMPUS_TEST_NAME));
	}

}
