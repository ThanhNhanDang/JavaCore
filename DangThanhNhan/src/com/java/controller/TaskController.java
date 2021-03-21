package com.java.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.TaskDto;
import com.java.service.TaskService;
import com.java.util.PATH;
import com.java.util.URL;

@Controller
@Scope("prototype")
@RequestMapping(URL.INDEX_TASK)

public class TaskController {
	private TaskService service;
	
	public TaskController(TaskService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "",method = RequestMethod.GET )
	public String index(ModelMap map) {
		List<TaskDto> dtos = service.getTask();
		
		map.addAttribute("listTask", dtos);
		return PATH.INDEX_TASK;
	}
	
	@RequestMapping(value =URL.ADD_TASK, method = RequestMethod.GET)
	public String add() {
		return PATH.ADD_TASK;
	}
	
	@RequestMapping(value =URL.ADD_TASK, method = RequestMethod.POST)
	public String add(@RequestParam("name") String name, @RequestParam("starDate") String starDate, @RequestParam("endDate") String endDate){
		TaskDto dto = new TaskDto(
				name, starDate, endDate);
		service.add(dto);
		return "redirect:/" + URL.INDEX_TASK; 
	}
	
	@RequestMapping(value=URL.EDIT_TASK, method = RequestMethod.GET)
	public String edit(@RequestParam("id") String id, ModelMap map) {
		int primary = Integer.valueOf(id);
		TaskDto dto = service.findById(primary);
		map.addAttribute("dto", dto);
		return PATH.EDIT_TASK;
	}
	@RequestMapping(value =URL.EDIT_TASK, method = RequestMethod.POST)
	public String edit(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("starDate")String starDate, @RequestParam("endDate")String endDate) {
		int primary = Integer.valueOf(id);
		TaskDto dto = new TaskDto(primary, name, starDate, endDate);
		service.edit(dto);
		return "redirect:/"+URL.INDEX_TASK;
	}
	
	@RequestMapping(value = URL.DELETE_TASK, method = RequestMethod.GET)
	public String delete(@RequestParam("id") String id) {
		int primary = Integer.valueOf(id);
		service.detele(primary);
		return "redirect:/"+ URL.INDEX_TASK;
	}
}
