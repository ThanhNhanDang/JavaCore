package com.java.repository.impl;


import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.java.entity.Status;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class StatusRepositoryImpl extends BaseRepositoryImpl<Status, Integer>{
	public StatusRepositoryImpl(SessionFactory factory) {
		super(factory, Status.class);
	}
}
