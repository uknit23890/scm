package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class have bd configuration
 * @author Vinay Singh Rawat
 *
 */
public class DBManager {
	static Connection con;
	/**
	 * To get Connection object
	 * @return java.sql.Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");		
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/ajaxcall","root","root");
        
	}

}
