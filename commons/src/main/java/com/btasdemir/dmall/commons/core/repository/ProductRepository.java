package com.btasdemir.dmall.commons.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btasdemir.dmall.commons.core.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	
}
