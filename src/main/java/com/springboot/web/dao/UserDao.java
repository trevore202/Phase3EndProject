package com.springboot.web.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.web.model.User;

@Repository
public interface UserDao extends CrudRepository<User, String>{

}
