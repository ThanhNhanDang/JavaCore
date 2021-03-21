package com.java.repository;

import java.util.List;

import com.java.entity.Role;

public interface RoleRepository {
	List<Role> 	getList();
	void 		add (Role role);
	void	 	edit (Role role);
	Role 		findById(int id);
	void 		delete(int id);
}
