package com.btasdemir.dmall.commons.core.dao;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.CategoryDao;
import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.Category;
import com.btasdemir.dmall.commons.core.repository.CategoryRepository;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class CategoryDaoTest extends BaseTest {

	@Mock
	private CategoryRepository repository;
	
	@InjectMocks
	private CategoryDao categoryDao;
	
	@Mock
	private EntityDaoService entityDaoService;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
	}
	
	@Test
	public void save() {
		Category entity = builderUtils.categoryBuilder()
				.categoryKey("ELECTRONIC")
				.name("Electronic")
				.build();
		categoryDao.save(entity);
		verify(entityDaoService).saveEntity(entity, repository);
	}
	
	@Test
	public void find() {
		Long id = 1L;
		categoryDao.find(id);
		verify(repository).findOne(id);
	}
	
	@Test
	public void findAll() {
		categoryDao.findAll();
		verify(repository).findAll();		
	}
	
}
