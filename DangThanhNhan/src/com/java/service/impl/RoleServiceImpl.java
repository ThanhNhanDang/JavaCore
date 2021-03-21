package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.RoleDto;
import com.java.entity.Role;
import com.java.repository.RoleRepository;
import com.java.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	private RoleRepository repository;
	
	public RoleServiceImpl(RoleRepository repository) {
		this.repository = repository;
	}
	
	public List<RoleDto> getList(){
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		try {
			List<Role> entities = repository.getList();
			for(Role entity: entities) {
				RoleDto dto = new RoleDto(entity.getId(), entity.getName(), entity.getDes());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("bug");
			e.printStackTrace();
		}
		return dtos;
	}
	
	public int add(RoleDto dto) {
		try {
			Role role = new Role(dto.getName(), dto.getDes());
			repository.add(role);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	public RoleDto findById(int id) {
		try {
			Role role = repository.findById(id);
			RoleDto dto = new RoleDto(role.getId(), role.getName(), role.getDes());
			return dto;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int delete(int id) {
		try {
			repository.delete(id);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int edit(RoleDto dto) {
		try {
			Role role = new Role(dto.getId(),dto.getName(), dto.getDes());
			repository.edit(role);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

}
