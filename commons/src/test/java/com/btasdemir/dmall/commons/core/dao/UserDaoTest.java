package com.btasdemir.dmall.commons.core.dao;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.UserDao;
import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.repository.UserRepository;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class UserDaoTest extends BaseTest {

	@Mock
	private UserRepository repository;
	
	@InjectMocks
	private UserDao userDao;
	
	@Mock
	private EntityDaoService entityDaoService;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
	}
	
	@Test
	public void save() {
		User entity = builderUtils.userBuilder()
				.firstName("firstname")
				.lastName("lastname")
				.email("email")
				.password("password")
				.role("ADMIN")
				.build();
		userDao.save(entity);
		verify(entityDaoService).saveEntity(entity, repository);
	}
	
	@Test
	public void find() {
		Long id = 1L;
		userDao.find(id);
		verify(repository).findOne(id);
	}
	
	@Test
	public void findAll() {
		userDao.findAll();
		verify(repository).findAll();		
	}
	
}
