package com.java.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.ProjectDto;
import com.java.service.ProjectService;
import com.java.util.PATH;
import com.java.util.URL;

@Controller
@Scope("prototype")
@RequestMapping(URL.INDEX_PROJECT)

public class ProjectController {
	private ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@RequestMapping(value = "",method = RequestMethod.GET )
	public String index(ModelMap map) {
		List<ProjectDto> dtos = projectService.getProjectDtos();
		
		map.addAttribute("listProject", dtos);
		return PATH.INDEX_PROJECT;
	}
	
	@RequestMapping(value =URL.ADD_PROJECT, method = RequestMethod.GET)
	public String add() {
		return PATH.ADD_PROJECT;
	}
	
	@RequestMapping(value =URL.ADD_PROJECT, method = RequestMethod.POST)
	public String add(@RequestParam("name") String name, @RequestParam("starDate") String starDate, @RequestParam("endDate") String endDate){
		ProjectDto dto = new ProjectDto(
				name, starDate, endDate);
		projectService.add(dto);
		return "redirect:/" + URL.INDEX_PROJECT; 
	}
	
	@RequestMapping(value=URL.EDIT_PROJECT, method = RequestMethod.GET)
	public String edit(@RequestParam("id") String id, ModelMap map) {
		int primary = Integer.valueOf(id);
		ProjectDto dto = projectService.findById(primary);
		map.addAttribute("dto", dto);
		return PATH.EDIT_PROJECT;
	}
	@RequestMapping(value =URL.EDIT_PROJECT, method = RequestMethod.POST)
	public String edit(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("starDate")String starDate, @RequestParam("endDate")String endDate) {
		int primary = Integer.valueOf(id);
		ProjectDto dto = new ProjectDto(primary, name, starDate, endDate);
		projectService.edit(dto);
		return "redirect:/"+URL.INDEX_PROJECT;
	}
	
	@RequestMapping(value = URL.DELETE_PROJECT, method =RequestMethod.GET)
	public String delete(@RequestParam("id") String id) {
		int primary = Integer.valueOf(id);
		projectService.delete(primary);
		return "redirect:/"+ URL.INDEX_PROJECT;
	}
}
