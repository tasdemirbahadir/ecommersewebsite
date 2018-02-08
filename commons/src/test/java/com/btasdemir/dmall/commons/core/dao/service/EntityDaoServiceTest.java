package com.btasdemir.dmall.commons.core.dao.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.Product;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.repository.ProductRepository;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class EntityDaoServiceTest extends BaseTest {
	
	@InjectMocks
	private EntityDaoService entityDaoService;
	
	@Mock
	private ProductRepository productRepository;
	
	private Product entity;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
		User user = builderUtils.userBuilder()
				.firstName("firstname")
				.lastName("lastname")
				.email("email")
				.password("password")
				.role("BUYER")
				.build();
		entity = builderUtils.productBuilder()
				.title("title")
				.description("description")
				.user(user).build();
	}
	
	@Test
	public void testSaveEntity() {
		entityDaoService.saveEntity(entity, productRepository);
		verify(productRepository).save(entity);
	}

}
