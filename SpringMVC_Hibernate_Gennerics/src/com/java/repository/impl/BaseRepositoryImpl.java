package com.java.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.java.repository.BaseRepository;

@Transactional(rollbackOn = Exception.class)
public class BaseRepositoryImpl <T , K>implements BaseRepository<T, K> {

	private SessionFactory sessionFactory;
	private Class<T> clazz;
	
	public BaseRepositoryImpl(SessionFactory sessionFactory, Class<T> clazz) {
		this.sessionFactory = sessionFactory;
		this.clazz = clazz;
	}
		
	@Override
	public List<T> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<T> query = session.createQuery("FROM " + clazz.getSimpleName(), clazz);
		return query.getResultList();
	}

	@Override
	public void add(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
		
	}

	@Override
	public T findById(K id) {
		Session session = sessionFactory.openSession();
		return session.find(clazz, id);
	}

	@Override
	public void edit(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(K id) {
		Session session = sessionFactory.getCurrentSession();
		T entity = session.find(clazz, id);
		session.remove(entity);
		
	}
	
}
