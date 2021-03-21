package com.project.jdbcCountrUser.model;

public class User extends Country{
	
	private String userId;
	private String loginName;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private String city;
	private String state;
	private String postalCode;
	private String role;
	private String country; 
	
	public User() {
		
	}
	
	public User(String id, String userId, String loginName, String password, String firstName, String lastName, String phone,
			String email, String address, String city, String state, String postalCode, String role, String country) {
		super(id);
		this.userId 		= userId;
		this.loginName		= loginName;
		this.password 		= password;
		this.firstName 		= firstName;
		this.lastName 		= lastName;
		this.phone 			= phone;
		this.email 			= email;
		this.address 		= address;
		this.city 			= city;
		this.state 			= state;
		this.postalCode 	= postalCode;
		this.role 			= role;
		this.country  		= country;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
}
