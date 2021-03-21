package com.java.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.dto.UserDto;
import com.java.entity.User;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer>{
	private SessionFactory factory;
	public UserRepositoryImpl(SessionFactory sessionFactory) {
		super(sessionFactory, User.class);
		// TODO Auto-generated constructor stub
		this.factory = sessionFactory;
	}
	public List<UserDto> getAllJoin() {
		Session session = factory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<UserDto> query = session.createQuery("SELECT new com.java.dto.UserDto(u.id, u.name, u.password, u.email, r.des, r.id)from User u inner join u.role r");
		return query.getResultList();
	}
}
