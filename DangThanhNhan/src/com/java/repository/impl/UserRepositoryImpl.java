package com.java.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.User;
import com.java.repository.UserRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class UserRepositoryImpl implements UserRepository{
	SessionFactory factory;
	public UserRepositoryImpl(SessionFactory factory) {
		this.factory = factory;
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<User> getList() {
		Session session = factory.getCurrentSession();
		Query<User> query = session.createQuery("FROM User", User.class);
		
		return query.getResultList();
	}

	@Override
	public void add(User user) {
		Session session = factory.getCurrentSession();
		session.save(user);
		
	}

	@Override
	public void delete(int id) {
		Session session =  factory.getCurrentSession();
		User entity = session.find(User.class, id);
		session.remove(entity);
		
	}
	
	@Override
	public void edit(User user) {
		Session session = factory.getCurrentSession();
		session.update(user);
	}

	@Override
	public User findById(int id) {
		Session session = factory.getCurrentSession();
		return session.find(User.class, id);
	}
	
}
