package com.java.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.UserDto;
import com.java.service.UserService;
import com.java.util.PATH;
import com.java.util.URL;

@Controller
@Scope("prototype")
@RequestMapping(URL.INDEX_USER)
public class UserController {
	private UserService service;
	public UserController(UserService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getList(ModelMap map) {
		List<UserDto> list = service.getList();
		map.addAttribute("listUser", list);
		return PATH.INDEX_USER;
	}
	
	@RequestMapping(value =URL.ADD_USER, method = RequestMethod.GET)
	public String add() {
		return PATH.ADD_USER;
	}
	
	@RequestMapping(value = URL.ADD_USER, method = RequestMethod.POST)
	public String add(@RequestParam(name = "name")String name, ModelMap map) {
		UserDto dto =  new UserDto(name);
        service.add(dto);
		return "redirect:/" + URL.INDEX_USER;
	}
	
	@RequestMapping(value = URL.DELETE_USER)
	public String delete(@RequestParam(name = "id")String id) {
		int primary = Integer.valueOf(id);
		service.delete(primary);
		return "redirect:/" + URL.INDEX_USER;
	}
	
	@RequestMapping(value = URL.EDIT_USER, method = RequestMethod.GET)
	public String edit(@RequestParam(name ="id") String id, ModelMap map) {
		int pri =Integer.valueOf(id);
		UserDto dto = service.findById(pri);
		map.addAttribute("dto", dto);
		return PATH.EDIT_USER;
	}
	
	@RequestMapping(value = URL.EDIT_USER, method = RequestMethod.POST)
	public String edit(@RequestParam(name = "id")String id, @RequestParam(name = "name") String name) {
		int pri = Integer.valueOf(id);
		UserDto dto = new UserDto(pri, name);
		service.edit(dto);
		return "redirect:/"+ URL.INDEX_USER;
	}
}
