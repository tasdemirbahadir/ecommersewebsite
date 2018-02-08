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
import com.btasdemir.dmall.commons.core.dao.CategoryDao;
import com.btasdemir.dmall.commons.core.domain.Category;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class CategoryDaoIntegrationTest extends ContextAwareTest {

	@Autowired
	private CategoryDao categoryDao;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void save() {
		Category entity = builderUtils.categoryBuilder()
				.categoryKey("ELECTRONIC")
				.name("Electronic")
				.build();
		assertThat(entity.getId(), nullValue());
		entity = categoryDao.save(entity).getEntity();
		assertThat(entity.getId(), notNullValue());
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void find() {
		Category entity = categoryDao.save(builderUtils.categoryBuilder()
				.categoryKey("ELECTRONIC")
				.name("Electronic")
				.build()).getEntity();
		entity = categoryDao.find(entity.getId());
		assertThat(entity, notNullValue());
	}
	
	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void findAll() {
		Collection<Category> entities = new ArrayList<>();
		entities.add(categoryDao.save(builderUtils.categoryBuilder().categoryKey("ELECTRONIC").name("Electronic").build()).getEntity());
		entities.add(categoryDao.save(builderUtils.categoryBuilder().categoryKey("KITCHEN").name("Kitchen").build()).getEntity());
		entities.add(categoryDao.save(builderUtils.categoryBuilder().categoryKey("SPORTS").name("sports").build()).getEntity());
		Collection<Category> all = categoryDao.findAll();
		assertThat(all, equalTo(entities));
	}
	
}
