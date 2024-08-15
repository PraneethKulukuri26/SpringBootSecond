package com.praneeth_works.learningJWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praneeth_works.learningJWT.JWT.JwtUtils;
import com.praneeth_works.learningJWT.Utils.TestData;

import com.google.gson.*;

@RestController
public class TestJWT {
	
	@Autowired
	JwtUtils jwt;
	
	@GetMapping("/test_token")
	public String tokenGet(@RequestParam(name="user") String user) {
		return jwt.generateTokenFromUsername(user);
	}
	
	@GetMapping("/validate")
	public String token(@RequestHeader(name="token") String token) {
		return jwt.getUserNameFromJwtToken(token);
	}
	
	@GetMapping("/check")
	public String tokenValidate(@RequestHeader(name="token") String token) {
		return ""+jwt.validateJwtToken(token);
	}
	
	@PostMapping("/test_new")
	public String testNew(@RequestHeader(name="test") String test,@RequestBody TestData testData) {
		return new Gson().toJson(testData)+"\n"+test;
	}
	
	

}
