package com.intuitiv.campus.test.controller;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import org.junit.Test;

public class TrombinoscopeTest extends AbstractControllerTest{

	@Test
	public void testTrombinoscopeWithSession() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "select@campus.fr");
		request.addParameter("password", "Test13");
		getResponsePage();
		request.setRequestURI("/trombinoscope/");
		request.setMethod("GET");

		assertViewName(getResponsePage(), "Trombinoscope");
	}

	@Test
	public void testTrombinoscopeWithNoSession() throws Exception {
		request.setRequestURI("/user/disconnect/");
		request.setMethod("GET");
		getResponsePage();
		request.setRequestURI("/trombinoscope/");
		request.setMethod("GET");

		assertViewName(getResponsePage(), "Home");
	}

}
