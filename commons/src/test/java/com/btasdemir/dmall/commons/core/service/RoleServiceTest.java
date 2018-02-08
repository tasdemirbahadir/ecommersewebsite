package com.btasdemir.dmall.commons.core.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.RoleDao;
import com.btasdemir.dmall.commons.core.service.RoleService;

public class RoleServiceTest extends BaseTest {

	@InjectMocks
	private RoleService roleService;
	
	@Mock
	private RoleDao roleDao;

	@Test
	public void testFindAll() {
		roleService.findAll();
		verify(roleDao).findAll();
	}

}
