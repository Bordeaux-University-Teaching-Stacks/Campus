package com.intuitiv.campus.controller;

import org.springframework.web.servlet.ModelAndView;

/**
 * <b>AbstractController</b> is the common controller for all the views.
 * @author Meidi
 *
 */
public abstract class AbstractController {

	/**
	 * The response page to render
	 */
	protected static ModelAndView page = new ModelAndView();

	/**
	 * Create an "error" HttpRequest attribute containing the error message to display on the view
	 * 
	 * @param msg : the message to display as an error
	 */
	protected void error(String msg) {
		page.addObject("error", msg);
	}

	/**
	 * Redirect the user and write error message if session expired
	 * @param viewName : the name of the view to display if the session already exists
	 */
	protected void checkIfSessionIsExpired(String viewName) {
		if(page.getModel().get("userSession") != null) {
			page.setViewName(viewName);
		} else {
			error("Votre session a expiré. Vous devez vous reconnecter.");
		}
	}
}
