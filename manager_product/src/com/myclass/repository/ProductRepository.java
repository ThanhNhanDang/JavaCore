package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Product;

public interface ProductRepository {
	List<Product> findAll();
	void save(Product entity);
	Product findById(int id);
	void delete(int id);
}
