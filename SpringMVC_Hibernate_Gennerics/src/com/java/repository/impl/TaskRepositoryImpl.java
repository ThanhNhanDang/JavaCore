package com.java.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Task;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)


public class TaskRepositoryImpl extends BaseRepositoryImpl<Task, Integer>{

	public TaskRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory, Task.class);
		// TODO Auto-generated constructor stub
	}
}
	

	
