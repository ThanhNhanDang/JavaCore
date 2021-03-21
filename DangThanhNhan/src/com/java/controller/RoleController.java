package com.java.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.RoleDto;
import com.java.service.RoleService;
import com.java.util.PATH;
import com.java.util.URL;

@Controller
@Scope("prototype")
@RequestMapping(URL.INDEX_ROLE)
public class RoleController {
	private RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService= roleService;
	}
	
	@RequestMapping(value = "",method = RequestMethod.GET )
	public String index(ModelMap map) {
		List<RoleDto> dtos = roleService.getList();
		
		map.addAttribute("listRole", dtos);
		return PATH.INDEX_ROLE;
	}
	
	@RequestMapping(value =URL.ADD_ROLE, method = RequestMethod.GET)
	public String add() {
		return PATH.ADD_ROLE;
	}
	
	@RequestMapping(value = URL.ADD_ROLE, method = RequestMethod.POST)
	public String add(@RequestParam("name") String name, @RequestParam("des") String des){
		RoleDto dto = new RoleDto(
				name, des);
		roleService.add(dto);
		return "redirect:/"+URL.ADD_ROLE; 
	}
	
	@RequestMapping(value=URL.EDIT_ROLE, method = RequestMethod.GET)
	public String edit(@RequestParam("id") String id, ModelMap map) {
		int primary = Integer.valueOf(id);
		RoleDto dto = roleService.findById(primary);
		map.addAttribute("dto", dto);
		return PATH.EDIT_ROLE;
	}
	@RequestMapping(value =URL.EDIT_ROLE, method = RequestMethod.POST)
	public String edit(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("des")String des) {
		int primary = Integer.valueOf(id);
		RoleDto dto = new RoleDto(primary, name, des);
		roleService.edit(dto);
		return "redirect:/" + URL.INDEX_ROLE;
	}
	
	@RequestMapping(value = URL.DELETE_ROLE, method =RequestMethod.GET)
	public String delete(@RequestParam("id") String id) {
		int primary = Integer.valueOf(id);
		roleService.delete(primary);
		return "redirect:/" +URL.INDEX_ROLE;
	}
}
