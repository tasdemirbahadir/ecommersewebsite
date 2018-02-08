package com.btasdemir.dmall.commons.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btasdemir.dmall.commons.core.dao.CategoryDao;
import com.btasdemir.dmall.commons.core.domain.Category;
import com.btasdemir.dmall.commons.core.dto.CategoryDto;
import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.util.ConversionUtils;
import com.btasdemir.dmall.commons.core.util.DtoUtils;

@Service
public class CategoryService {

	@Autowired 
	private CategoryDao categoryDao;
	
	@Autowired
	private ConversionUtils conversionUtils;
	
	@Autowired
	private DtoUtils dtoUtils;
	
	public List<Category> findAll() {
		return new ArrayList<>(categoryDao.findAll());
	}
	
	public List<CategoryDto> findAllDto() {
		return conversionUtils.convertList(new ArrayList<>(categoryDao.findAll()), dtoUtils::toCategoryDto);
	}
	
	public DaoResult<CategoryDto> save(CategoryDto categoryDto) {
		DaoResult<Category> daoResult = categoryDao.save(dtoUtils.toCategory(categoryDto));
		return new DaoResult<CategoryDto>(dtoUtils.toCategoryDto(daoResult.getEntity()), daoResult.getDbErrorType());
	}
	
	public void save(Category category) {
		categoryDao.save(category);
	}
	
	public CategoryDto find(Long id) {
		return dtoUtils.toCategoryDto(categoryDao.find(id));
	}
	
	public List<CategoryDto> findByParentIdDto(Long parentId) {
		return conversionUtils.convertList(new ArrayList<>(categoryDao.findByParentId(parentId)), dtoUtils::toCategoryDto);
	}
	
}
