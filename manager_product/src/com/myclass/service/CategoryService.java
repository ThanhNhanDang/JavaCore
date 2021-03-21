package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;

public interface CategoryService {
	List<CategoryDto> getAll();
	int add(CategoryDto dto);
	CategoryDto getById(int id);
	int update(CategoryDto dto);
}
