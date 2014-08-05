package com.intuitiv.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * <b>TrombinoscopeController</b> route every action made from the "Trombinoscope" page
 * @author Meidi
 *
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/trombinoscope")
public class TrombinoscopeController extends AbstractController {

	/**
	 * Name of the "Home" page
	 */
	private static final String HOME_PAGE = "Home";

	/**
	 * Name of the "Trombinoscope" page
	 */
	private static final String TROMBI_PAGE = "Trombinoscope";

	/**
	 * Default constructor to display the "Trombinoscope" page
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView trombinoscope(){
		page.setViewName(HOME_PAGE);
		checkIfSessionIsExpired(TROMBI_PAGE);
		return page;
	}

}
