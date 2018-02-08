package com.btasdemir.dmall.commons.core.service;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.btasdemir.dmall.commons.core.BaseTest;
import com.btasdemir.dmall.commons.core.dao.CategoryDao;
import com.btasdemir.dmall.commons.core.domain.Category;
import com.btasdemir.dmall.commons.core.dto.CategoryDto;
import com.btasdemir.dmall.commons.core.model.DaoResult;
import com.btasdemir.dmall.commons.core.service.CategoryService;
import com.btasdemir.dmall.commons.core.util.BuilderUtils;
import com.btasdemir.dmall.commons.core.util.ConversionUtils;
import com.btasdemir.dmall.commons.core.util.DtoUtils;

public class CategoryServiceTest extends BaseTest {
	
	private static final long CATEGORY_ID_1 = 1L;

	@InjectMocks
	private CategoryService categoryService;

	@Mock
	private CategoryDao categoryDao;
	
	@Mock
	private ConversionUtils conversionUtils;
	
	@Mock
	private DtoUtils dtoUtils;
	
	private BuilderUtils builderUtils;
	private List<CategoryDto> categoryDtos;
	private List<Category> categories;
	private CategoryDto categoryDto;
	private Category category;
	
	@Before
	public void init() {
		builderUtils = new BuilderUtils();
		categoryDto = builderUtils.categoryDtoBuilder().categoryKey("electronics").name("Electronics").id(CATEGORY_ID_1).build();
		categoryDtos = Arrays.asList(categoryDto);
		category = builderUtils.categoryBuilder().categoryKey("electronics").name("Electronics").id(CATEGORY_ID_1).build();
		categories = Arrays.asList(category);
	}

	@Test
	public void testFindAll() {
		categoryService.findAll();
		verify(categoryDao).findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAllDto() {
		when(conversionUtils.convertList(anyList(), any(Function.class))).thenReturn(categoryDtos);
		List<CategoryDto> foundCategoryDtos = categoryService.findAllDto();
		assertThat(foundCategoryDtos, equalTo(categoryDtos));
	}
	
	@Test
	public void testSave() {
		categoryService.save(category);
		verify(categoryDao).save(category);
	}
	
	@Test
	public void testSaveDto() {
		DaoResult<Category> daoResult = new DaoResult<Category>(category);
		DaoResult<CategoryDto> daoResultDto = new DaoResult<>(categoryDto);
		
		when(dtoUtils.toCategory(categoryDto)).thenReturn(category);
		when(dtoUtils.toCategoryDto(category)).thenReturn(categoryDto);
		when(categoryDao.save(category)).thenReturn(daoResult);
		
		DaoResult<CategoryDto> newDaoResultDto = categoryService.save(categoryDto);
		
		verify(categoryDao).save(category);
		assertEquals(newDaoResultDto, daoResultDto);
	}
	
	@Test
	public void testFind() {
		when(categoryDao.find(CATEGORY_ID_1)).thenReturn(category);
		when(dtoUtils.toCategoryDto(category)).thenReturn(categoryDto);
		
		CategoryDto found = categoryService.find(CATEGORY_ID_1);
		
		verify(categoryDao).find(CATEGORY_ID_1);
		assertEquals(found, categoryDto);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindByParentIdDto() {
		when(categoryDao.findByParentId(CATEGORY_ID_1)).thenReturn(categories);
		when(conversionUtils.convertList(anyList(), any(Function.class))).thenReturn(categoryDtos);
		
		List<CategoryDto> foundCategoryDtos = categoryService.findByParentIdDto(CATEGORY_ID_1);
		
		assertEquals(foundCategoryDtos, categoryDtos);
	}

}
