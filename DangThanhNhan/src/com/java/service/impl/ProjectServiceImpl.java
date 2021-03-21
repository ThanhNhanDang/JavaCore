package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.ProjectDto;
import com.java.entity.Project;
import com.java.repository.ProjectRepository;
import com.java.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	private ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public List<ProjectDto> getProjectDtos(){
		List<ProjectDto> dtos = new ArrayList<ProjectDto>();
		try {
			List<Project> entities = projectRepository.getProjects();
			for(Project entity: entities) {
				ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getStarDate(), entity.getEndDate());
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("bug");
			e.printStackTrace();
		}
		return dtos;
	}
	
	public int add(ProjectDto dto) {
		try {
			Project entity = new Project();
			entity.setEndDate(dto.getEndDate());
			entity.setName(dto.getName());
			entity.setStarDate(dto.getStarDate());
			System.out.println(dto.getName());
			System.out.println(dto.getStarDate());
			System.out.println(dto.getEndDate());
			projectRepository.add(entity);
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("bug");
		return -1;
	}
	public int edit(ProjectDto dto) {
		try {
			Project project = new Project(dto.getId(), dto.getName(), dto.getStarDate(), dto.getEndDate());
			projectRepository.edit(project);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ProjectDto findById(int id) {
		try {
			Project entity = projectRepository.findById(id);
			ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getStarDate(), entity.getEndDate());
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete (int id) {
		try {
			projectRepository.detele(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
