package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class CategoryRepositoryImpl implements CategoryRepository {
	
	private SessionFactory sessionFactory;
	
	public CategoryRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Category> findAll() {;
		Session session = sessionFactory.getCurrentSession();
		
		Query<Category> query = session.createQuery("FROM Category", Category.class);

		return query.getResultList();
	}

	public void save(Category entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	}
	public Category findById(int id) {
		Session session = sessionFactory.openSession();
		return session.find(Category.class, id);
	}
	
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category entity = session.find(Category.class, id);
		session.remove(entity);
	}
}
