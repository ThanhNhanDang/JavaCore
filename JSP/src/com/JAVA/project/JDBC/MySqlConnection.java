package com.JAVA.project.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.cj.jdbc.Driver;


public class MySqlConnection {
	private static String url 		 = "jdbc:mysql://localhost:3306/jdbc"; // điền đường dẫn server đang chạy
	private static String username  = "root";
	private static String password  = "1234";
	
	//get connection
	
	public static Connection getConnection() {
		//Do connection qua mạng nên phải kiểm tra trường hợp rớt mạng
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//đường dẫn driver jdbc
			return DriverManager.getConnection(url, username, password);
		}catch (ClassNotFoundException e) { //kiểm tra lỗi
			System.out.println("Khong doc duoc driver jdbc");
		}
		catch (SQLException e) {
			System.out.println("Loi ket noi database.vui long kiem tra username va password");
		}
		return null;
	}
}
