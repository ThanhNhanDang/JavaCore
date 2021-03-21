package com.java.dto;


public class TaskDto {
	private int id;
	private String name;
	private String starDate;
	private String endDate;
	
	private int    projectId;
	private int    userId;
	private int    statusId;
	private String projectName;
	private String userName;
	private String statusName;
	
	public TaskDto() {}
	
	public TaskDto(int id,String name, String starDate, String endDate, int projectId, int userId, int statusId, String userName, String statusName, String projectName) {
		this.id = id;
		this.name = name;
		this.starDate = starDate;
		this.endDate= endDate;
		this.userId =userId;
		this.projectId = projectId;
		this.statusId = statusId;
		this.userName = userName;
		this.statusName = starDate;
		this.projectName = projectName;						
	}
	
	public TaskDto(String name, String starDate, String endDate, int projectId, int userId, int statusId, String userName, String statusName, String projectName) {
		this.name = name;
		this.starDate = starDate;
		this.endDate= endDate;
		this.userId =userId;
		this.projectId = projectId;
		this.statusId = statusId;
		this.userName = userName;
		this.statusName = starDate;
		this.projectName = projectName;						
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
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectName() {
		return projectName;
	}
}
