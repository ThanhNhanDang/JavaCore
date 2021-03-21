package com.java.repository;

import java.util.List;

import com.java.entity.User;

public interface UserRepository {
	List<User> 	getList();
	void 		add(User user);
	void 		delete(int id);
	void 		edit(User user);
	User 		findById(int id);
}
