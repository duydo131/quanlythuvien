package model;
import connect.Sql;

import java.sql.*;


public class MyConnection {
	public static Connection connection = null;

	public void driverTest() throws ClassCastException {
		try {
			Class.forName(Sql.DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ClassCastException("JDBC Driver not found" + e.getMessage());
		}
	}

	public Connection connectDB() throws  SQLException {
		driverTest();
		try {
			connection = DriverManager.getConnection(Sql.URL_DATABASE, Sql.USERNAME, Sql.PASSWORD);
			System.out.println("Connect DB successfully!");
		} catch (SQLException e) {
			throw new SQLException("Connect DB fail");
		}
		return connection;

	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			System.out.println("Connection is close");
		}
	}

	public PreparedStatement prepare(String sql) {
		System.out.println(sql);
		try {
			return connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PreparedStatement prepareUpdate(String sql) {
		System.out.println(sql);
		try {
			return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

