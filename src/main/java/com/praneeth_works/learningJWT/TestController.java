package com.praneeth_works.learningJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneeth_works.learningJWT.Service.TestService;
import com.praneeth_works.learningJWT.Utils.TestRequest;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	TestService service;
	
	@PostMapping("/save")
	public String saveData(@RequestBody TestRequest request) {
		return service.saveData(request);
	}
	

}
