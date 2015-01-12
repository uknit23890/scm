package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bean.User;

/**
 * @author Vinay Singh Rawat Class for DAO operations
 */
public class UserDao {
	/**
	 * This method is to save user into database
	 * 
	 * @param com.bean.User
	 */
	public boolean saveUser(User user) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			String query = "insert into users (name,email,password,gender) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getGender());
			int result = stmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * To get Connection object
	 * @return java.sql.Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/webspringbasic", "root", "root");

	}

}
