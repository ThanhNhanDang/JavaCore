package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.TaskDto;
import com.java.entity.Task;
import com.java.repository.TaskRepository;
import com.java.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	private TaskRepository repository;
	public TaskServiceImpl(TaskRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository= repository;
	}
	@Override
	public List<TaskDto> getTask() {
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		try {
			List<Task> entities = repository.getTask();
			for(Task entity: entities) {
				TaskDto dto = new TaskDto(entity.getId(), entity.getName(), entity.getStarDate(), entity.getEndDate());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("bug");
			e.printStackTrace();
		}
		return dtos;
	}
	@Override
	public boolean add(TaskDto dto) {
		try {
			Task entity = new Task();
			entity.setEndDate(dto.getEndDate());
			entity.setName(dto.getName());
			entity.setStarDate(dto.getStarDate());
			System.out.println(dto.getName());
			System.out.println(dto.getStarDate());
			System.out.println(dto.getEndDate());
			repository.add(entity);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("bug");
		return false;
	}
	@Override
	public TaskDto findById(int id) {
		try {
			Task entity = repository.findById(id);
			TaskDto dto = new TaskDto(entity.getId(), entity.getName(), entity.getStarDate(), entity.getEndDate());
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean edit(TaskDto dto) {
		try {
			Task entity = new Task(dto.getId(), dto.getName(), dto.getStarDate(), dto.getEndDate());
			repository.edit(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean detele(int id) {
		try {
			repository.detele(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
}
