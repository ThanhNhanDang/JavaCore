package com.project.jdbcCountrUser.model;

public class Country {
	protected String id;
	protected String name;
	
	public Country() {
		
	}
	public Country(String id) {
		this.id 	= id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
