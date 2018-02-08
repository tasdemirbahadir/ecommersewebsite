package com.btasdemir.dmall.commons.core.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.UserDao;
import com.btasdemir.dmall.commons.core.service.UserService;

public class UserServiceTest extends BaseTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserDao userDao;

	@Test
	public void testFindAll() {
		userService.findAll();
		verify(userDao).findAll();
	}

}
