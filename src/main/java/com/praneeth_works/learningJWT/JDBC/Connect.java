package com.praneeth_works.learningJWT.JDBC;

import java.sql.*;

import org.springframework.stereotype.Component;

//@Component
public class Connect {
	
	private Connection con;
	private Statement st;
	private ResultSet result;
	
	private String url;
	public  Connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_first_practice_project", "root", "*********");
		st=con.createStatement();
		System.out.println("connected");
	}
	
	public ResultSet getData(String query) throws SQLException {
		return st.executeQuery(query);
	}
	
	public int insertData(String query) throws SQLException {
		return st.executeUpdate(query);
	}
	
	public void closeCon() throws SQLException {
		st.close();
		con.close();
		System.out.println("closed");
	}
}