package com.project.jdbcCountrUser.repository;

import com.project.jdbcCountrUser.model.*;
import com.project.jdbcCountrUser.SQLConnection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ProjectReponsitory {
	public List<Country> getAllCountry(){
		Connection con = MySQLConnection.getConnection();
		if (con == null)
			return null;
		
		List<Country> listCountry = new LinkedList<Country>();
		try {
			String query = "SELECT * FROM COUNTRY";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Country country = new Country();
				country.setId(result.getNString("ID"));
				country.setName(result.getNString("NAME"));
				listCountry.add(country);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCountry;
	}
	
	public User getUserAfterLoginSuccess(String user, String pass) {
		Connection con = MySQLConnection.getConnection();
		User userBy = new User();
		try {
			
			String query = "SELECT * FROM USER WHERE LOGIN_NAME = ?";
			PreparedStatement state = con.prepareStatement(query);
			state.setString(1, user);
			
			ResultSet result = state.executeQuery();
			while(result.next()) {
				userBy.setAddress(result.getNString("ADDRESS"));
				userBy.setId(result.getNString("USER_ID"));
				userBy.setLoginName(result.getNString("LOGIN_NAME"));
				userBy.setFirstName(result.getNString("FIRST_NAME"));
				userBy.setLastName(result.getNString("LAST_NAME"));
				userBy.setPhone(result.getNString("PHONE"));
				userBy.setEmail(result.getNString("EMAIL"));
				userBy.setCity(result.getNString("CITY"));
				userBy.setState(result.getNString("STATE"));
				userBy.setPostalCode(result.getNString("POSTAL_CODE"));
				userBy.setPassword(result.getNString("PASSWORD"));
				userBy.setRole(result.getNString("ROLE"));
				userBy.setCountry(result.getNString("COUNTRY"));
			}
			
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(userBy.getAddress());
		return userBy;
	}
}
