package com.btasdemir.dmall.commons.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btasdemir.dmall.commons.core.dao.ProductDao;
import com.btasdemir.dmall.commons.core.domain.Product;

@Service
public class ProductService {

	@Autowired 
	private ProductDao productDao;
	
	public List<Product> findAll() {
		return new ArrayList<>(productDao.findAll());
	}
	
}
