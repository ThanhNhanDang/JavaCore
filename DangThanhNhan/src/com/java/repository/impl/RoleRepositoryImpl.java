package com.java.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Role;
import com.java.repository.RoleRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl implements RoleRepository{
	private SessionFactory factory;
	
	public RoleRepositoryImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	public List<Role> getList(){
		Session session = factory.getCurrentSession();
		Query<Role> query = session.createQuery("FROM Role", Role.class);
		return query.getResultList();
	}
	
	public void add(Role role) {
		Session session = factory.getCurrentSession();
		session.save(role);
	}
	
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		Role entity = session.find(Role.class, id);
		session.remove(entity);
	}
	
	public Role findById(int id) {
		Session session = factory.openSession();
		return session.find(Role.class, id);
	}
	
	public void edit(Role role) {
		Session session = factory.getCurrentSession();
		session.update(role);
	}

	

}
