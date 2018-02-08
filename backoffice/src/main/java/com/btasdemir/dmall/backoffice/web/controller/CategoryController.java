package com.btasdemir.dmall.backoffice.web.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.btasdemir.dmall.commons.core.dto.CategoryDto;
import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.repository.value.DB_ERROR_TYPE;
import com.btasdemir.dmall.commons.core.service.CategoryService;

@Scope(value = "session")
@Component(value = "categoryController")
@ELBeanName(value = "categoryController")
@Join(path = "/manage/category", to = "/category-form.jsf")
public class CategoryController {
	
	//private static final int CAT_LEVEL = 3;
	
	private static final String SAVE_RESULT_PATH = "/category-list.xhtml?faces-redirect=true";
	private static final String SAVE_RESULT_ERROR_PATH = "/category-list.xhtml?constraint_error=true";
	
	@Autowired
	private CategoryService categoryService;

	private CategoryDto category = new CategoryDto();
	
	private List<CategoryDto> categories;
	
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		categories = categoryService.findAllDto();
	}

	public List<CategoryDto> getCategories() {
		return categories;
	}

	public String save() {
		setParent();
		DaoResult<CategoryDto> daoResult = categoryService.save(category);
		category = new CategoryDto();
		return getSaveResultPath(daoResult);
	}
	
	private String getSaveResultPath(DaoResult<CategoryDto> daoResult) {
		if (DB_ERROR_TYPE.UNIQUE_CONSTRAINT.equals(daoResult.getDbErrorType())) {
			return SAVE_RESULT_ERROR_PATH;
		} else {
			return SAVE_RESULT_PATH;
		}
	}
	
	private void setParent() {
		if (category.getParentCategoryId() != null) {
			category.setParent(categoryService.find(category.getParentCategoryId()));
		}
	}

	public CategoryDto getCategory() {
		return category;
	}

}