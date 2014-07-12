package com.intuitiv.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.intuitiv.campus.entity.User;
import com.intuitiv.campus.service.CampusService;

@Controller
@SessionAttributes("campus")
@RequestMapping("/")
public class HomeController extends AbstractController {

	@Autowired
	private CampusService campusService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView model = new ModelAndView("Home");
		model.addObject("campus", campusService.list());
		model.addObject("userForm", new User());
		return model;
	}

}
