package com.myclass.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;

@Controller
@Scope("prototype")
@RequestMapping("category")
public class CategoryController {
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<CategoryDto> dtos = categoryService.getAll();
		model.addAttribute("listCategory", dtos);
		return "category/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {	
		return "category/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam("name") String name) {
		CategoryDto dto = new CategoryDto(name);
		categoryService.add(dto);	
		return "redirect:/category";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		CategoryDto dto = categoryService.getById(id);
		model.addAttribute("category", dto);
		return "category/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name) {
		CategoryDto dto = new CategoryDto(id, name);
		categoryService.update(dto);
		return "redirect:/category";
	}
}
