package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Product;
import com.myclass.repository.ProductRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class ProductRepositoryImpl implements ProductRepository {
	
	private SessionFactory sessionFactory;
	
	public ProductRepositoryImpl (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> findAll() {;
		Session session = sessionFactory.getCurrentSession();
		
		Query<Product> query = session.createQuery("FROM Product", Product.class);

		return query.getResultList();
	}

	public void save(Product entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	}
	public Product findById(int id) {
		Session session = sessionFactory.openSession();
		return session.find(Product.class, id);
	}
	
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product entity = session.find(Product.class, id);
		session.remove(entity);
	}

}
