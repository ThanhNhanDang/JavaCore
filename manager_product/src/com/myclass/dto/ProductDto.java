package com.myclass.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.myclass.entity.Category;

public class ProductDto {
private int id;
	private String name;

	private float price;

	private String quantity;
	private int cateId;

	private Category category; //phải giống tên với
	public ProductDto() {}

	public ProductDto(int id, String name, float price, String quantity, int cateId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity =quantity;
		this.cateId = cateId;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
