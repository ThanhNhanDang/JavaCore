package com.project.jdbcCountrUser.service;

import java.util.List;

import com.project.jdbcCountrUser.model.*;
import com.project.jdbcCountrUser.repository.*;

public class ProjectService {
	private ProjectReponsitory reponsitory;

	public ProjectService() {
		reponsitory = new ProjectReponsitory();

	}

	public List<Country> getAllCountry() {
		return reponsitory.getAllCountry();
	}

	public User getUserAfterLoginSuccess(String user, String pass) {
		return reponsitory.getUserAfterLoginSuccess(user, pass);
	}
}
