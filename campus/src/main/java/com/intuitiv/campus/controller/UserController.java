package com.intuitiv.campus.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import com.intuitiv.campus.entity.User;
import com.intuitiv.campus.service.CampusService;
import com.intuitiv.campus.service.UserService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/user")
public class UserController extends AbstractController{

	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	private static final String HOME_PAGE = "Home";
	private static final String USER_PAGE = "User";

	@Autowired
	UserService userService;

	@Autowired
	CampusService campusService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView user() throws CampusException {
		page.setViewName(HOME_PAGE);
		checkIfSessionIsExpired(USER_PAGE);
		return page;
	}

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
