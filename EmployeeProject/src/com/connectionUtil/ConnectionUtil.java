package com.connectionUtil;

import java.sql.*;


public class ConnectionUtil {
	
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	private String user = "GOKU";
	private String password = "goku2797";
	

	public Connection getConnection()
	{
		try
		{
			Class.forName(driverClassName);
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("Can not connect to Database.");
		}
		catch(SQLException e)
		{
			System.out.println("Can not connect to Database.");
		}
		return null;
	}

}
