package com.btasdemir.dmall.commons.core.dao;

import java.util.Collection;

import com.btasdemir.dmall.commons.core.model.DaoResult;

public interface EntityDao <T> {

	DaoResult<T> save(T entity);
	
	T find(Long id);
	
	Collection <T> findAll();
	
	void delete(T entity);
	
}
