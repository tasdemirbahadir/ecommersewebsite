package com.btasdemir.dmall.commons.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btasdemir.dmall.commons.core.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
	
}
