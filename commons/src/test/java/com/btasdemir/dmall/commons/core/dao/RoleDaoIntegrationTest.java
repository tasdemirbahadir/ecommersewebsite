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
import com.btasdemir.dmall.commons.core.dao.RoleDao;
import com.btasdemir.dmall.commons.core.domain.Role;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class RoleDaoIntegrationTest extends ContextAwareTest {

	@Autowired
	private RoleDao roleDao;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void save() {
		Role entity = builderUtils.roleBuilder().name("SELLER").build();
		assertThat(entity.getId(), nullValue());
		entity = roleDao.save(entity).getEntity();
		assertThat(entity.getId(), notNullValue());
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void find() {
		Role entity = roleDao.save(builderUtils.roleBuilder().name("SELLER").build()).getEntity();
		entity = roleDao.find(entity.getId());
		assertThat(entity, notNullValue());
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void findAll() {
		Collection<Role> entities = new ArrayList<>();
		entities.add(builderUtils.roleBuilder().id(1L).name("ADMIN").description("Admin Role").build());
		entities.add(builderUtils.roleBuilder().id(2L).name("BUYER").description("Buyer Role").build());
		entities.add(builderUtils.roleBuilder().id(3L).name("SELLER").description("Seller Role").build());
		entities.add(builderUtils.roleBuilder().id(4L).name("MODERATOR").description("Moderator Role").build());
		Collection<Role> all = roleDao.findAll();
		assertThat(all, equalTo(entities));
	}
	
}
