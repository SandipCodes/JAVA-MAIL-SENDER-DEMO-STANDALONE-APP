package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/register")
	public String registerUser() {
		
		User u=new User();
		String message=null;
		
		u.setFirstName("SACHIN");
		u.setLastName("HUMBE");
		u.setEmail("sandiphumbe878@gmail.com");
		
		message=service.saveUser(u);
		
		return message;
	}
}//class
