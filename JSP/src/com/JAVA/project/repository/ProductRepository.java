package com.JAVA.project.repository;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JAVA.project.JDBC.MySqlConnection;
import com.JAVA.project.model.Product;


public class ProductRepository {
	public void testConnection() {
		Connection connection = MySqlConnection.getConnection();
		if (connection == null) {
			System.err.println("That bai");
		} else {
			System.out.println("Thanh cong");
		}
	}

	public List<Product> getAllProduct() {
		Connection connection = MySqlConnection.getConnection();
		if (connection == null) {
			return null;
		}
		String query = "SELECT * FROM jdbc.products";
		List<Product> listProduct = new LinkedList<Product>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			// ban đầu thằng result sẽ không trỏ vô ô đầu tiên
			while (results.next()) {
				Product produc = new Product();
				produc.id = results.getInt("id");
				produc.name = results.getNString("name");
				produc.code = results.getNString("code");
				produc.description = results.getNString("description");
				produc.price = results.getFloat("price");
				listProduct.add(produc);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listProduct;
	}
	public boolean getAdd(Product product) {
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "INSERT INTO jdbc.products (id, name, code, description, price) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, product.id);
			statement.setString(2, product.name);
			statement.setString(3, product.code);
			statement.setString(4, product.description);
			statement.setFloat(5, product.price);
			statement.executeUpdate();
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Product getUpdate(int id) {
		Product product = new Product();
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "SELECT * FROM jdbc.products WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				product.setId(result.getInt("id"));
				product.setCode(result.getString("code"));
				product.setName(result.getString("name"));
				product.setDescription(result.getString("description"));
				product.setPrice(result.getFloat("price"));
			}
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return product;
	}
	
	public int postUpdate(Product product) {
		int result = -1;
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "UPDATE products SET name = ?, code = ?, description = ?, price = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, product.getName());
			statement.setString(2, product.getCode());
			statement.setString(3, product.getDescription());
			statement.setFloat(4, product.getPrice());
			statement.setInt(5, product.getId());
			result = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public int postDelete(int id) {
		int result = -1;
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "DELETE FROM products WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

}
