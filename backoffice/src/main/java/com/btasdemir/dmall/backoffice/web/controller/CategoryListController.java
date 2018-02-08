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
import com.btasdemir.dmall.commons.core.service.CategoryService;

@Scope(value = "session")
@Component(value = "categoryListController")
@ELBeanName(value = "categoryListController")
@Join(path = "/manage", to = "/category-list.jsf")
public class CategoryListController {
	
	@Autowired
	private CategoryService categoryService;
	
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
}
