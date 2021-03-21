package com.JAVA.project.service;

import java.util.List;
import com.JAVA.project.model.Product;
import com.JAVA.project.repository.ProductRepository;

public class ProductService {
	private ProductRepository repository;

	public ProductService() {
		repository = new ProductRepository();

		/*
		 * productList.add(new Product("1", "TV", "LG1", "TV LG", 100));
		 * productList.add(new Product("2", "TV", "LG2", "TV LG", 200));
		 * productList.add(new Product("3", "TV", "LG3", "TV LG", 300));
		 * productList.add(new Product("4", "TV", "LG4", "TV LG", 400));
		 * productList.add(new Product("5", "TV", "LG5", "TV LG", 500));
		 * productList.add(new Product("6", "TV", "LG6", "TV LG", 600));
		 * productList.add(new Product("7", "TV", "LG7", "TV LG", 700));
		 * productList.add(new Product("8", "TV", "LG8", "TV LG", 800));
		 * productList.add(new Product("9", "TV", "LG9", "TV LG", 900));
		 * productList.add(new Product("10", "TV", "LG10", "TV LG", 1000));
		 */

	}

	public void testConnection() {
		repository.testConnection();
	}

	public List<Product> getAllProducts() {
		return repository.getAllProduct();
	}

	public boolean add(Product product) {
		return repository.getAdd(product);
	}

	public int delete(int id) {
		
		return repository.postDelete(id);
	}

	 public int update(Product product){ 
		 return repository.postUpdate(product);
	 }
	 public Product getProductById(int id) {
		return repository.getUpdate(id);
	  }
	 
}
