package com.java.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Task;
import com.java.repository.TaskRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)


public class TaskRepositoryImpl implements TaskRepository{
	
	private SessionFactory factory;
	
	public TaskRepositoryImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Task> getTask() {
		Session session = factory.getCurrentSession();
		Query<Task> query = session.createQuery("FROM Task", Task.class);
		
		return query.getResultList();

	}

	@Override
	public void add(Task task) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(task);
		
	}

	@Override
	public Task findById(int id) {
		Session session = factory.getCurrentSession();
		return session.find(Task.class, id);
	}

	@Override
	public void edit(Task task) {
		Session session = factory.getCurrentSession();
		session.update(task);
		
	}

	@Override
	public void detele(int id) {
		Session session =  factory.getCurrentSession();
		Task entity = session.find(Task.class, id);
		session.remove(entity);
		
	}
}
	

	
