package com.btasdemir.dmall.commons.core.util;

import com.btasdemir.dmall.commons.core.domain.Category;
import com.btasdemir.dmall.commons.core.domain.Product;
import com.btasdemir.dmall.commons.core.domain.Role;
import com.btasdemir.dmall.commons.core.domain.User;
import com.btasdemir.dmall.commons.core.dto.CategoryDto;

import lombok.Builder;
import lombok.NonNull;

public class BuilderUtils {
	
	@Builder(builderMethodName = "categoryBuilder")
	public Category newCategory(Long id, @NonNull String categoryKey, @NonNull String name) {
		Category category = new Category(categoryKey, name);
		category.setId(id);
		return category;
	}
	
	@Builder(builderMethodName = "categoryDtoBuilder")
	public CategoryDto newCategoryDto(Long id, String categoryKey, String name) {
		CategoryDto categoryDto = new CategoryDto(categoryKey, name);
		categoryDto.setId(id);
		return categoryDto;
	}
	
	@Builder(builderMethodName = "userBuilder")
	public User newUser(String firstName, String lastName, String email, String password, String role) {
		return new User(firstName, lastName, email, password, new Role(role));
	}
	
	@Builder(builderMethodName = "productBuilder")
	public Product newUser(String title, String description, User user) {
		return new Product(title, description, user);
	}
	
	@Builder(builderMethodName = "roleBuilder")
	public Role newRole(Long id, String name, String description) {
		return new Role(id, name, description);
	}

}
