package com.btasdemir.dmall.commons.core.dao;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.btasdemir.dmall.commons.core.ContextAwareTest;
import com.btasdemir.dmall.commons.core.dao.UserDao;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class UserDaoIntegrationTest extends ContextAwareTest {

	@Autowired
	private UserDao userDao;
	
	private User moderatorUser;
	private User adminUser;
	private User buyerUser;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
		moderatorUser = builderUtils.userBuilder()
				.firstName("firstname")
				.lastName("lastname")
				.email("email")
				.password("password")
				.role("CUSTOMER")
				.build();
		adminUser = builderUtils.userBuilder()
				.firstName("firstname")
				.lastName("lastname")
				.email("email")
				.password("password")
				.role("ADMIN")
				.build();
		buyerUser = builderUtils.userBuilder()
				.firstName("firstname")
				.lastName("lastname")
				.email("email")
				.password("password")
				.role("BUYER")
				.build();
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void save() {
		User entity = moderatorUser;
		assertThat(entity.getId(), nullValue());
		entity = userDao.save(entity).getEntity();
		assertThat(entity.getId(), notNullValue());
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void find() {
		User entity = userDao.save(moderatorUser).getEntity();
		entity = userDao.find(entity.getId());
		assertThat(entity, notNullValue());
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void findAll() {
		Collection<User> entities = new ArrayList<>();
		entities.add(userDao.save(moderatorUser).getEntity());
		entities.add(userDao.save(adminUser).getEntity());
		entities.add(userDao.save(buyerUser).getEntity());
		Collection<User> all = userDao.findAll();
		assertThat(all, equalTo(entities));
	}
	
}
