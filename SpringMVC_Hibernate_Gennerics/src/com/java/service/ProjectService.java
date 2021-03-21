package com.java.service;

import java.util.List;

import com.java.dto.ProjectDto;

public interface ProjectService {
	List<ProjectDto> 	getProjectDtos();
	int 				add (ProjectDto dto);
	ProjectDto 			findById(int id);
	int					edit(ProjectDto dto);
	int 				delete(int id);
	
}



