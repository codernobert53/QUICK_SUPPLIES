package com.quick.supplies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.supplies.domain.User;
import com.quick.supplies.domain.repository.UserDao;
import com.quick.supplies.service.LoginService;

@Service
public class LoginUsersImpl implements LoginService{

	@Autowired
	 private UserDao userDao;
	
	@Override
	public String loginUser(User user) {
		return userDao.loginUser(user);
	}

}
