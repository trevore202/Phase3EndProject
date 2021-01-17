package com.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.service.RegistrationService;

@Controller
@SessionAttributes("name")
public class RegistrationController {

	@Autowired
	RegistrationService service;
	
	@GetMapping("/register")
	public String showRegisterPage(ModelMap model) {
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
		
		boolean isValidUser = service.addUser(name, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Could not Register User. Try a different username.");
			return "register";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "welcome";
	}
	
	
}
