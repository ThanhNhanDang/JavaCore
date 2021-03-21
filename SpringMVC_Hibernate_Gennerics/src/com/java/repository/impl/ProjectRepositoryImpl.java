package com.java.repository.impl;


import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Project;
@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)


public class ProjectRepositoryImpl extends BaseRepositoryImpl<Project, Integer>{
	public ProjectRepositoryImpl(SessionFactory factory) {
		super(factory, Project.class);
	}
	

}
