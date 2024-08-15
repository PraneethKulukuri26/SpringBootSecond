package com.praneeth_works.learningJWT.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praneeth_works.learningJWT.JDBC.Connect;
import com.praneeth_works.learningJWT.JWT.JwtUtils;
import com.praneeth_works.learningJWT.Utils.TestRequest;

import com.google.gson.*;

@Service
public class TestService {
	
	//@Autowired
	Connect con;
	
	@Autowired
	JwtUtils jwtUtils;

	public String saveData(TestRequest request) {
		try {
			con=new Connect();
			con.insertData("insert into testdb (`name`,`email`,`password`) values('"+request.getName()+"','"+request.getEmail()+"','"+request.getPassword()+"')");
			con.closeCon();
			return jwtUtils.generateTokenFromUsername(new Gson().toJson(request));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
}
