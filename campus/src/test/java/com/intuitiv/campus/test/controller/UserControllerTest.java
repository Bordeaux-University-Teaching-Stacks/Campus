package com.intuitiv.campus.test.controller;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.service.UserService;

public class UserControllerTest extends AbstractControllerTest {

	@Autowired
	UserService userService;

	@Test
	public void testUserPageRenderedWithNoSession() throws Exception {
		request.setRequestURI("/user/");
		request.setMethod("GET");

		assertViewName(getResponsePage(), "Home");
	}

	@Test
	public void testUserFailedLoginBecauseofEmailPageRendered() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "unknown@campus.fr");
		request.addParameter("password", "Test13");

		assertViewName(getResponsePage(), "Home");
	}

	@Test
	public void testUserFailedLoginMessage() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "unknown@campus.fr");
		request.addParameter("password", "Test13");

		Assert.assertTrue(getResponsePage().getModel().get("error").equals("L'email saisi n'existe pas."));
	}

	@Test
	public void testUserFailedLoginBecauseofPasswordPageRendered() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "select@campus.fr");
		request.addParameter("password", "wrongpass");

		assertViewName(getResponsePage(), "Home");
	}

	@Test
	public void testUserFailedPasswordMessage() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "select@campus.fr");
		request.addParameter("password", "wrongpass");

		Assert.assertTrue(getResponsePage().getModel().get("error").equals("Le mot de passe est erroné."));
	}

	@Test
	public void testUserSucceedLoginPageRendered() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "select@campus.fr");
		request.addParameter("password", "Test13");

		assertViewName(getResponsePage(), "User");
	}

	@Test
	public void testUserFailedSubscribePageRendered() throws Exception {
		request.setRequestURI("/user/subscribe");
		request.setMethod("POST");
		request.addParameter("email", "email");
		request.addParameter("password", "password");
		request.addParameter("name", "nom");
		request.addParameter("surname", "prenom");
		request.addParameter("sex", "male");
		request.addParameter("campus", "1");
		request.addParameter("birth", "13/11/1988");
		request.addParameter("legals", "false");
		request.addParameter("newsletter", "true");

		assertViewName(getResponsePage(), "Home");
	}

	@Test
	public void testUserSucceedSubscribePageRendered() throws Exception {
		request.setRequestURI("/user/subscribe");
		request.setMethod("POST");
		request.addParameter("email", "email@test.fr");
		request.addParameter("password", "Password13");
		request.addParameter("name", "nomTest");
		request.addParameter("surname", "prenomTest");
		request.addParameter("sex", "M");
		request.addParameter("campus.id", "2");
		request.addParameter("birth", "01/11/1988");
		request.addParameter("legals", "true");
		request.addParameter("newsletter", "true");

		assertViewName(getResponsePage(), "User");
	}

	@Test
	public void testLogout() throws Exception {
		request.setRequestURI("/user/disconnect");
		request.setMethod("GET");

		assertViewName(getResponsePage(), "Home");
	}

}
