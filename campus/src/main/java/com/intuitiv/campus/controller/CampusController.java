package com.intuitiv.campus.controller;

import org.springframework.web.servlet.ModelAndView;

public abstract class CampusController {

	/**
	 * The response page to render
	 */
	protected static ModelAndView page = new ModelAndView();

	/**
	 * Create an "error" HttpRequest attribute containing the error message to display on the view
	 * 
	 * @param mv : the ModelAndView object to set
	 * @param msg : the message to display as an error
	 */
	protected void error(String msg) {
		page.addObject("error", msg);
	}

	/**
	 * Redirect and write error message if session expired
	 * 
	 */
	protected void checkIfSessionIsExpired(String viewName) {
		if(page.getModel().get("userSession") != null) {
			page.setViewName(viewName);
		} else {
			error("Votre session a expiré. Vous devez vous reconnecter.");
		}
	}
}
