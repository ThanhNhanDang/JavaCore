package com.java.dto;


public class TaskDto {
private int id;
	

	private String name;
	

	private String starDate;
	

	private String endDate;
	
	public TaskDto() {}
	
	public TaskDto(int id,String name, String starDate, String endDate) {
		this.id = id;
		this.name = name;
		this.starDate = starDate;
		this.endDate= endDate;
						
	}
	
	public TaskDto(String name, String starDate, String endDate) {
		
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
