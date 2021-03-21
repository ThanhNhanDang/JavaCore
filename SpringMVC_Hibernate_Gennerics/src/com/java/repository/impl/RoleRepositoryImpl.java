package com.java.repository.impl;



import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Role;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl extends BaseRepositoryImpl<Role, Integer>{
	public RoleRepositoryImpl(SessionFactory factory) {
		super(factory, Role.class);
	}	

}
