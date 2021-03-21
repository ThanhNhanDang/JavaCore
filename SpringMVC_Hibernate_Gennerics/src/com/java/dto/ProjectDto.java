package com.java.dto;

public class ProjectDto {
	private int id;
	private String name;
	private String starDate;
	private String endDate;
	private int userId;
	private String userName;
	
	public ProjectDto() {}
	
	public ProjectDto(int id, String name, String starDate, String endDate,int userId,String userName) {
		this.id = id;
		this.name = name;
		this.starDate = starDate;
		this.endDate= endDate;
		this.userName = userName;
		this.userId = userId;
	}
	public ProjectDto(String name, String starDate, String endDate,int userId,String userName) {	
		this.name = name;
		this.starDate = starDate;
		this.endDate= endDate;
		this.userName = userName;
		this.userId = userId;
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
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
}
