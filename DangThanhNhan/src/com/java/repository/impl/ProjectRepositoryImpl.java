package com.java.repository.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Project;
import com.java.repository.ProjectRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)


public class ProjectRepositoryImpl implements ProjectRepository{
	
	private SessionFactory factory;
	
	public ProjectRepositoryImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	public List<Project> getProjects(){
		Session session = factory.getCurrentSession();
		Query<Project> query = session.createQuery("FROM Project", Project.class);
		return query.getResultList();
	}
	
	public void add(Project project) {
		Session session = factory.getCurrentSession();
		session.save(project);
	}
	
	public void edit(Project project) {
		Session session = factory.getCurrentSession();
		session.update(project);
		
	}
	
	public Project findById(int id) {
		Session session = factory.openSession();
		return session.find(Project.class, id);
	}

	public void detele(int id) {
		Session session = factory.getCurrentSession();
		Project project =  session.find(Project.class, id);
		session.remove(project);
		
	}

	
}
