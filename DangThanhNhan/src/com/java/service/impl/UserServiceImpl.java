package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.UserDto;
import com.java.entity.User;
import com.java.repository.UserRepository;
import com.java.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository repository;
	public UserServiceImpl(UserRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	@Override
	public List<UserDto> getList() {
		try {
			List<User> entities = repository.getList();
			List<UserDto> dtos = new ArrayList<UserDto>();
			for(User entity : entities) {
				UserDto dto = new UserDto(entity.getId(), entity.getName());
				dtos.add(dto);
			}
			
			return dtos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(UserDto dto) {
		try {
			User entity = new User(dto.getName());
			repository.add(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean delete(int id) {
		try {
			repository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean edit(UserDto dto) {
		try {
			User user = new User(dto.getId(), dto.getName());
			repository.edit(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public UserDto findById(int id) {
		try {
			User user = repository.findById(id);
			UserDto dto = new UserDto(user.getId(), user.getName());
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
