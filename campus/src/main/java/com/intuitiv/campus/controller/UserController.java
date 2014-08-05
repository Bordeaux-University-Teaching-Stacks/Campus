package com.intuitiv.campus.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.intuitiv.campus.common.CampusException;
import com.intuitiv.campus.common.CampusTechnicalException;
import com.intuitiv.campus.entity.User;
import com.intuitiv.campus.service.CampusService;
import com.intuitiv.campus.service.UserService;

/**
 * <b>UserController</b> route every action made from the "User" page
 * @author Meidi
 *
 */
@Controller
@SessionAttributes("userSession")
@RequestMapping("/user")
public class UserController extends AbstractController{

	/**
	 * Name of the "Home" page
	 */
	private static final String HOME_PAGE = "Home";

	/**
	 * Name of the "User" page
	 */
	private static final String USER_PAGE = "User";

	/**
	 * User service provider
	 */
	@Autowired
	UserService userService;

	/**
	 * Campus service provider
	 */
	@Autowired
	CampusService campusService;

	/**
	 * Default constructor to display the "User" view
	 * @return ModelAndView object
	 * @throws CampusTechnicalException if there's a problem with the session
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView user() throws CampusTechnicalException {
		page.setViewName(HOME_PAGE);
		checkIfSessionIsExpired(USER_PAGE);
		return page;
	}

	/**
	 * Connect the user into the application if he's authorized
	 * @param email : the entered email as a login from the view
	 * @param password : the entered password for the provided email from the view
	 * @return ModelAndView object
	 * @throws CampusException if there's an error with the connection
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("email") String email, @ModelAttribute("password") String password) throws CampusException {
		page.setViewName(HOME_PAGE);
		if(userService.emailExists(email)){
			if(userService.passwordMatchWithEmail(email, password)){
				page.setViewName(USER_PAGE);
				page.addObject("userSession", userService.getUserByMail(email));
			} else {
				error("Le mot de passe est erroné.");
			}
		} else {
			error("L'email saisi n'existe pas.");
		}
		page.addObject("userForm", new User());
		return page;
	}

	/**
	 * User subscription route method
	 * @param userForm : the user's informations entered in the web form
	 * @param bindingResult : detect validations errors in the user's inputs
	 * @return ModelAndView object
	 * @throws CampusException if there's an error with the subscription
	 */
	@RequestMapping(value="/subscribe", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView userSubscribe(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult) throws CampusException {
		page.setViewName(HOME_PAGE);
		if(!bindingResult.hasErrors()) {
			userForm = userService.save(userForm);
			page.addObject("userSession", userForm);
			page.setViewName(USER_PAGE);
		}
		return page;
	}

	/**
	 * Disconnect the current user from the application (destroy his web session)
	 * @param session : the user's web session
	 * @return ModelAndView object
	 * @throws CampusException if there's a problem with the session to destroy
	 */
	@RequestMapping(value="/disconnect", method = RequestMethod.GET)
	public ModelAndView userDisconnect(HttpSession session) throws CampusException {
		page.setViewName(HOME_PAGE);
		session.invalidate();
		page.getModelMap().remove("userSession");
		page.addObject("userForm", new User());
		page.addObject("campus", campusService.list());
		return page;
	}

}
