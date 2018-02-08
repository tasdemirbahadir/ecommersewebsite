package com.btasdemir.dmall.commons.core.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.Category;
import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.repository.CategoryRepository;

@Component
public class CategoryDao implements EntityDao<Category> {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private EntityDaoService entityDaoService;
	
	@Override
	@Transactional(readOnly = false)
	public DaoResult<Category> save(Category entity) {
		return entityDaoService.saveEntity(entity, repository);
	}

	@Override
	public Category find(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Collection<Category> findAll() {
		return repository.findAll();
	}
	
	public List<Category> findByParentId(Long parentId) {
		return repository.findByParentId(parentId);
	}
	
	public void delete(Category entity) {
		repository.delete(entity);
	}
	
}
