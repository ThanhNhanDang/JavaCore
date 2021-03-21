package com.java.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Status;
import com.java.repository.StatusRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class StatusRepositoryImpl implements StatusRepository{
	private SessionFactory factory;
	
	public StatusRepositoryImpl(SessionFactory factory) {
		// TODO Auto-generated constructor stub
		this.factory = factory;
	}
	
	@Override
	public List<Status> getList() {
		Session session = factory.getCurrentSession();
		Query<Status> query = session.createQuery("FROM Status", Status.class);
		
		return query.getResultList();
	}

	@Override
	public void add(Status status) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(status);
	}

	@Override
	public void delete(int id) {
		Session session =  factory.getCurrentSession();
		Status entity = session.find(Status.class, id);
		session.remove(entity);
		
	}

	@Override
	public void edit(Status status) {
		Session session = factory.getCurrentSession();
		session.update(status);
	}

	@Override
	public Status findById(int id) {
		Session session = factory.getCurrentSession();
		return session.find(Status.class, id);
	}

}
