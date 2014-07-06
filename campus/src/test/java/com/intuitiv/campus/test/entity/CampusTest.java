package com.intuitiv.campus.test.entity;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

public class CampusTest {

	private final static Campus campus = new Campus();
	private final static User user = new User();

	private final static String CAMPUS_NAME = "Bordeaux";
	private final static int CAMPUS_ID = 1;
	private static Set<User> users = new HashSet<User>();

	@Before
	public void setUpTest() {
		campus.setName(CAMPUS_NAME);
		campus.setId(CAMPUS_ID);
		users.add(user);
		campus.setUsers(users);
	}

	@Test
	public void testCampusHasValidName() {
		assertTrue(campus.getName() != null);
	}

	@Test
	public void testCampusHasValidId() {
		assertTrue(campus.getId() > 0);
	}

	@Test
	public void testCampusIsNotEmpty() {
		assertTrue(CollectionUtils.isNotEmpty(campus.getUsers()));
	}

}
