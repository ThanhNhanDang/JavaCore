package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryDto> getAll() {
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();
		try {
			List<Category> entities = categoryRepository.findAll();
			for (Category category : entities) {
				CategoryDto dto = new CategoryDto(category.getId(), category.getName());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dtos;
	}

	public int add(CategoryDto dto) {
		try{
			Category entity = new Category();
			entity.setName(dto.getName());
			categoryRepository.save(entity);
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public CategoryDto getById(int id) {
		try {
			Category entity = categoryRepository.findById(id);
			if(entity != null) 
				return new CategoryDto(entity.getId(), entity.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new CategoryDto();
	}

	public int update(CategoryDto dto) {
		System.out.println(dto.getId());
		try {
			Category entity = categoryRepository.findById(dto.getId());
			System.out.println(entity);
			if(entity == null) return -1;
			entity.setName(dto.getName());
			categoryRepository.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 1;
		
	}

}
