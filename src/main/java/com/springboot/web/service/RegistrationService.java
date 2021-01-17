package com.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.dao.UserDao;
import com.springboot.web.model.User;

@Service
public class RegistrationService {

	@Autowired
	UserDao dao;
	
	public boolean addUser(String name, String password) {
		
		try{
			User u = new User(name,password);
			dao.save(u);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
}
