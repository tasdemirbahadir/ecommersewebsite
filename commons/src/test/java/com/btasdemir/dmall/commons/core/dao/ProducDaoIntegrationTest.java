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
import com.btasdemir.dmall.commons.core.dao.ProductDao;
import com.btasdemir.dmall.commons.core.domain.Product;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class ProducDaoIntegrationTest extends ContextAwareTest {

	@Autowired
	private ProductDao productDao;

	private User user;

	private BuilderUtils builderUtils;

	@Before
	public void initialize() {
		builderUtils = new BuilderUtils();
		user = builderUtils.userBuilder()
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
		Product entity = builderUtils.productBuilder().title("title").description("description").user(user).build();
		assertThat(entity.getId(), nullValue());
		entity = productDao.save(entity).getEntity();
		assertThat(entity.getId(), notNullValue());
	}

	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void find() {
		Product entity = productDao.save(builderUtils.productBuilder().title("title").description("description").user(user).build()).getEntity();
		entity = productDao.find(entity.getId());
		assertThat(entity, notNullValue());
	}

	@Test
	@Rollback
	@Transactional(readOnly = false)
	public void findAll() {
		Collection<Product> entities = new ArrayList<>();
		entities.add(productDao.save(builderUtils.productBuilder().title("title1").description("description1").user(user).build()).getEntity());
		entities.add(productDao.save(builderUtils.productBuilder().title("title2").description("description2").user(user).build()).getEntity());
		entities.add(productDao.save(builderUtils.productBuilder().title("title3").description("description3").user(user).build()).getEntity());
		Collection<Product> all = productDao.findAll();
		assertThat(all, equalTo(entities));
	}

}
