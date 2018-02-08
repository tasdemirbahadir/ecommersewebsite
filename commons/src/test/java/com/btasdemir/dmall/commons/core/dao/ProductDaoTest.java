package com.btasdemir.dmall.commons.core.dao;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.ProductDao;
import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.Product;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.repository.ProductRepository;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class ProductDaoTest extends BaseTest {

	@Mock
	private ProductRepository repository;
	
	@InjectMocks
	private ProductDao productDao;
	
	@Mock
	private EntityDaoService entityDaoService;
	
	private BuilderUtils builderUtils;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
	}
	
	@Test
	public void save() {
		User user = builderUtils.userBuilder()
				.firstName("firstname")
				.lastName("lastname")
				.email("email")
				.password("password")
				.role("SELLER")
				.build();
		
		Product entity = builderUtils.productBuilder().title("title").description("description").user(user).build();
		productDao.save(entity);
		verify(entityDaoService).saveEntity(entity, repository);
	}
	
	@Test
	public void find() {
		Long id = 1L;
		productDao.find(id);
		verify(repository).findOne(id);
	}
	
	@Test
	public void findAll() {
		productDao.findAll();
		verify(repository).findAll();		
	}
	
}
