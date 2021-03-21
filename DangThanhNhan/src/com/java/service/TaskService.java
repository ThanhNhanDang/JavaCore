package com.java.service;

import java.util.List;

import com.java.dto.TaskDto;

public interface TaskService {
	List<TaskDto> 	getTask();
	boolean 		add(TaskDto dto);
	TaskDto 		findById(int id);
	boolean 		edit(TaskDto dto);
	boolean 		detele(int id);
}
