package com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "projectId")
	private int projectId;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "statusId")
	private int statusId;
	
	@ManyToOne()
	@JoinColumn(name = "projectId", insertable = false, updatable = false)
	private Project project;
	
	
	@ManyToOne()
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "statusId", insertable = false, updatable = false)
	private Status status;
	
	public Task() {}

	public Task(int id, String name, String starDate, String endDate, int projectId, int userId, int statusId,
			Project project, User user, Status status) {
		this.id = id;
		this.name = name;
		this.starDate = starDate;
		this.endDate = endDate;
		this.projectId = projectId;
		this.userId = userId;
		this.statusId = statusId;
		this.project = project;
		this.user = user;
		this.status = status;
	}

	public Task(String name, String starDate, String endDate, int projectId, int userId, int statusId, Project project,
			User user, Status status) {
	
		this.name = name;
		this.starDate = starDate;
		this.endDate = endDate;
		this.projectId = projectId;
		this.userId = userId;
		this.statusId = statusId;
		this.project = project;
		this.user = user;
		this.status = status;
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
