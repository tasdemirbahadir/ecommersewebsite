package com.btasdemir.dmall.commons.core.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.btasdemir.dmall.commons.core.dao.service.EntityDaoService;
import com.btasdemir.dmall.commons.core.domain.Role;
import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.repository.RoleRepository;

@Component
public class RoleDao implements EntityDao<Role> {
	
	@Autowired
	private RoleRepository repository;
	
	@Autowired
	private EntityDaoService entityDaoService;
	
	@Override
	@Transactional(readOnly = false)
	public DaoResult<Role> save(Role entity) {
		return entityDaoService.saveEntity(entity, repository);
	}

	@Override
	public Role find(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Collection<Role> findAll() {
		return repository.findAll();
	}
	
	@Override
	public void delete(Role entity) {
		repository.delete(entity);
	}
	
}
