package com.intuitiv.campus.test.controller;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest extends AbstractControllerTest {

	@Test
	public void testHome() throws Exception {
		request.setRequestURI("/");
		request.setMethod("GET");
		Object handler = handlerMapping.getHandler(request).getHandler();
		final ModelAndView mav = handlerAdapter.handle(request, response, handler);
		assertViewName(mav, "Home");
	}

}
