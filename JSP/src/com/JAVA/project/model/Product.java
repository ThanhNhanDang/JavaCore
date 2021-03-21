package com.JAVA.project.model;

public class Product {
	public 	int	 		id;
	public 	String 		name;
	public 	String 		code;
	public 	String 		description;
	public 	float 		price;
	
	public Product(int id, String name, String code, String description, float price) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
		
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
