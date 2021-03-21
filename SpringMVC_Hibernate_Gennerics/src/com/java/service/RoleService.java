package com.java.service;

import java.util.List;

import com.java.dto.RoleDto;

public interface RoleService {
	List<RoleDto> 	getList();
	int 			add (RoleDto dto);
	RoleDto 		findById(int id);
	int 			edit(RoleDto dto);
	int 			delete(int id);
}
