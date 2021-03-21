package com.java.dto;

public class UserDto {
	private int id;
	private String name;
	private String password;
	private String email;
	private int roleId;
	private String roleName;
	public UserDto(int id, String name, String email, String pass, String roleName, int roleId) {
		this.roleId = roleId;
		this.email = email;
		this.roleName = roleName;
		this.password = pass;
		this.id = id;
		this.name = name;
	}
	public UserDto(String name, String email, String pass, String roleName, int roleId) {
		this.roleId = roleId;
		this.email = email;
		this.roleName = roleName;
		this.password = pass;
		this.name = name;
	}
	
	public UserDto() {
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
}	
