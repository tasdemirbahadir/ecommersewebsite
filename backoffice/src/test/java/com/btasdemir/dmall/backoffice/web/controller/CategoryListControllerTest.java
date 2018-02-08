package com.btasdemir.dmall.backoffice.web.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.backoffice.web.controller.CategoryListController;
import com.btasdemir.dmall.backoffice.web.test.BackofficeBaseTest;
import com.btasdemir.dmall.commons.core.dto.CategoryDto;
import com.btasdemir.dmall.commons.core.service.CategoryService;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;

public class CategoryListControllerTest extends BackofficeBaseTest {

	@InjectMocks
	CategoryListController controller;
	
	@Mock
	private CategoryService categoryService;
	
	private BuilderUtils builderUtils;
	private CategoryDto category;
	private List<CategoryDto> categories;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
		category = builderUtils.categoryDtoBuilder().categoryKey("electronics").name("Electronics").id(1L).build();
		categories = Arrays.asList(category);
	}
	
	@Test
	public void testGetCategories() {
		when(categoryService.findAllDto()).thenReturn(categories);
		
		controller.loadData();
		List<CategoryDto> resultCategories = controller.getCategories();
		
		assertThat(resultCategories, hasSize(categories.size()));
		assertEquals(resultCategories, categories);
	}
	
}
