package com.btasdemir.dmall.commons.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btasdemir.dmall.commons.core.dao.UserDao;
import com.btasdemir.dmall.commons.core.domain.User;

@Service
public class UserService {

	@Autowired 
	private UserDao userDao;
	
	public List<User> findAll() {
		return new ArrayList<>(userDao.findAll());
	}
	
}
