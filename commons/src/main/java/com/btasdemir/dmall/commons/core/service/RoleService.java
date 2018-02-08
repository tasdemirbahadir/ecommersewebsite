package com.btasdemir.dmall.commons.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btasdemir.dmall.commons.core.dao.RoleDao;
import com.btasdemir.dmall.commons.core.domain.Role;

@Service
public class RoleService {

	@Autowired 
	private RoleDao roleDao;
	
	public List<Role> findAll() {
		return new ArrayList<>(roleDao.findAll());
	}
	
}
