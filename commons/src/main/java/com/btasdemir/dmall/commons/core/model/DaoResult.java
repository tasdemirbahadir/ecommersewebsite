package com.btasdemir.dmall.commons.core.model;

import com.btasdemir.dmall.commons.core.repository.value.DB_ERROR_TYPE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DaoResult <T> {
	
	@NonNull T entity;
	DB_ERROR_TYPE dbErrorType;

}
