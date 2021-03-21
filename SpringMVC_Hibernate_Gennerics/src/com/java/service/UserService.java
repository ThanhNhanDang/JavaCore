package com.java.service;

import java.util.List;

import com.java.dto.UserDto;

public interface UserService {
	List<UserDto> 	getList();
	boolean 		add(UserDto dto);
	boolean 		delete(int id);
	boolean 		edit(UserDto dto);
	UserDto 		findById(int id);
}
