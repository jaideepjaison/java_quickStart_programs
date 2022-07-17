package com.java.personData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		ResourceBundle rb= ResourceBundle.getBundle("person");
		String driver=rb.getString("driver");
		String url=rb.getString("url");
		String user=rb.getString("user");
		String password=rb.getString("password");
		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}

}
