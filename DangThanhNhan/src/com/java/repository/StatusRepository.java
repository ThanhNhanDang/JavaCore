package com.java.repository;

import java.util.List;

import com.java.entity.Status;

public interface StatusRepository {
	List<Status> getList();
	void 		add(Status status);
	void 		delete(int id);
	void 		edit(Status status);
	Status 		findById(int id);
}
