package com.java.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.StatusDto;
import com.java.service.StatusService;
import com.java.util.PATH;
import com.java.util.URL;

@Controller
@Scope("prototype")
@RequestMapping(URL.INDEX_STATUS)
public class StatusController {
	private StatusService service;
	public StatusController(StatusService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(ModelMap map) {
		List<StatusDto> list = service.getList();
		map.addAttribute("listStatus", list);
		return PATH.INDEX_STATUS;
	}
	
	@RequestMapping(value =URL.ADD_STATUS, method = RequestMethod.GET)
	public String add() {
		return PATH.ADD_STATUS;
	}
	
	@RequestMapping(value = URL.ADD_STATUS, method = RequestMethod.POST)
	public String add(@RequestParam(name = "name")String name, ModelMap map) {
		StatusDto dto =  new StatusDto(name);
        service.add(dto);
		return "redirect:/" + URL.INDEX_STATUS;
	}
	
	@RequestMapping(value = URL.DELETE_STATUS)
	public String delete(@RequestParam(name = "id")String id) {
		int primary = Integer.valueOf(id);
		service.delete(primary);
		return "redirect:/" + URL.INDEX_STATUS;
	}
	
	@RequestMapping(value = URL.EDIT_STATUS, method = RequestMethod.GET)
	public String edit(@RequestParam(name ="id") String id, ModelMap map) {
		int pri =Integer.valueOf(id);
		StatusDto dto = service.findById(pri);
		map.addAttribute("dto", dto);
		return PATH.EDIT_STATUS;
	}
	
	@RequestMapping(value = URL.EDIT_STATUS, method = RequestMethod.POST)
	public String edit(@RequestParam(name = "id")String id, @RequestParam(name = "name") String name) {
		int pri = Integer.valueOf(id);
		StatusDto dto = new StatusDto(pri, name);
		service.edit(dto);
		return "redirect:/"+ URL.INDEX_STATUS;
	}
}
