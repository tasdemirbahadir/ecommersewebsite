package com.btasdemir.dmall.commons.core.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.repository.UserRepository;

@Component
public class UserDao implements EntityDao<User> {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private EntityDaoService entityDaoService;
	
	@Override
	@Transactional(readOnly = false)
	public DaoResult<User> save(User entity) {
		return entityDaoService.saveEntity(entity, repository);
	}

	@Override
	public User find(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Collection<User> findAll() {
		return repository.findAll();
	}
	
	@Override
	public void delete(User entity) {
		repository.delete(entity);
	}
	
	public User findByUserName(String userName) {
		return repository.findByEmail(userName);
	}
	
}
