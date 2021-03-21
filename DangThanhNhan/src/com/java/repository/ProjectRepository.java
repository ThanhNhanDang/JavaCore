package com.java.repository;

import java.util.List;

import com.java.entity.Project;

public interface ProjectRepository {
	List<Project> 	getProjects();
	void 			add(Project project);
	Project 		findById(int id);
	void 			edit(Project project);
	void 			detele(int id);
}
