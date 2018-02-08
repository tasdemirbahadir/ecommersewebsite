package com.btasdemir.dmall.commons.core.dao;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.RoleDao;
import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.Role;
import com.btasdemir.dmall.commons.core.repository.RoleRepository;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class RoleDaoTest extends BaseTest {

	@Mock
	private RoleRepository repository;
	
	@InjectMocks
	private RoleDao roleDao;
	
	@Mock
	private EntityDaoService entityDaoService;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
	}
	
	@Test
	public void save() {
		Role entity = builderUtils.roleBuilder().name("SELLER").build();
		roleDao.save(entity);
		verify(entityDaoService).saveEntity(entity, repository);
	}
	
	@Test
	public void find() {
		Long id = 1L;
		roleDao.find(id);
		verify(repository).findOne(id);
	}
	
	@Test
	public void findAll() {
		roleDao.findAll();
		verify(repository).findAll();		
	}
	
}
