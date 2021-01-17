package com.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.web.dao.UserDao;
import com.springboot.web.model.User;

@Service
public class LoginService {
	
	@Autowired
	UserDao dao;

	public boolean validateUser(String username, String password) {
		User u = dao.findOne(username);
		if (u!= null) {
			if(password.equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
