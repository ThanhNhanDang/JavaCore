package com.java.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {	
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
	
	@Column(name = "userId")
	private int userId;
	
	
	@ManyToOne()
	@JoinColumn(name = "userId" , updatable = false, insertable = false)
	private User user;
	
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	public Project() {}

	public Project(int id, String name, String starDate, String endDate, int userId, User user) {
	
		this.id = id;
		this.name = name;
		this.starDate = starDate;
		this.endDate = endDate;
		this.userId = userId;
		this.user = user;
	}

	public Project(String name, String starDate, String endDate, int userId, User user) {
		this.name = name;
		this.starDate = starDate;
		this.endDate = endDate;
		this.userId = userId;
		this.user = user;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
