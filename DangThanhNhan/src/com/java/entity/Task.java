package com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "startDate")
	private String starDate;
	
	@Column(name = "endDate")
	private String endDate;
	
	public Task() {}
	
	public Task(int id,String name, String starDate, String endDate) {
		this.id = id;
		this.name = name;
		this.starDate = starDate;
		this.endDate= endDate;
						
	}
	
	public Task(String name, String starDate, String endDate) {
		
		this.name = name;
		this.starDate = starDate;
		this.endDate= endDate;
						
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarDate() {
		return starDate;
	}

	public void setStarDate(String starDate) {
		this.starDate = starDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
