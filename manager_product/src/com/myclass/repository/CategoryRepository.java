package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Category;

public interface CategoryRepository {
	List<Category> findAll();
	void save(Category entity);
	Category findById(int id);
	void delete(int id);
}
