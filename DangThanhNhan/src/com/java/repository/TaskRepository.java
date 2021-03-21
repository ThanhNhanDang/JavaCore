package com.java.repository;

import java.util.List;


import com.java.entity.Task;

public interface TaskRepository {
	List<Task> 	getTask();
	void 		add(Task task);
	Task 		findById(int id);
	void 		edit(Task task);
	void 		detele(int id);
}
