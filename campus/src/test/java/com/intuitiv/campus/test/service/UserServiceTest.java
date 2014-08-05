package com.intuitiv.campus.test.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.common.CampusException;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;
import com.intuitiv.campus.service.UserService;

public class UserServiceTest extends AbstractServiceTest {

	@Autowired
	UserService userService;

	private final static User user = new User();

	@Test
	public void testPasswordMatchWithEmail() {
		Assert.assertTrue(userService.passwordMatchWithEmail("select@campus.fr", "Test13"));
	}

	@Test
	public void testPasswordDoesntMatchWithEmail() {
		user.setEmail("select@campus.fr");
		user.setPassword("WrongPass");
		Assert.assertFalse(userService.passwordMatchWithEmail(user.getEmail(), user.getPassword()));
	}

	@Test
	public void testEmailExist() throws CampusException {
		user.setEmail("select@campus.fr");
		Assert.assertTrue(userService.emailExists(user.getEmail()));
	}

	@Test
	public void testEmailDoesntExist() throws CampusException {
		user.setEmail("fakeEmail@gmail.com");
		Assert.assertFalse(userService.emailExists(user.getEmail()));
	}

	@Test
	public void testGetUserByEmail() {
		user.setEmail("select@campus.fr");
		Assert.assertTrue(userService.getUserByMail(user.getEmail()).getName().equals("SelectName"));
	}

	@Test
	public void testGetAllUsersByCampus() {
		Campus campus = new Campus(1);
		Assert.assertTrue(userService.getAllUsersByCampus(campus).size() > 0);
	}

	@Test
	public void testList() {
		Assert.assertTrue(CollectionUtils.isNotEmpty(userService.getAllUsers()));
	}

	@Test
	public void testSave() throws ParseException {
		Campus campus = new Campus();
		campus.setId(1);
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		User user = new User("Test13","Test13", formatter.parse("13/11/1988"), 'M', "Test13@gmail.com", "Test13", campus);
		Assert.assertNotNull(userService.save(user));
	}

}
