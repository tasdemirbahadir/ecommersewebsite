package com.btasdemir.dmall.commons.core.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.ProductDao;
import com.btasdemir.dmall.commons.core.service.ProductService;

public class ProductServiceTest extends BaseTest {

	@InjectMocks
	private ProductService productService;
	
	@Mock
	private ProductDao productDao;

	@Test
	public void testFindAll() {
		productService.findAll();
		verify(productDao).findAll();
	}

}
