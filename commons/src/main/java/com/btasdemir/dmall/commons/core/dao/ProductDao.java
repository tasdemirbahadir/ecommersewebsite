package com.btasdemir.dmall.commons.core.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.Product;
import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.repository.ProductRepository;

@Component
public class ProductDao implements EntityDao<Product> {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private EntityDaoService entityDaoService;
	
	@Override
	@Transactional(readOnly = false)
	public DaoResult<Product> save(Product entity) {
		return entityDaoService.saveEntity(entity, repository);
	}

	@Override
	public Product find(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Collection<Product> findAll() {
		return repository.findAll();
	}
	
	@Override
	public void delete(Product entity) {
		repository.delete(entity);
	}
	
}
