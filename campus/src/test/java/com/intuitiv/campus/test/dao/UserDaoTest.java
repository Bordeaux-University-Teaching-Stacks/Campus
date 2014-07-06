package com.intuitiv.campus.test.dao;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.dao.UserDao;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

public class UserDaoTest extends AbstractDaoTest {

	@Autowired
	UserDao userDao;

	@Test
	public void testList() {
		assertTrue(CollectionUtils.isNotEmpty(userDao.list(User.class)));
	}

	@Test
	public void testFind() {
		assertTrue(userDao.find(1L).getName().equals("SelectName"));
	}

	@Test
	public void testUpdate() {
		User user = userDao.find(2L);
		user.setName("TEST");
		userDao.update(user);
		assertTrue(userDao.find(2L).getName().equals("TEST"));
	}

	@Test
	public void testSave() throws ParseException{
		User user = new User();
		Campus campus = new Campus();
		campus.setId(1);
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		user.setBirth(formatter.parse("13/11/1988"));
		user.setEmail("Test14@gmail.com");
		user.setName("Test14");
		user.setSurname("Test14");
		user.setPassword("Test14");
		user.setCampus(campus);
		userDao.save(user);

		assertTrue(userDao.find(user.getId()).getName().equals("Test14"));
	}

	@Test
	public void testDelete() {
		userDao.delete(userDao.find(3L));
		assertTrue(userDao.find(3L) == null);
	}

	@Test
	public void testGetAllUsersByCampus() {
		Campus campus = new Campus();
		campus.setId(1);
		assertTrue(CollectionUtils.isNotEmpty(userDao.getAllUsersByCampus(campus)));
	}

	@Test
	public void testFindByEmail() {
		assertTrue(userDao.findByEmail("select@campus.fr").getName().equals("SelectName"));
	}

}
