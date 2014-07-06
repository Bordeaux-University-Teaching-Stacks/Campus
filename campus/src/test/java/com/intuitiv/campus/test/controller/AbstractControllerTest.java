package com.intuitiv.campus.test.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/appContext-test.xml", "file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@WebAppConfiguration
public abstract class AbstractControllerTest {

	@Autowired
	protected RequestMappingHandlerAdapter handlerAdapter;

	@Autowired
	protected RequestMappingHandlerMapping handlerMapping;

	protected MockHttpServletRequest request;
	protected MockHttpServletResponse response;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	protected ModelAndView getResponsePage() throws Exception {
		Object handler = handlerMapping.getHandler(request).getHandler();
		return handlerAdapter.handle(request, response, handler);
	}

}
