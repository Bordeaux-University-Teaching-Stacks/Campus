package com.intuitiv.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/trombinoscope")
public class TrombinoscopeController extends CampusController {

	private static final String HOME_PAGE = "Home";
	private static final String TROMBI_PAGE = "Trombinoscope";

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView trombinoscope(){
		page.setViewName(HOME_PAGE);
		checkIfSessionIsExpired(TROMBI_PAGE);
		return page;
	}

}
