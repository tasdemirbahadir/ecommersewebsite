package com.btasdemir.dmall.commons.core.dao.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.repository.value.DB_ERROR_TYPE;

@Service
public class EntityDaoService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EntityDaoService.class);
	
	public <T, S extends Serializable> DaoResult<T> saveEntity(T entity, JpaRepository<T, S> entityRepository) {
		DaoResult<T> daoResult = new DaoResult<>(entity);
		
		try {
			entityRepository.save(entity);
		} catch (DataIntegrityViolationException ex) {
			LOGGER.warn(ex.getMessage());
			daoResult.setDbErrorType(DB_ERROR_TYPE.UNIQUE_CONSTRAINT);
		}
		
		return daoResult;
	}

}
