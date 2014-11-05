package com.intuitiv.campus.test.entity;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.intuitiv.campus.common.CipherUtils;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;

public class UserTest {

	private final static User user = new User();
	private final static Campus campus = new Campus();
	private final static String CAMPUS_NAME = "Bordeaux";
	private final static String VALID_EMAIL = "meidi.airouche@gmail.com";
	private final static String VALID_PASSWORD = "Test13";
	private final static String VALID_BIRTH_DATE_STRING = "13/11/1988";
	private final static String PHOTO = "TestPhoto";
	private final static String NAME = "TestName";
	private final static String SURNAME = "TestSurname";
	private Date VALID_BIRTH_DATE;

	@Before
	public void setUpTest() throws ParseException {
		campus.setName(CAMPUS_NAME);
		user.setId(1L);
		user.setEmail(VALID_EMAIL);
		user.setPassword(CipherUtils.encrypt(VALID_PASSWORD));
		user.setName(NAME);
		user.setSurname(SURNAME);
		user.setCampus(campus);
		user.setPhoto(PHOTO);
		user.setSex('M');
		user.setLegals(true);
		user.setNewsletter(true);

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		VALID_BIRTH_DATE = formatter.parse(VALID_BIRTH_DATE_STRING);
		user.setBirth(VALID_BIRTH_DATE);
	}

	@Test
	public void testHasValidEmail() {
		assertTrue(user.getEmail() != null);
	}

	@Test
	public void testHasValidPassword() {
		assertTrue(user.getPassword() != null);
	}

	@Test
	public void testHasValidBirthDate() {
		assertTrue(user.getBirth() != null);
	}

	@Test
	public void testUserHasCampus() {
		assertTrue(user.getCampus() != null);
	}

	@Test
	public void testUserHasPhoto() {
		assertTrue(user.getPhoto() != null);
	}

	@Test
	public void testUserGotAnId() {
		assertTrue(user.getId() != null);
	}

	@Test
	public void testUserGotAName() {
		assertTrue(user.getName() != null);
	}

	@Test
	public void testUserGotASurname() {
		assertTrue(user.getSurname() != null);
	}

	@Test
	public void testUserIsAMale() {
		assertTrue(user.getSex() == 'M');
	}

	@Test
	public void testUserIsAWoman() {
		user.setSex('F');
		assertTrue(user.getSex() == 'F');
	}

	@Test
	public void testGetAgeAfterBirthday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -10);
		user.setBirth(calendar.getTime());
		assertTrue(user.getAge() == 10);
	}

	@Test
	public void testGetAgeBeforeBirthdayByMonths() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -10);
		calendar.add(Calendar.MONTH, 1);
		user.setBirth(calendar.getTime());
		assertTrue(user.getAge() == 9);
	}

	@Test
	public void testGetAgeBeforeBirthByDays() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -10);
		calendar.add(Calendar.DATE, 1);
		user.setBirth(calendar.getTime());
		assertTrue(user.getAge() == 9);
	}

	@Test
	public void testLegalsAccepted() {
		assertTrue(user.getLegals());
	}

	@Test
	public void testNewsletterAccepted() {
		assertTrue(user.getNewsletter());
	}

}
